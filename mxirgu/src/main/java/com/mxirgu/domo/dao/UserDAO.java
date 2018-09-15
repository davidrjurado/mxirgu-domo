package com.mxirgu.domo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.User;

@Repository
@Transactional
public class UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);

	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> personsList = session.createQuery("from users").list();
		return personsList;
	}

	public User getUserById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		return p;
	}

	public User getUserByLogin(String login) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("id"), 0l));
		Query<User> q = session.createQuery(query);
		User p = q.getSingleResult();
		return p;
	}

	public void removeUser(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}

	}

}
