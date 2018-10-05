package com.mxirgu.domo.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditTrail.class)
public abstract class AuditTrail_ {

	public static volatile SingularAttribute<AuditTrail, String> entityAfter;
	public static volatile SingularAttribute<AuditTrail, byte[]> attachment;
	public static volatile SingularAttribute<AuditTrail, String> attachmentType;
	public static volatile SingularAttribute<AuditTrail, Date> processDate;
	public static volatile SingularAttribute<AuditTrail, Integer> action;
	public static volatile SingularAttribute<AuditTrail, Long> id;
	public static volatile SingularAttribute<AuditTrail, String> message;
	public static volatile SingularAttribute<AuditTrail, User> user;
	public static volatile SingularAttribute<AuditTrail, Integer> entity;
	public static volatile SingularAttribute<AuditTrail, String> entityBefore;

	public static final String ENTITY_AFTER = "entityAfter";
	public static final String ATTACHMENT = "attachment";
	public static final String ATTACHMENT_TYPE = "attachmentType";
	public static final String PROCESS_DATE = "processDate";
	public static final String ACTION = "action";
	public static final String ID = "id";
	public static final String MESSAGE = "message";
	public static final String USER = "user";
	public static final String ENTITY = "entity";
	public static final String ENTITY_BEFORE = "entityBefore";

}

