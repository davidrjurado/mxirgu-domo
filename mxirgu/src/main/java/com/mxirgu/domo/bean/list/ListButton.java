package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

public class ListButton {
	
	private Enum<ListAction> action;
	private String requestMapping;
	private ArrayList<String> parameters;
		
	public ListButton(Enum<ListAction> action, String requestMapping) {
		this.action = action;
		this.requestMapping = requestMapping;
	}
	public String getRequestMapping() {
		return requestMapping;
	}
	public void setRequestMapping(String requestMapping) {
		this.requestMapping = requestMapping;
	}
	public ArrayList<String> getParameters() {
		return parameters;
	}
	public void setParameters(ArrayList<String> parameters) {
		this.parameters = parameters;
	}
	
	public Enum<ListAction> getAction() {
		return action;
	}
	public void setAction(Enum<ListAction> action) {
		this.action = action;
	}
	
	

}
