package cn.home.hq.stri;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by yanou on 15/12/25.
 */
public class SplitUtil {

    /**
     * <p>Description: main</p>
     * @param args
     * @author haihong.qhh
     * @date 2015-12-25 下午19:02:39
     */
    public static void main(String[] args) {
        String line = "2015-12-25 11:58:52,098| INFO| com.taobao.tracker.log.TrackerLogger.info(TrackerLogger.java:100)| appName==ie^RobjId==1134769361^RobjType==1^RindexColumn==ORDER1134769361^Rhost==ieorder010179031190.s.et2^RopDetail==null^Roperator==4445^RopType==order^RoperatorRole==2^RopTime==2015-12-2511:58:52,098^RoperationDescription==出票成功^RstatusDescription==已出票^RoperatorDescription==卖家:比邻旅游票务-啄木鸟^R| ^R";
        String[] arr = getLineParts2(line);
        for (String str : arr) {
            System.out.println(str);
        }
    }

    static public String[] getLineParts1(String line){
        String[] arr = StringUtils.split(line, '|');
        return arr;
    }

    static public String[] getLineParts2(String line){
        String[] arr = StringUtils.split(line, "\\|");
        return arr;
    }

}
