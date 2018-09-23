package com.mxirgu.domo.bean;

public enum AuditTrailAction {
	CREATE(0), UPDATE(1), DELETE(1);

	private final int value;

	private AuditTrailAction(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
