package com.mxirgu.domo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.AuditTrail;
import com.mxirgu.domo.bean.AuditTrailEntity;

@Repository
@Transactional
public class AuditTrailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addAuditTrail(AuditTrail a) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(a);
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditTrail> getAudiTrailByEntity(AuditTrailEntity entity) {
		Session session = this.sessionFactory.getCurrentSession();
		List<AuditTrail> auditList = session.createQuery("from AuditTrail").list();
		return auditList;
	}

	public AuditTrail getAuditTrailById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		AuditTrail auditTrail = (AuditTrail) session.get(AuditTrail.class,id);
		return auditTrail;
	}
}
