package com.fjsaas.web.utils.csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class CSVTest {

	/**
     * 读取CSV文件
	 * @throws Exception 
     */
	 @Test
     public void  readeCsv() throws Exception{
		 ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
         String csvFilePath = "d:/test.csv";
         CsvReader reader = new CsvReader(csvFilePath,',',Charset.forName("SJIS"));    //一般用这编码读就可以了    
          
	      reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。
	      
	      while(reader.readRecord()){ //逐行读入除表头的数据    
	          csvList.add(reader.getValues());
	      }            
	      reader.close();
	      
	      for(int row=0;row<csvList.size();row++){
	        System.out.println(row);
	    	for (String cell : csvList.get(row)) {
				System.out.println(cell);
			}	          
	      }
     }
     
     /**
      * 写入CSV文件
      */
     @Test
     public void writeCsv(){
         try {
             
             String csvFilePath = "d:/test2.csv";
              CsvWriter wr =new CsvWriter(csvFilePath,',',Charset.forName("SJIS"));
              String[] contents = {"aaaaa","bbbbb","cccccc","ddddddddd"}; 
              
              wr.writeRecord(contents);
              wr.close();
          } catch (IOException e) {
             e.printStackTrace();
          }
     }
     
    @org.junit.Test
 	public void exportTest() throws Exception{
 		/**            导出文件存放物理路径
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
 		 * @param flushRows*/
 		//导出文件存放的路径，并且是虚拟目录指向的路径
 		String filePath = "D:/";
 		//导出文件的前缀
 		String filePrefix="fjsaas";
 		//-1表示关闭自动刷新，手动控制写磁盘的时机，其它数据表示多少数据在内存保存，超过的则写入磁盘
 		int flushRows=100;
 		
 		//指导导出数据的title
 		List<String> fieldNames=new ArrayList<String>();
 		fieldNames.add("名字");
 		fieldNames.add("年龄");
 		fieldNames.add("出生日期");
 		
 		//告诉导出类数据list中对象的属性，让ExcelExportSXXSSF通过反射获取对象的值
 		List<String> fieldCodes=new ArrayList<String>();
 		fieldCodes.add("name");
 		fieldCodes.add("age");
 		fieldCodes.add("birthday");
 		
 		
 		
 		//注意：fieldCodes和fieldNames个数必须相同且属性和title顺序一一对应，这样title和内容才一一对应
 		
 		
 		//开始导出，执行一些workbook及sheet等对象的初始创建
 		CsvExport csvExport = CsvExport.start(filePath, "/upload/", filePrefix, fieldNames, fieldCodes,"GBK");
 		
 		//准备导出的数据，将数据存入list，且list中对象的字段名称必须是刚才传入ExcelExportSXXSSF的名称
 		List<Person> list = new ArrayList<Person>();
 	
 		Person p1 = new Person("tom", 22, new Date());
 		Person p2 = new Person("marry", 52, new Date());
 		Person p3 = new Person("jerry", 42, new Date());
 		Person p4 = new Person("kangkang", 32, new Date());
 		Person p5 = new Person("mike", 27, new Date());
 		list.add(p1);
 		list.add(p2);
 		list.add(p3);
 		list.add(p4);
 		list.add(p5);
 		
 		//执行导出
 		csvExport.writeDatasByObject(list);
 		//输出文件，返回下载文件的http地址
 		String webpath = csvExport.exportFile();
 		
 		System.out.println(webpath);
 		
 	}
 	
 	public class Person{
 		private String name;
 		private int age;
 		private Date birthday;
 		public String getName() {
 			return name;
 		}
 		public void setName(String name) {
 			this.name = name;
 		}
 		public int getAge() {
 			return age;
 		}
 		public void setAge(int age) {
 			this.age = age;
 		}
 		public Date getBirthday() {
 			return birthday;
 		}
 		public void setBirthday(Date birthday) {
 			this.birthday = birthday;
 		}
 		public Person(String name, int age, Date birthday) {
 			super();
 			this.name = name;
 			this.age = age;
 			this.birthday = birthday;
 		}
 		public Person() {
 			super();
 			// TODO Auto-generated constructor stub
 		}
 		@Override
 		public String toString() {
 			return "Person [name=" + name + ", age=" + age + ", birthday="
 					+ birthday + "]";
 		}
 		
 		
 	}
}
