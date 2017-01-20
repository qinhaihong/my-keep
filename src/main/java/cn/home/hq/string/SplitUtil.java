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
     * @date 2015-12-25 ����19:02:39
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        splitM();
    }

    static public void replaceAll(){
        String mapKey = "�����ɹ���PNR�ţ�operation-pnr";
        String replaced = mapKey.replaceAll("operation-pnr", "RTY501");
        System.out.println(replaced);
    }

    static public void splitM(){
        String path = "���ڰ��ţ�������д Ӱ�����鼮";
        String [] arrays = path.split("��| ");;
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void splitF(){
        String path = "/wb/";
        String [] arrays = path.split(File.separator);
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void splitW() throws UnsupportedEncodingException {
        String text = "�����������";
        String [] arrays = text.split("��");
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void splitL() throws UnsupportedEncodingException {
        String text = "123d��dfg";
        text = text.replaceAll("\\W", "|");
        String [] arrays = text.split("\\|");
        String item = arrays[arrays.length-1];
        System.out.println(item);
    }

    static public void getLineParts1(){
        String line = "2015-12-25 11:58:52,098| INFO| com.taobao.tracker.log.TrackerLogger.info(TrackerLogger.java:100)| appName==ie^RobjId==1134769361^RobjType==1^RindexColumn==ORDER1134769361^Rhost==ieorder010179031190.s.et2^RopDetail==null^Roperator==4445^RopType==order^RoperatorRole==2^RopTime==2015-12-2511:58:52,098^RoperationDescription==��Ʊ�ɹ�^RstatusDescription==�ѳ�Ʊ^RoperatorDescription==����:��������Ʊ��-��ľ��^R| ^R";
        String[] arr = StringUtils.split(line, '|');
        for (String str : arr) {
            System.out.println(str);
        }
    }

    static public void getLineParts2(){
        String line = "2015-12-25 11:58:52,098| INFO| com.taobao.tracker.log.TrackerLogger.info(TrackerLogger.java:100)| appName==ie^RobjId==1134769361^RobjType==1^RindexColumn==ORDER1134769361^Rhost==ieorder010179031190.s.et2^RopDetail==null^Roperator==4445^RopType==order^RoperatorRole==2^RopTime==2015-12-2511:58:52,098^RoperationDescription==��Ʊ�ɹ�^RstatusDescription==�ѳ�Ʊ^RoperatorDescription==����:��������Ʊ��-��ľ��^R| ^R";
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
