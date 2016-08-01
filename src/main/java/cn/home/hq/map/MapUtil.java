package cn.home.hq.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanou on 16/6/12.
 */
public class MapUtil {

    public static void main( String[] args ) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "10");
        map1.put(2, "20");
        System.out.println(map1.get(1));
    }

}
