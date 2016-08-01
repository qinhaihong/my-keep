package cn.home.hq.integer;

import java.util.Date;

/**
 * Created by yanou on 16/4/1.
 */
public class IntegerUtil {

    public static void main( String[] args ) {

        System.out.println(new Long(2006379032).intValue());

        System.out.println(7/3);

        long intervalMilli = new Date().getTime() - 8 * 60 * 60 * 1000 - new Date().getTime();
        int intervalHours = (int) (intervalMilli / (60 * 60 * 1000));
        System.out.println(intervalHours);

    }

}
