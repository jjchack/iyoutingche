package com.iyoutingche.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IPTimeStamp {
	
	private String ip;
	
	public IPTimeStamp()
	{
		
	}
	public IPTimeStamp(String ip)
	{
		this.ip = ip;
	}
	
	public String getIPTimestamp()
	{
		StringBuffer buffer = new StringBuffer();
		
		if(ip != null)
		{
			String [] digits = ip.split("\\.");
			for(String s : digits)
			{
				buffer.append(s);
			}
		}
		
		//ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String time = sdf.format(new Date());
		buffer.append(time);
		
		Random random = new Random();
		for(int i=0; i<4; i++)
		{
			buffer.append(random.nextInt(10));
		}
		
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		IPTimeStamp ipts = new IPTimeStamp("192.168.19.121");
		System.out.println(ipts.getIPTimestamp());
	}

}
