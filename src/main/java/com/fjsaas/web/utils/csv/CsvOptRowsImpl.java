package com.fjsaas.web.utils.csv;

import java.util.List;

public class CsvOptRowsImpl implements CsvOptRows{

	private  static final String SUCCESS_FLAG = "success";
	@Override
	public String optRows(int curRow, List<String> row) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row.size(); i++) {
			try {
				int num = Integer.parseInt(row.get(i));
			} catch (NumberFormatException e) {
				sb.append(curRow+"行"+(i+1)+"列:"+row.get(i)+"不能转换为数值;");
				//return i+"列:"+row.get(i)+"不能转换为数值";
			}
		}
		if(!sb.toString().equals("")){
			return sb.toString();
		}
		return SUCCESS_FLAG;
	}

}
