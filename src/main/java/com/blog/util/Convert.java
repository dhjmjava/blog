package com.blog.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * * ClassName: Convert <br/>  
 * Function: 字符串与数字相互转换类. <br/>  
 * date: 2016-8-11 下午3:34:41 <br/>  
 * @author Administrator  
 * @version   
 * @since JDK 1.6
 */
public class Convert {

	public static int strToInt(String str, int defaultValue) {
		int Result = defaultValue;
		try {
			Result = Integer.parseInt(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static long strToLong(String str, long defaultValue) {
		long Result = defaultValue;
		try {
			Result = Long.parseLong(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static float strToFloat(String str, float defaultValue) {
		float Result = defaultValue;
		try {
			Result = Float.parseFloat(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static double strToDouble(String str, double defaultValue) {
		double Result = defaultValue;
		try {
			Result = Double.parseDouble(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static boolean strToBoolean(String str, boolean defaultValue) {
		boolean Result = defaultValue;
		try {
			Result = Boolean.parseBoolean(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static java.util.Date strToDate(String str, java.util.Date defaultValue) {
		return strToDate(str, "yyyy-MM-dd HH:mm:ss", defaultValue);
	}

	public static java.util.Date strToDate(String str, String format, java.util.Date defaultValue) {
		java.util.Date Result = defaultValue;
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
		try {
			Result = formatter.parse(str);
		} catch (Exception e) {
		}

		return Result;
	}

	public static String dateToStr(java.util.Date date, String defaultValue) {
		return dateToStr(date, "yyyy-MM-dd HH:mm:ss", defaultValue);
	}

	public static String dateToStr(java.util.Date date, String format, String defaultValue) {
		String Result = defaultValue;
		SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
		try {
			Result = formatter.format(date);
		} catch (Exception e) {
		}

		return Result;
	}

	public static String strToStr(String str, String defaultValue) {
		String Result = defaultValue;

		if ((str != null) && (!str.isEmpty())) {
			Result = str;
		}

		return Result;
	}

	public static java.sql.Date dateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.util.Date sqlDateToDate(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}

	public static Timestamp dateToSqlTimestamp(java.util.Date date) {
		return new Timestamp(date.getTime());
	}

	public static java.util.Date qlTimestampToDate(Timestamp date) {
		return new java.util.Date(date.getTime());
	}

	public static int strtoAsc(String st) {
		byte[] gc = st.getBytes();
		int asnum = gc[0];
		return asnum;
	}

	public static char intToChar(int backnum) {
		char stchar = (char) backnum;
		return stchar;
	}
}
