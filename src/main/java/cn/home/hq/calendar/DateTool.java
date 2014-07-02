/**
 * @author QHH
 *
 * 2012-8-2上午11:32:19
 */
package cn.home.hq.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
	
	private static SimpleDateFormat reqDf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * <p>Description: Date to String</p>
	 * @param date
	 * @return
	 * @author qinhaihong
	 * @date 2013年10月18日 下午3:06:27
	 */
	public static String formatDate(Date date) {
		if (date==null)
			date = new Date();
		
        String dating = reqDf.format(date);
        return dating;
    }
	
	/**
	 * <p>Description: millisecond</p>
	 * @return
	 * @author qinhaihong
	 * @date 2013年10月18日 下午3:06:41
	 */
	public static long getCalendarMillisecond() {
		Calendar c = Calendar.getInstance();
        long sequence = c.getTimeInMillis();
        return sequence;
    }
	/**
	 * <p>Description: millisecond</p>
	 * @return
	 * @author qinhaihong
	 * @date 2013年10月18日 下午3:06:41
	 */
	public static long getSystemMillisecond() {
        long sequence = System.currentTimeMillis();
        return sequence;
    }
	
	/**
	 * <p>Description: 差值 </p>
	 * @param subtractor
	 * @param subtrahend
	 * @return subtractor - subtrahend
	 * @author qinhaihong
	 * @date 2013年10月21日 下午4:48:42
	 */
	public static long getDifferenceValue(long subtractor, long subtrahend) {
        long sequence = subtractor - subtrahend;
        return sequence;
    }
	

}
