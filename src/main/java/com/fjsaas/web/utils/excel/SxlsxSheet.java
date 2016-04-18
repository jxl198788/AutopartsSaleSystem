package com.fjsaas.web.utils.excel;

import java.util.ArrayList;

public class SxlsxSheet {

	// 行号
	private int rowIndex = 0;
	private boolean isNewRow = false;

	// 列号
	private int columnIndex = 0;
	// 最大行号
	private int lastRowNumber;
	// 最大列号
	private int lastColumnNumber;
	// 标题行号 为0的时候没有标题行
	//private int titleRowIndex = 1;

	private ArrayList<String> titleRow = new ArrayList<String>();
	private ArrayList<String> currentRow;
	private ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
	
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public void addRowIndex(int num){
		this.rowIndex = this.rowIndex + num;
	}
	public boolean isNewRow() {
		return isNewRow;
	}
	public void setNewRow(boolean isNewRow) {
		this.isNewRow = isNewRow;
	}
	public int getColumnIndex() {
		return columnIndex;
	}
	public void setColumnIndex(int columnIndex) {
		this.columnIndex = columnIndex;
	}
	public void addColumnIndex(int num){
		this.columnIndex = columnIndex + num;
	}
	public int getLastRowNumber() {
		return lastRowNumber;
	}
	public void setLastRowNumber(int lastRowNumber) {
		this.lastRowNumber = lastRowNumber;
	}
	public int getLastColumnNumber() {
		return lastColumnNumber;
	}
	public void setLastColumnNumber(int lastColumnNumber) {
		this.lastColumnNumber = lastColumnNumber;
	}
/*	public int getTitleRowIndex() {
		return titleRowIndex;
	}
	public void setTitleRowIndex(int titleRowIndex) {
		this.titleRowIndex = titleRowIndex;
	}*/
	public ArrayList<String> getTitleRow() {
		return titleRow;
	}
	public void setTitleRow(ArrayList<String> titleRow) {
		this.titleRow = titleRow;
	}
	public ArrayList<String> getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(ArrayList<String> currentRow) {
		this.currentRow = currentRow;
	}
	public ArrayList<ArrayList<String>> getDataList() {
		return dataList;
	}
	public void setDataList(ArrayList<ArrayList<String>> dataList) {
		this.dataList = dataList;
	}
	
	
}
