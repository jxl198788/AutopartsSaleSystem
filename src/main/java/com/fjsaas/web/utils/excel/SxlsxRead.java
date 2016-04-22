package com.fjsaas.web.utils.excel;

import java.util.ArrayList;
import java.util.List;

public class SxlsxRead extends SxlsxAbstract {

	//数据处理解析数据的接口
	private  OptRows sxlsxOptRows;
	//处理数据总数
	private int optRows_sum = 0;
	//处理数据成功数量
	private int optRows_success = 0;
	//处理数据失败数量
	private int optRows_failure = 0;
	//成功数据
	private List<List<String>> successrows;
	//失败数据
	private List<List<String>> failrows;
	//失败原因
	private List<String> failmsgs ;
	
	public SxlsxRead(OptRows sxlsxOptRows){
		this.sxlsxOptRows = sxlsxOptRows;
		this.failrows = new ArrayList<List<String>>();
		this.failmsgs = new ArrayList<String>();
		this.successrows = new ArrayList<List<String>>();
	}
	
	@Override
	public void ProcessRow(int sheetIndex, int curRow, List<String> row){
		optRows_sum++;
		try {
			String result = sxlsxOptRows.optRows(sheetIndex, curRow, row);
			if(result == "success"){
				optRows_success++;
				successrows.add(row);
			}else{
				optRows_failure++;
				failrows.add(row);
				failmsgs.add(result);
			}
		} catch (Exception e) {
			optRows_failure++;
			failrows.add(row);
			failmsgs.add(curRow+"行：插入时发生未知错误");
			e.printStackTrace();
		}		
	}

	@Override
	public String ProcessCell(int sheetIndex, int curRow, int curColumn,
			String position, String value){
		//System.out.println(value);
		return value;
	}

	public int getOptRows_sum() {
		return optRows_sum;
	}

	public void setOptRows_sum(int optRows_sum) {
		this.optRows_sum = optRows_sum;
	}

	public int getOptRows_success() {
		return optRows_success;
	}

	public void setOptRows_success(int optRows_success) {
		this.optRows_success = optRows_success;
	}

	public int getOptRows_failure() {
		return optRows_failure;
	}

	public void setOptRows_failure(int optRows_failure) {
		this.optRows_failure = optRows_failure;
	}

	public List<List<String>> getSuccessrows() {
		return successrows;
	}

	public void setSuccessrows(List<List<String>> successrows) {
		this.successrows = successrows;
	}

	public List<List<String>> getFailrows() {
		return failrows;
	}

	public void setFailrows(List<List<String>> failrows) {
		this.failrows = failrows;
	}

	public List<String> getFailmsgs() {
		return failmsgs;
	}

	public void setFailmsgs(List<String> failmsgs) {
		this.failmsgs = failmsgs;
	}
	
	

}
