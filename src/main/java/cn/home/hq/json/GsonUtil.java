package cn.home.hq.json;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by yanou on 16/6/17.
 */
public class GsonUtil {

    public static void main(String[] args) {
        int intervalDay = 1;
        Type mapType = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> contextArgumentMap = new Gson().fromJson("{\"intervalDay\":2}", mapType);
        if (contextArgumentMap != null) {
            String intervalDayArgument = contextArgumentMap.get("intervalDay");
            if (StringUtils.isNotBlank(intervalDayArgument)) {
                intervalDay = Integer.parseInt(intervalDayArgument);
            }
        }
        System.out.println(" * intervalDay: " + intervalDay);
    }

}
