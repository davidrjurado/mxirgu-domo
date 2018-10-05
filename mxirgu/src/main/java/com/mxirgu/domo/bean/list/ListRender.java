package com.mxirgu.domo.bean.list;

public enum ListRender {
	TEXT(0), CHECKBOX(1), DELETE_BUTTON(2),EDIT_BUTTON(3);

	private final int value;

	private ListRender(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
