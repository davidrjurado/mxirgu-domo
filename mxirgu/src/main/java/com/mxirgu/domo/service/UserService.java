package com.mxirgu.domo.service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.AuditTrail;
import com.mxirgu.domo.bean.AuditTrailAction;
import com.mxirgu.domo.bean.AuditTrailEntity;
import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.UserAuthenticated;
import com.mxirgu.domo.bean.list.ListCell;
import com.mxirgu.domo.bean.list.ListCriteria;
import com.mxirgu.domo.bean.list.ListData;
import com.mxirgu.domo.dao.UserDAO;
import com.mxirgu.domo.interfaces.AuditTrailInt;
import com.mxirgu.domo.interfaces.UserServiceInt;

@Service
@ComponentScan(basePackages = { "com.mxirgu.domo" })
public class UserService implements UserServiceInt {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private AuditTrailInt auditTrailInt;
	@Autowired
	private AuditTrail auditTrail;
	@Autowired
	private ListData listData;

	@Override
	@Transactional
	public void addUser(User u) {
		try {
		
			this.userDAO.addUser(u);
			StringWriter sw = new StringWriter();
			UserAuthenticated userAuthenticated = (UserAuthenticated)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			auditTrail.setUser(new User(userAuthenticated.getId()));
			auditTrail.setAction(AuditTrailAction.CREATE.getValue());
			auditTrail.setProcessDate(new Date());
			auditTrail.setEntity(AuditTrailEntity.USER.getValue());

			JAXBContext contexto = JAXBContext.newInstance(User.class);
			Marshaller marshaller = contexto.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(u,sw);

			auditTrail.setEntityAfter(sw.toString());

			this.auditTrailInt.registerAudit(auditTrail);
		} catch (JAXBException e) {
			System.out.println("error");		
		}
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public ListData listUsers(ListCriteria listCriteria) {
		
		ArrayList<ArrayList<ListCell>> rows = new ArrayList<ArrayList<ListCell>>();
		List<User> users = this.userDAO.listUsers(listCriteria);
		
		for(User user : users) {
			rows.add(user.listRow());
		}
		listData.setRecordList(rows);
		Integer total = this.userDAO.countUsers(listCriteria);
		listData.setTotalRecord(total);
		
		Integer pages = total/listCriteria.getRecordsDisplayed();
		listData.setPages(pages);
		
		if (listCriteria.getPageNumber() == 1) {
			listData.setFrom(1);	
		} else {
			listData.setFrom((listCriteria.getPageNumber() -1) * listCriteria.getRecordsDisplayed());
		}
				
		if (users.size() < listCriteria.getRecordsDisplayed()) {
			listData.setTo(users.size());
		} else {
			listData.setTo(listCriteria.getPageNumber() * listCriteria.getRecordsDisplayed());
		}
		
		
		return listData;
	}
	
	@Override
	@Transactional
	public ArrayList<Pair<String, String>> getValuesByColumn (String column){
		
		List<String> filters = this.userDAO.getValuesByColumn(column);
		ArrayList<Pair<String, String>> filtersColumn = new ArrayList<Pair<String, String>>();
		
		String filterBy = null;
		for (Object filter : filters) {
			
			if (filter instanceof Integer) {
				filterBy = ((Integer)filter).toString();
			} else {
				filterBy = filter.toString();
			}
				
			Pair<String, String> pair = new Pair<String, String>(filterBy, filterBy);
			filtersColumn.add(pair);
		}
		return filtersColumn;
	}

	@Override
	@Transactional
	public User getUserById(Integer id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public User getUserByLogin(String login) {
		return this.userDAO.getUserByLogin(login);
	}

	@Override
	@Transactional
	public void removeUser(Integer id) {
		this.userDAO.removeUser(id);
	}

}
