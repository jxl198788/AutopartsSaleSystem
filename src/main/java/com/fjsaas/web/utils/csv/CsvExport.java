package com.fjsaas.web.utils.csv;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.csvreader.CsvWriter;
import com.fjsaas.web.utils.MyUtil;

public class CsvExport {

		/** 导出文件行数 */
		private int rownum;
		/** 导出文件列数 */
		private int colnum;

		/** 导出文件的存放路径 */
		private String filePath;
		/** 下载导出文件的路径 */
		private String fileWebPath;
		/**文件名称前缀*/
		private String filePrefix;
		/**导出文件全路径*/
		private String fileAllPath;
		/** 导出文件列标题 */
		private List<String> fieldNames;
		/**导出文件每列代码，用于反射获取对象属性值*/
		private List<String> fieldCodes;
		
		private String[] titleRow;
		
		private List<String[]> dataList = new ArrayList<String[]>();
		
		private CsvWriter wr;
		
		private String charsetName;

		private CsvExport() {

		}

		/**
		 * 开始导出方法
		 * 
		 * @param filePath
		 *            导出文件存放物理路径
		 * @param fileWebPath
		 *            导出文件web下载路径
		 * @param filePrefix
		 *            导出文件名的前缀          
		 * @param flushRows
		 *            存放在内存的数据量
		 * @param fieldNames
		 *            导出文件列标题
		 * @param fieldCodes
		 * 			  导出数据对象的字段名称     
		 * @param flushRows
		 * 			写磁盘控制参数
		 * @return
		 */
		public static CsvExport start(String filePath, String fileWebPath,String filePrefix,
				List<String> fieldNames,List<String> fieldCodes,String charsetName) throws Exception {
			CsvExport csvExport = new CsvExport();
			csvExport.setFilePath(filePath);
			csvExport.setFileWebPath(fileWebPath);
			csvExport.setFilePrefix(filePrefix);
			csvExport.setFieldNames(fieldNames);
			csvExport.setColnum(fieldNames.size());
			csvExport.setFieldCodes(fieldCodes);
			csvExport.setCharsetName(charsetName);
			csvExport.writeTitles();
			//csvExport.wr = new CsvWriter(filePath,',',Charset.forName(charsetName));
			return csvExport;
		}
		
		/**
		 * 写入表头
		 * @throws Exception
		 */
		private void writeTitles() throws Exception {
			titleRow = new String[fieldNames.size()];
			fieldNames.toArray(titleRow);
		}

		/**
		 * 向导出文件写数据
		 * 
		 * @param datalist
		 *            存放Object对象，仅支持单个自定义对象，不支持对象中嵌套自定义对象
		 * @return
		 */
		public void writeDatasByObject(List datalist) throws Exception {
			for (int j = 0; j < datalist.size(); j++) {
				rownum = rownum + 1;
				//Row row = sh.createRow(rownum);
				List<String> row = new ArrayList<String>();
				for (int cellnum = 0; cellnum < fieldCodes.size(); cellnum++) {
					Object owner = datalist.get(j);
					Object value = invokeMethod(owner, fieldCodes.get(cellnum),
							new Object[] {});
					row.add(cellnum, value!=null?value.toString():"");
				}
				String[] lines = new String[fieldCodes.size()];
				row.toArray(lines);
				this.dataList.add(j,lines);
			}

		}
		
		public void writeDatasByList(List<List<String>> datalist) throws Exception {

			for (int j = 0; j < datalist.size(); j++) {
				rownum = rownum + 1;
				List<String> row = datalist.get(j);
				String[] lines = new String[fieldNames.size()];
				row.toArray(lines);
				this.dataList.add(lines);
			}
		}
		
		/**
		 * 向导出文件写数据
		 * 
		 * @param datalist
		 *            存放字符串数组
		 * @return
		 */
		public void writeDatasByString(List<String> datalist) throws Exception {
				rownum = rownum + 1;
				String[] lines = new String[datalist.size()];
				datalist.toArray(lines);
				this.dataList.add(rownum,lines);
		}

		/**
		 * 导出文件
		 * 
		 * @throws Exception
		 */
		public String exportFile() throws Exception {
			String filename = filePrefix+"_"+MyUtil.getCurrentTimeStr() + ".csv";
			wr = new CsvWriter(filePath+"/"+filename,',',Charset.forName(charsetName));
			wr.writeRecord(titleRow);
			for (String[] row : dataList) {
				wr.writeRecord(row);
			}
			wr.close();
			setFileAllPath(fileWebPath + filename);
			return fileWebPath + filename;
		}

		/**
		 * 反射方法，通过get方法获取对象属性
		 * 
		 * @param owner
		 * @param fieldname
		 * @param args
		 * @return
		 * @throws Exception
		 */
		private Object invokeMethod(Object owner, String fieldname, Object[] args)
				throws Exception {

			String methodName = "get" + fieldname.substring(0, 1).toUpperCase()
					+ fieldname.substring(1);
			Class ownerClass = owner.getClass();

			Class[] argsClass = new Class[args.length];

			for (int i = 0, j = args.length; i < j; i++) {
				argsClass[i] = args[i].getClass();
			}

			Method method = ownerClass.getMethod(methodName, argsClass);
			return method.invoke(owner, args);
		}

		
		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFileWebPath() {
			return fileWebPath;
		}

		public void setFileWebPath(String fileWebPath) {
			this.fileWebPath = fileWebPath;
		}

		public List<String> getFieldNames() {
			return fieldNames;
		}

		public void setFieldNames(List<String> fieldNames) {
			this.fieldNames = fieldNames;
		}

		public List<String> getFieldCodes() {
			return fieldCodes;
		}

		public void setFieldCodes(List<String> fieldCodes) {
			this.fieldCodes = fieldCodes;
		}

		public int getRownum() {
			return rownum;
		}

		public String getFilePrefix() {
			return filePrefix;
		}

		public void setFilePrefix(String filePrefix) {
			this.filePrefix = filePrefix;
		}

		public int getColnum() {
			return colnum;
		}

		public String getFileAllPath() {
			return fileAllPath;
		}

		public void setFileAllPath(String fileAllPath) {
			this.fileAllPath = fileAllPath;
		}

		private void setColnum(int colnum) {
			this.colnum = colnum;
		}

		public String getCharsetName() {
			return charsetName;
		}

		public void setCharsetName(String charsetName) {
			this.charsetName = charsetName;
		}
		
}
