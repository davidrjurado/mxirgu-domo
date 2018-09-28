package com.mxirgu.domo.bean.list;

public enum ListSort {
	ASC(0), DESC(1);

	private final int value;

	private ListSort(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
