package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListConfiguration {
	
	private ArrayList<ListColumn> columnsList;
	
	
	public ListConfiguration() {
		
	}


	public ArrayList<ListColumn> getColumnsList() {
		return columnsList;
	}


	public void setColumnsList(ArrayList<ListColumn> columnsList) {
		this.columnsList = columnsList;
	}
	
	
}
