package myBank;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date today = new Date();
		long ldate = today.getTime();
		System.out.println(ldate);
		long cdate = System.currentTimeMillis();
		System.out.println(cdate); //1990년 부터 초단위 계산
		
		Calendar cal = Calendar.getInstance(); // 캘만치면 다나옴
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.MONTH + 1));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		LocalDate ld = LocalDate.now();
		System.out.println("100일 뒤 " + ld.plusDays(100));
		
		//date, calendar, localTime
		
		//시간계산 localTime으로 써서
		LocalTime lt = LocalTime.now();
		//100분뒤를 계산해보자
		System.out.println("100분 뒤" + lt.plusMinutes(100));
		
		// 두날짜간격 : Period
		Period pd = Period.ofYears(100);
		System.out.println(pd);
		
		
		long time = System.currentTimeMillis();
		System.out.println(time);
		
		String strTime = Long.toString(time);
		System.out.println(strTime);
		
		String subTime = strTime.substring(0,8);
		System.out.println(subTime);
		
		simpleDateFormat - new 
	}

}
