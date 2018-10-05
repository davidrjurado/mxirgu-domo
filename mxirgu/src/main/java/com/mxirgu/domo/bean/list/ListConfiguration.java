package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListConfiguration {
	private String entity;
	private ArrayList<ListButton> buttonList;
	private ArrayList<ListColumn> columnsList;
	
	public ListConfiguration() {
		
	}


	public String getEntity() {
		return entity;
	}


	public void setEntity(String entity) {
		this.entity = entity;
	}


	public ArrayList<ListColumn> getColumnsList() {
		return columnsList;
	}


	public void setColumnsList(ArrayList<ListColumn> columnsList) {
		this.columnsList = columnsList;
	}


	public ArrayList<ListButton> getButtonList() {
		return buttonList;
	}


	public void setButtonList(ArrayList<ListButton> buttonList) {
		this.buttonList = buttonList;
	}
	
	
}
