package com.iyoutingche.web.usercenterservlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.iyoutingche.web.usermodel.PcarUser;
import com.iyoutingche.web.userservice.InPcarUser;
import com.iyoutingche.web.userservice.PcarUserImpl;
import com.iyoutingche.web.util.IPTimeStamp;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class userJsonModifyImg extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String email = (String)request.getSession().getAttribute("email");
		System.out.println("email=="+email);
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
			InPcarUser ipu = new PcarUserImpl();
			boolean flag = ipu.ModifyEmail(email, disFile);
			if(flag){
				PcarUser user = ipu.FindUsersByEmail(email);
				JSONObject json = new JSONObject();
					try {
						json.put("userimg", user.getUser_img());
						//System.out.println("userimg"+json.toString());
						out.print(json.toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	}
}
