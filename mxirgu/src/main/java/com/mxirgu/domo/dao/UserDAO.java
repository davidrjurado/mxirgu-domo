package com.mxirgu.domo.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.User;
import com.mxirgu.domo.bean.list.ListCriteria;
import com.mxirgu.domo.bean.list.ListSort;

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

	public List<User> listUsers(ListCriteria listCriteria) {

		Session session = this.sessionFactory.getCurrentSession();
		// Sort criterion
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		if (listCriteria.getSortDirection() == ListSort.DESC.getValue()) {
			cq.orderBy(cb.desc(root.get(listCriteria.getSortBy())));
		} else {
			cq.orderBy(cb.asc(root.get(listCriteria.getSortBy())));
		}
		
		Query query = session.createQuery(cq);
		query.setFirstResult((listCriteria.getPageNumber() - 1) * listCriteria.getRecordsDisplayed());
		query.setMaxResults(listCriteria.getRecordsDisplayed());
		List<User> personsList = query.getResultList();
		return personsList;
	}
	
	public Integer countUsers(ListCriteria listCriteria) {

		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		
		Root<User> root = query.from(User.class);
		Query<User> q = session.createQuery(query);
		return new Integer(q.getResultList().size());
		
	}
	
	

	public List<String> getValuesByColumn(String column) {
		Session session = this.sessionFactory.getCurrentSession();
		StringBuilder query = new StringBuilder("SELECT distinct ");
		query.append(column);
		query.append(" from User");

		Query filters = session.createQuery(query.toString());
		List<String> list = filters.list();

		return list;
	}

	public User getUserById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.get(User.class, id);
		return p;
	}

	public User getUserByLogin(String login) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("login"), login));
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
