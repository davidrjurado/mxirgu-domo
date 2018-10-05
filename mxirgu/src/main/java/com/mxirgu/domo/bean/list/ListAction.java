package com.mxirgu.domo.bean.list;

public enum ListAction {
	NEW(0), AUDITTRAIL(1),EDIT(2),DELETE(3);

	private final int value;

	private ListAction(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
