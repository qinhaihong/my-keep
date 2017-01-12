package cn.home.hq.string;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yanou on 16/11/15.
 */
@Slf4j
public class RegularUtil {

    public static void main(String args[]) throws UnsupportedEncodingException {
        findTips();
        findDay();
        findGuide();
        findPoi();
        pickWords();
        trimSpace();
        trimOthers();
    }

    private static void findTips() {
        Pattern pattern = Pattern.compile("^.{0,10}tips:*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("����TIPS�����˾���ȫ�̿��ߣ���װ���󼴿ɡ�");
        if (matcher.find()) {
            String result = "pickTips��" + matcher.group();
            log.info(result);
        } else {
            log.info("pickTips: no!");
        }
    }

    private static void findDay() {
        Pattern pattern = Pattern.compile("((^.{0,10}day)|(^.{0,10}��\\s*[1-10]\\s*[��|��]))(?!.*����|.*·��)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("s DAY1 &nbsp;����");
        if (matcher.find()) {
            String result = "findDay��" + matcher.group();
            log.info(result);
        } else {
            log.info("findDay: no!");
        }

        Matcher matcher2 = pattern.matcher("��  1 �� &nbsp;���� 0����1");
        if (matcher2.find()) {
            String result = "findDay2��" + matcher2.group();
            log.info(result);
        } else {
            log.info("findDay2: no!");
        }
    }

    private static void findGuide() {
        Pattern pattern = Pattern.compile("^.{0,10}����", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("���湥�ԣ�");
        if (matcher.find()) {
            String result = "findGuide��" + matcher.group();
            log.info(result);
        } else {
            log.info("findGuide: no!");
        }
    }

    private static void findPoi() {
        Pattern pattern = Pattern.compile("��(.{1,10})վ", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("��1վ &nbsp;ƽ��Ժ��1Сʱ��");
        if (matcher.find()) {
            String result = "pickWords��" + matcher.group();
            log.info(result);
        } else {
            log.info("pickWords: no!");
        }
    }

    private static void pickWords() {
        Pattern p_html = Pattern.compile("\\s|\t|\n|&nbsp;", Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(" &nbsp;  &nbsp;  s t     ƽ��Ժ��1Сʱ��");
        String value = m_html.replaceAll(""); //�����������
        String result = "pickPoi��" + value;
        log.info(result);
        log.info(result.replaceAll(" ", ""));
        log.info(result.replaceAll("&nbsp;", ""));
    }

    private static void trimSpace() {
        String msg = " �Ϻ� , s����, ����&nbsp;  �� ".replaceAll("(\\s|&nbsp;|)","");
        log.info(msg);
    }

    private static void trimOthers() {
        String msg = "����˵           �������������ң����ǹ��͡��������°������ͻص��˹��硣�������ǵ������ƺ�����һ����;���������ⳡ��;֮��û����������ľ��԰��ȣ�������Ȼ���Ƕ��������Ĺ��ͣ���ô�������ǣ���������һ�Ŵ��ݡ��������ģ���һ��İ���ĳ��и���һ����ʱ��ɡ�".replaceAll("[\\s|&nbsp;|��]","");
        log.info(msg);
    }

}
