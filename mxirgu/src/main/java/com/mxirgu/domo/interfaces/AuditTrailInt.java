package com.mxirgu.domo.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mxirgu.domo.bean.AuditTrail;
import com.mxirgu.domo.bean.AuditTrailEntity;

@Service
public interface AuditTrailInt {

	public void registerAudit(AuditTrail u);

	public List<AuditTrail> listAuditTrailByEntity(AuditTrailEntity entity);

	public AuditTrail getAuditTrailById(Long id);
		
}
