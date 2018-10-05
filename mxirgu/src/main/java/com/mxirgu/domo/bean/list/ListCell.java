package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

public class ListCell {
	
	private Enum<ListRender> render;
	private Object field;
	
	
	public ListCell(Enum<ListRender> render, Object field) {
		this.render=render;
		this.field=field;
		
	}

	public Enum<ListRender> getRender() {
		return render;
	}


	public void setRender(Enum<ListRender> render) {
		this.render = render;
	}


	public Object getField() {
		return field;
	}


	public void setField(Object field) {
		this.field = field;
	}
	
	
	
}
