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
        Matcher matcher = pattern.matcher("游玩TIPS：到了景点全程靠走，轻装上阵即可。");
        if (matcher.find()) {
            String result = "pickTips：" + matcher.group();
            log.info(result);
        } else {
            log.info("pickTips: no!");
        }
    }

    private static void findDay() {
        Pattern pattern = Pattern.compile("((^.{0,10}day)|(^.{0,10}第\\s*[1-10]\\s*[天|日]))(?!.*攻略|.*路线)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("s DAY1 &nbsp;宇治");
        if (matcher.find()) {
            String result = "findDay：" + matcher.group();
            log.info(result);
        } else {
            log.info("findDay: no!");
        }

        Matcher matcher2 = pattern.matcher("第  1 天 &nbsp;宇治 0攻略1");
        if (matcher2.find()) {
            String result = "findDay2：" + matcher2.group();
            log.info(result);
        } else {
            log.info("findDay2: no!");
        }
    }

    private static void findGuide() {
        Pattern pattern = Pattern.compile("^.{0,10}攻略", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("游玩攻略：");
        if (matcher.find()) {
            String result = "findGuide：" + matcher.group();
            log.info(result);
        } else {
            log.info("findGuide: no!");
        }
    }

    private static void findPoi() {
        Pattern pattern = Pattern.compile("第(.{1,10})站", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("第1站 &nbsp;平等院（1小时）");
        if (matcher.find()) {
            String result = "pickWords：" + matcher.group();
            log.info(result);
        } else {
            log.info("pickWords: no!");
        }
    }

    private static void pickWords() {
        Pattern p_html = Pattern.compile("\\s|\t|\n|&nbsp;", Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(" &nbsp;  &nbsp;  s t     平等院（1小时）");
        String value = m_html.replaceAll(""); //过滤特殊符号
        String result = "pickPoi：" + value;
        log.info(result);
        log.info(result.replaceAll(" ", ""));
        log.info(result.replaceAll("&nbsp;", ""));
    }

    private static void trimSpace() {
        String msg = " 上海 , s北京, 杭州&nbsp;  湾 ".replaceAll("(\\s|&nbsp;|)","");
        log.info(msg);
    }

    private static void trimOthers() {
        String msg = "有人说           ，　　背上行囊，就是过客。　　放下包袱，就回到了故乡。　　我们的人生似乎就是一场旅途，　　在这场旅途之中没有人能生活的绝对安稳，　　既然我们都是人生的过客，那么就让我们，　　带上一颗从容、淡泊的心，在一个陌生的城市感受一段慢时光吧。".replaceAll("[\\s|&nbsp;|　]","");
        log.info(msg);
    }

}
