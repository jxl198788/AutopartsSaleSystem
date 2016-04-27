package com.fjsaas.web.utils.csv;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.csvreader.CsvReader;
import com.fjsaas.web.utils.excel.OptRowResutl;
import com.fjsaas.web.utils.excel.OptRows;
import com.fjsaas.web.utils.excel.SxlsxOptRowsImpl;

public class CsvImport {

	private OptRows optRows;
	private List<List<String>> dataList = new ArrayList<List<String>>();//用来保存数据
	private List<String> titleRow = new ArrayList<String>();//用來保存表頭
	//处理数据总数
	private int optRows_sum = 0;
	//处理数据成功数量
	private int optRows_success = 0;
	//处理数据失败数量
	private int optRows_failure = 0;
	//成功数据
	private List<List<String>> successrows = new ArrayList<List<String>>();
	//失败数据
	private List<List<String>> failrows = new ArrayList<List<String>>();
	//失败原因
	private List<String> failmsgs = new ArrayList<String>();
	
	private int counter = 0;
	
	private List<Object> successBeans = new ArrayList<Object>();
	


	public OptRows getOptRows() {
		return optRows;
	}

	public void setOptRows(OptRows optRows) {
		this.optRows = optRows;
	}

	public List<List<String>> getDataList() {
		return dataList;
	}

	public void setDataList(List<List<String>> dataList) {
		this.dataList = dataList;
	}

	public List<String> getTitleRow() {
		return titleRow;
	}

	public void setTitleRow(List<String> titleRow) {
		this.titleRow = titleRow;
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

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public CsvImport(OptRows optRows){
		this.optRows = optRows;
	}
	
	public void ReadCSV(String filePath,boolean isReadHeader) throws Exception{

         CsvReader reader = new CsvReader(filePath,',',Charset.forName("GBK"));    //一般用这编码读就可以了    
          
         if(isReadHeader){
        	 counter++;
        	 reader.readHeaders();
        	 titleRow = Arrays.asList(reader.getHeaders());
         }
	      
	     while(reader.readRecord()){ //逐行读入除表头的数据    
	    	 counter++;
	    	 List<String> row = Arrays.asList(reader.getValues());
	    	 processRow(counter, row);
	    	 dataList.add(row);	    	 
	     }            
	     reader.close();
	}
	
	public void processRow(int curRow, List<String> row){
		optRows_sum++;
		try {
			OptRowResutl rowResutl = optRows.optRows(1,curRow, row);
			if(OptRowResutl.SUCCESS_FLAG.equals(rowResutl.getResult())){
				optRows_success++;
				successrows.add(row);
				successBeans.add(rowResutl.getTarget());
			}else{
				optRows_failure++;
				failrows.add(row);
				failmsgs.add(rowResutl.getResult());
			}
		} catch (Exception e) {
			optRows_failure++;
			failrows.add(row);
			failmsgs.add(curRow+"行：插入时发生未知错误");
			e.printStackTrace();
		}		
	}
	
	public List<Object> getSuccessBeans() {
		return successBeans;
	}

	public void setSuccessBeans(List<Object> successBeans) {
		this.successBeans = successBeans;
	}

	public static void main(String[] args) throws Exception {
		CsvImport csvImport = new CsvImport(new SxlsxOptRowsImpl());
		csvImport.ReadCSV("d:/test.csv", true);
		System.out.println("Ok");
	}
	
	
}
