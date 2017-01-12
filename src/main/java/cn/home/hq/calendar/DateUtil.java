package cn.home.hq.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateUtil {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		/**
		 * format
		 */
		String writeDateS = "2015-08-18 13:58:04";
		Date writeDate = null;
		if (writeDateS.length()>=18) {
			SimpleDateFormat abc =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss".replace(" ",""));
			writeDate = abc.parse(writeDateS);
		} else if (writeDateS.length()>=10) {
			SimpleDateFormat abc =new SimpleDateFormat("yyyy-MM-dd");
			writeDate = abc.parse(writeDateS);
		}
		if (writeDate != null) {
			System.out.println(writeDate + "www" + writeDateS);
		}

		/**
		 * between
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf.parse("2012-09-08 10:10:10");
		Date d2=sdf.parse("2012-09-09 00:00:00");
		System.out.println(daysBetween(d1,d2));
		System.out.println(daysBetween("2012-09-08 10:10:10","2012-09-15 00:00:00"));
		System.out.println(5/4);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate,Date bdate) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		smdate=sdf.parse(sdf.format(smdate));
		bdate=sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 *字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days=(time2-time1)/(1000*3600*24);
		return Integer.parseInt(String.valueOf(between_days));
	}

}
