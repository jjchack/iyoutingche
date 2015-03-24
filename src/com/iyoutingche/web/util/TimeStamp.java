package com.iyoutingche.web.util;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.UUID;

// 取得时间戳的类
public class TimeStamp {
	public static String UUID(){     //用于生成绑定的randMd5
		UUID uuid  =  UUID.randomUUID(); 
		String s = UUID.randomUUID().toString();//用来生成数据库的主键id非常不错。。   
		return s;
	}
	public static String MD5(String s) {			//用于生成stu_nameMd5
        char hexDigits[] = { '0', '1', '2', '3', '4',
                             '5', '6', '7', '8', '9',
                             'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
     //获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
     //使用指定的字节更新摘要
            mdInst.update(btInput);
     //获得密文
            byte[] md = mdInst.digest();
     //把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return s;
        }
    }
	public static void main(String[]args){
		//System.out.println(new TimeStamp().MD5("iyou"));
	}
}
