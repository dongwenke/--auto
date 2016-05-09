package com.dzf.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateCalculatorUtil {

    
    public static List<String> dateTostrList(String beginDate,String endDate) throws ParseException {
        List<String> strDateList = new ArrayList<String>();
    	
        Calendar begin = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        
        begin.setTime(new SimpleDateFormat("yyyy-MM").parse(beginDate));
        end.setTime(new SimpleDateFormat("yyyy-MM").parse(endDate));
        
        int sum = (end.get(Calendar.YEAR)-begin.get(Calendar.YEAR))*12 + 
        		(end.get(Calendar.MONTH)-begin.get(Calendar.MONTH));
        
        strDateList.add(beginDate);
        
        Calendar tmp = begin;
        for (int i =0;i<sum;i++){
        	tmp.add(Calendar.MONTH,1);
        	
        	String strDate = new SimpleDateFormat("yyyy-MM").format(tmp.getTime());
        	
        	strDateList.add(strDate);
        }
       
        System.out.println(strDateList);
        
		return strDateList;
    }
    
    public static void main(String[] args) throws ParseException {
    	dateTostrList("2015-06","2016-08");
	}

}