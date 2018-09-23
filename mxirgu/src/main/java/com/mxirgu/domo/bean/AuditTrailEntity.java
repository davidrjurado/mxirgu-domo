package com.mxirgu.domo.bean;

public enum AuditTrailEntity {

	USER(1);

	private final int value;

	private AuditTrailEntity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
