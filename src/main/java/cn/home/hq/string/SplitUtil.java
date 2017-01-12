package cn.home.hq.string;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;

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
    public static void main(String[] args) throws UnsupportedEncodingException {
        splitF();
    }

    static public void replaceAll(){
        String mapKey = "订座成功，PNR号：operation-pnr";
        String replaced = mapKey.replaceAll("operation-pnr", "RTY501");
        System.out.println(replaced);
    }

    static public void splitF(){
        String path = "/wb/";
        String [] arrays = path.split(File.separator);
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void splitW() throws UnsupportedEncodingException {
        String path = "鼓浪屿｜厦门";
        path = new String(path.getBytes("GBK"), "UTF-8");
        String [] arrays = path.split("｜");
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void splitL() throws UnsupportedEncodingException {
        String path = "123d｜dfg";
        path = new String(path.getBytes("GBK"), "UTF-8");
        path = path.replaceAll("\\W", "|");
        String [] arrays = path.split("\\|");
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void getLineParts1(){
        String line = "2015-12-25 11:58:52,098| INFO| com.taobao.tracker.log.TrackerLogger.info(TrackerLogger.java:100)| appName==ie^RobjId==1134769361^RobjType==1^RindexColumn==ORDER1134769361^Rhost==ieorder010179031190.s.et2^RopDetail==null^Roperator==4445^RopType==order^RoperatorRole==2^RopTime==2015-12-2511:58:52,098^RoperationDescription==出票成功^RstatusDescription==已出票^RoperatorDescription==卖家:比邻旅游票务-啄木鸟^R| ^R";
        String[] arr = StringUtils.split(line, '|');
        for (String str : arr) {
            System.out.println(str);
        }
    }

    static public void getLineParts2(){
        String line = "2015-12-25 11:58:52,098| INFO| com.taobao.tracker.log.TrackerLogger.info(TrackerLogger.java:100)| appName==ie^RobjId==1134769361^RobjType==1^RindexColumn==ORDER1134769361^Rhost==ieorder010179031190.s.et2^RopDetail==null^Roperator==4445^RopType==order^RoperatorRole==2^RopTime==2015-12-2511:58:52,098^RoperationDescription==出票成功^RstatusDescription==已出票^RoperatorDescription==卖家:比邻旅游票务-啄木鸟^R| ^R";
        String[] arr = StringUtils.split(line, "\\|");
        for (String str : arr) {
            System.out.println(str);
        }
    }

    static public void getLineParts3(){
        String line = "http://tripdest.cn-hangzhou.oss-pub.aliyun-inc.com/baglist/v1/AngkorWat.zip";
        String[] arr = StringUtils.split(line, "/");
        for (String str : arr) {
            System.out.println(str);
        }
    }

}
