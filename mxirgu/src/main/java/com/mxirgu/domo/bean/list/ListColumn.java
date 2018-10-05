package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

public class ListColumn {
	
	private String title;
	private String dbField;
	private Boolean sortable;
	private Boolean filtereable;
	private ArrayList<String> filtereableBy;
	
	public ListColumn(String title, String dbField, Boolean sortable, Boolean filtereable) {
		this.title=title;
		this.dbField=dbField;
		this.sortable=sortable;
		this.filtereable=filtereable;
	}
	
	public ArrayList<String> getFiltereableBy() {
		return filtereableBy;
	}

	public void setFiltereableBy(ArrayList<String> filtereableBy) {
		this.filtereableBy = filtereableBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDbField() {
		return dbField;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public Boolean getSortable() {
		return sortable;
	}

	public void setSortable(Boolean sortable) {
		this.sortable = sortable;
	}

	public Boolean getFiltereable() {
		return filtereable;
	}

	public void setFiltereable(Boolean filtereable) {
		this.filtereable = filtereable;
	}
	
}
