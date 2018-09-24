package com.mxirgu.domo.service;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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

			JAXBContext contexto = JAXBContext.newInstance(u.getClass());
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
	public List<User> listUsers() {
		return this.userDAO.listUsers();
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
