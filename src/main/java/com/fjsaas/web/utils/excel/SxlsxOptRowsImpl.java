package com.fjsaas.web.utils.excel;

import java.util.List;

public class SxlsxOptRowsImpl implements OptRows{

	private  static final String SUCCESS_FLAG = "success";

	@Override
	public OptRowResutl optRows(int sheetIndex, int curRow, List<String> row) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*public String optRows(int sheetIndex, int curRow, List<String> row) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < row.size(); i++) {
			try {
				if(i == 3){
					int num = Integer.parseInt(row.get(i));
					if(num !=0 || num != 1){
						sb.append(curRow+"行"+(i+1)+"列:"+row.get(i)+"导入数据有误，编码类型只能为0或者1");
					}
				}
				if(i > 6 && i < 9){
					float f = Float.parseFloat(row.get(i));
				}
				int num = Integer.parseInt(row.get(i));
			} catch (NumberFormatException e) {
				sb.append(curRow+"行"+(i+1)+"列:"+row.get(i)+"导入数据类型有误，必须为数值 类型");
			}
		}
		if(!sb.toString().equals("")){
			return sb.toString();
		}
		return SUCCESS_FLAG;
	}*/

	

}
