package com.mxirgu.domo.bean.list;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class ListData {
	
	private ArrayList<ArrayList<ListCell>> recordList;
	private int totalRecord;
	private int from;
	private int to;
	private int pages;
	
	
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public ArrayList<ArrayList<ListCell>> getRecordList() {
		return recordList;
	}
	public void setRecordList(ArrayList<ArrayList<ListCell>> recordList) {
		this.recordList = recordList;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
}
