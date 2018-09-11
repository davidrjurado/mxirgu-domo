package com.mxirgu.domo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.User;


@Repository
public class UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("User saved successfully, Person Details="+p);
	}


	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = session.createQuery("from users").list();
		for(User p : personsList){
			logger.info("User List::"+p);
		}
		return personsList;
	}

	public User getUserById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, id);
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
	public User getUserByLogin(String login) {
		Session session = this.sessionFactory.getCurrentSession();		
		User p = (User) session.load(User.class, login);
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}
	public void removeUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

}
