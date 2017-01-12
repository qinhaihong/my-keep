package cn.home.hq.collection;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by yanou on 16/10/10.
 */
public class ListUtil {

    public static void main(String[] args) {
        List<String> okList = Lists.newArrayList();
        okList.add("suzhou");
        okList.add("hangzhou");
        Iterator<String> iterator = okList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.startsWith("su")) {
                iterator.remove();
            }
        }
        out.println(okList);
    }

}
