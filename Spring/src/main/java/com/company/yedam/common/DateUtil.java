package com.company.yedam.common;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	/**
	 * String -> Date
	 * SimpleDateFormat.parse
	 */
	
	public static Date toDate(String date) {
	      Date result = null;
	      // to do
	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      try {
	         result = dateFormat.parse(date);
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
	      return new java.sql.Date(result.getTime());
	   }
}
