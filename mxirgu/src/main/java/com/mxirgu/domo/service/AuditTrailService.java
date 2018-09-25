package com.mxirgu.domo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mxirgu.domo.bean.AuditTrail;
import com.mxirgu.domo.bean.AuditTrailEntity;
import com.mxirgu.domo.dao.AuditTrailDAO;
import com.mxirgu.domo.interfaces.AuditTrailInt;

@Service
@ComponentScan(basePackages = { "com.mxirgu.domo" })
public class AuditTrailService implements AuditTrailInt {
	@Autowired
	private AuditTrailDAO auditTrailDAO;
	
	@Override
	@Transactional
	public void registerAudit(AuditTrail a) {
		this.auditTrailDAO.addAuditTrail(a);
	}

	@Override
	@Transactional
	public List<AuditTrail> listAuditTrailByEntity(AuditTrailEntity entity) {
		
		return this.auditTrailDAO.getAudiTrailByEntity(entity);
	}

	@Override
	@Transactional
	public AuditTrail getAuditTrailById(Long id) {
		return this.auditTrailDAO.getAuditTrailById(id);
	}

}
