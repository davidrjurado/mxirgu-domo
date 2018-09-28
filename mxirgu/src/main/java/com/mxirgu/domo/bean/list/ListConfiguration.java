package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListConfiguration {
	
	private ArrayList<String> columns;
	private ArrayList<Boolean> sortableColumns;
	private ArrayList<String> filtereableComuns;
	
	public ArrayList<String> getColumns() {
		return columns;
	}
	public void setColumns(ArrayList<String> columns) {
		this.columns = columns;
	}
	public ArrayList<Boolean> getSortableColumns() {
		return sortableColumns;
	}
	public void setSortableColumns(ArrayList<Boolean> sortableColumns) {
		this.sortableColumns = sortableColumns;
	}
	public ArrayList<String> getFiltereableComuns() {
		return filtereableComuns;
	}
	public void setFiltereableComuns(ArrayList<String> filtereableComuns) {
		this.filtereableComuns = filtereableComuns;
	}
	
	
	
}
