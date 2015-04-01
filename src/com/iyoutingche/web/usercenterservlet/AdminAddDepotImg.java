package com.iyoutingche.web.usercenterservlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.iyoutingche.web.depotservice.InPcar_Depot;
import com.iyoutingche.web.depotservice.Pcar_DepotImpl;
import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;
import com.iyoutingche.web.util.IPTimeStamp;
import com.jspsmart.upload.SmartUpload;

public class AdminAddDepotImg extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		String depot_code = (String)request.getSession().getAttribute("depot_code");
		System.out.println("depot_code="+depot_code);
		//设置上传文件保存路径
		String filePath = this.getServletContext().getRealPath("/img");
		System.out.println("路径："+filePath);
		/*System.out.println("a路径:"+this.getServletContext());
		System.out.println("b路径："+this.getServletContext().getRealPath("/"));
		System.out.println("路径："+filePath);*/
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		
		SmartUpload smart = new SmartUpload();
		//初始化对象
		smart.initialize(getServletConfig(), request, response);
		//设置上传文件的大小10M
		smart.setMaxFileSize(1024*1024*100);
		//设置上传所有文件的大小
		smart.setTotalMaxFileSize(1024*1024*100);
		//设置允许上传文件的类型
		smart.setAllowedFilesList("jpg,gif,png,jpeg,bmp");
		boolean result= true;  //判断是否符合上传类型
		String disFile="";
			try {
				smart.upload();
				IPTimeStamp ipts = new IPTimeStamp();
				String imgname = ipts.getIPTimestamp();  //为图片自定义姓名
				
				String ext = smart.getFiles().getFile(0).getFileExt();  //获得文件拓展名
				String filename = filePath+File.separator+imgname+"."+ext; //获得文件名的全称
				/*System.out.println("File name="+filename);*/
				
				smart.getFiles().getFile(0).saveAs(filename);
			    disFile = imgname+"."+ext;
				//System.out.println("disFile="+disFile);
			} catch (Exception e) {
				// TODO: handle exception
			}
				InPcar_Depot ipd = new Pcar_DepotImpl();
				boolean flag = ipd.ModifyDepotImg(depot_code, disFile);
				out.print(flag);
	}
}
