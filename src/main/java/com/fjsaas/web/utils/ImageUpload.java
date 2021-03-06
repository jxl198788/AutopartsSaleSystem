/*
 * 类作用 用于本地图片上传至服务器
 * author lyn
 * createTime 2016-04-25
 * version 0.1
 */
package com.fjsaas.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;

import com.fjsaas.web.constants.Constants;


public class ImageUpload {
	public static String filename;
	/*
	 * importImag jsp页面的file标签的name名
	 * request 请求
	 * filepath 选择图片的本地路径即file文本框中的图片路径
	 */
	public static String upload(HttpServletRequest request,String filepath){
		String msg = "";
		String oldFilename = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.length());
		filename = oldFilename;
//		System.out.println("oldFilename:"+oldFilename);
		String extension = FilenameUtils.getExtension(oldFilename);
//		System.out.println("extension:"+extension);

		if(!"png".equals(extension) && !"jpg".equals(extension)){
			msg = "上传的图片格式有问题，只支持png、jpg文件";
		}else{
			String realPath = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径
//			System.out.println("realPath:"+realPath);
			String fullDir = realPath + Constants.IMG_FILE_URL;
//			System.out.println("fullDir:"+fullDir);
			File file = new File(fullDir);
//			System.out.println("文件是否存在:"+file.exists());
			if(!file.exists()){
				file.mkdir();//文件不存在就创建
			}
			String newFilename = UUID.randomUUID().toString();
//			System.out.println("newFilename:"+newFilename);
			String fullPath = fullDir + newFilename + "." + extension;//"D:\\softAnZ\\Workspaces\\Eclipse\\AutopartsSaleSystem\\src\\main\\webapp\\static\\image\\"
//			System.out.println("fullPath:"+fullPath);
			try {
				FileInputStream fis = new FileInputStream(filepath);
				byte[] b = new byte[1024]; 
		        int len = 0; 
		        FileOutputStream fos = new FileOutputStream(fullPath); 
		        while((len=fis.read(b))!=-1){ 
		            fos.write(b,0,len); 
		        } 
		        fos.close(); 
		        fis.close();
			} catch (Exception e) {
				e.printStackTrace();
				msg = "图片上传，出现异常";
				System.out.println("图片上传，出现异常！");
			} 
			msg = "图片上传成功！";
		}
        return msg;
	}
}
