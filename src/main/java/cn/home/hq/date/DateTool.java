/**
 * @author QHH
 *
 * 2012-8-2上午11:32:19
 */
package cn.home.hq.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTool {
	
	private static SimpleDateFormat reqDf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static String formatReqDate(Date date) {
		if (date==null)
			date = new Date();
		
        String dating = reqDf.format(date);
        return dating;
    }
	
	public static String getReqSequence() {
		Calendar c = Calendar.getInstance();
        String sequence = c.getTimeInMillis()+"";
        return sequence;
    }

}
