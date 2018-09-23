package com.mxirgu.domo.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="audittrail")
public class AuditTrail {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private User user;
	private Date processDate;
	private Integer action;
	private String message;
	private byte[] attachment;
	private String attachmentType;
	private Integer entity;
	private String entityBefore;
	private String entityAfter;
	
	public AuditTrail() {

	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getProcessDate() {
		return processDate;
	}
	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}
	public Integer getAction() {
		return action;
	}
	public void setAction(Integer action) {
		this.action = action;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}
	public String getAttachmentType() {
		return attachmentType;
	}
	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}
	public Integer getEntity() {
		return entity;
	}
	public void setEntity(Integer entity) {
		this.entity = entity;
	}
	public String getEntityBefore() {
		return entityBefore;
	}
	public void setEntityBefore(String entityBefore) {
		this.entityBefore = entityBefore;
	}
	public String getEntityAfter() {
		return entityAfter;
	}
	public void setEntityAfter(String entityAfter) {
		this.entityAfter = entityAfter;
	}
	
}
