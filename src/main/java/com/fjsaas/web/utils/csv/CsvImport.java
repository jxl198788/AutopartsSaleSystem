package com.fjsaas.web.utils.csv;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.csvreader.CsvReader;

public class CsvImport {

	private CsvOptRows csvOptRows;
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
	
	public CsvImport(CsvOptRows csvOptRows){
		this.csvOptRows = csvOptRows;
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
			String result = csvOptRows.optRows(curRow, row);
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
	
	public static void main(String[] args) throws Exception {
		CsvImport csvImport = new CsvImport(new CsvOptRowsImpl());
		csvImport.ReadCSV("d:/test.csv", true);
		System.out.println("Ok");
	}
}
