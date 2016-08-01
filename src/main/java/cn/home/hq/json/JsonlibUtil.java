package cn.home.hq.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

/**
 * Created by yanou on 16/3/7.
 */
public class JsonlibUtil {

    public static void main(String[] args) {
        jsonProperty();
        formatJson();
        jsonTry();
    }

    private static JSONObject fromObjectMap() {
        Map<String, Object> map = new HashMap();
        map.put( "name", "json" );
        map.put( "bool", Boolean.TRUE );
        map.put( "int", new Integer(1) );
        map.put( "array", new String[]{"a","b"} );
        map.put( "func", "function(i){ return this.arr[i]; }" );
        JSONObject jsonObject = JSONObject.fromObject( map );
        return jsonObject;
    }

    private static JSONObject createJSONObject() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","huangwuyi");
        jsonObject.put("sex", "男");
        jsonObject.put("QQ", "999999999");
        jsonObject.put("Min.score", new Integer(99));
        jsonObject.put("nickname", "梦中心境");
        return jsonObject;
    }

    private static void jsonProperty() {
        JSONObject jsonObject = createJSONObject();
        List<Object> arr = jsonObject.names();//获取名
        Collection<Object> arra = jsonObject.values();//获取值
        for(Object name:arr){
            System.out.println(name.toString());
        }
        for(Object value:arra){
            System.out.println(value.toString());
        }
    }

    private static void jsonTry() {
        JSONObject jsonObject = createJSONObject();

        //输出jsonObject对象
        System.out.println("jsonObject==>"+jsonObject);

        //判读输出对象的类型
        boolean isArray = jsonObject.isArray();
        boolean isEmpty = jsonObject.isEmpty();
        boolean isNullObject = jsonObject.isNullObject();
        System.out.println("isArray:"+isArray+" isEmpty:"+isEmpty+" isNullObject:"+isNullObject);

        //添加属性
        jsonObject.element("address", "福建省厦门市");
        System.out.println("添加属性后的对象==>"+jsonObject);

        //返回一个JSONArray对象
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1,"another jsonArray value");
        jsonObject.element("jsonArray", jsonArray);
        JSONArray array = jsonObject.getJSONArray("jsonArray");
        System.out.println("返回一个JSONArray对象："+array);

        //添加JSONArray后的值
        //{"username":"huangwuyi","sex":"男","QQ":"999999999","Min.score":99,"nickname":"梦中心境","address":"福建省厦门市","jsonArray":["this is a jsonArray value","another jsonArray value"]}
        System.out.println("结果="+jsonObject);

        //根据key返回一个字符串
        String username = jsonObject.getString("username");
        System.out.println("username==>"+username);

        //把字符转换为 JSONObject，转换后根据Key返回值
        String temp = jsonObject.toString();
        JSONObject object = JSONObject.fromObject(temp);
        System.out.println("qq="+object.get("QQ"));
    }

    /**
     * =================== 业务 BEGIN ===================
     */
    private static void formatJson() {
        System.out.println("=================== 业务 BEGIN ===================");
        String retStr = "";
        try {
            String msg = "{\"data\":[{\"content\":\"全部未使用的情况下,退票手续费CNY1;部分未使用的情况下,退票手续费CNY1;\",\"name\":\"退票规则\"},{\"content\":\"去程改期手续费CNY1;回程不允许改期;\",\"name\":\"更改规则\"},{\"content\":\"升舱请咨询航空公司;不得签转.\",\"name\":\"升舱和签转规则\"},{\"content\":\"起飞前10小时内提出改期/退票申请视为误机,需加收CNY1\",\"name\":\"误机规则\"}]}";
            //String msg = "{\"data\":[{\"content\":\"欣莹行李\",\"name\":\"行李规定\"}]}";
            retStr = msg;
            JSONObject data = JSONObject.fromObject(msg);
            if (data.containsKey("data")) {
                StringBuffer html = new StringBuffer("<table>");
                JSONArray contentAndNameArr = data.getJSONArray("data");
                ListIterator<JSONObject> listIterator = contentAndNameArr.listIterator();
                for (; listIterator.hasNext(); ) {
                    JSONObject contentAndNameJsn = listIterator.next();
                    html.append("<tr>");
                    html.append("<th style='width:100px;'>").append(contentAndNameJsn.get("name")).append("</th>");
                    html.append("<td>").append(contentAndNameJsn.get("content")).append("</td>");
                    html.append("</tr>");
                }
                html.append("</table>");
                retStr = html.toString();
            }
        } catch (Exception e) {
            System.out.println("formatJsonForMail 退改签|行李规定格式化异常." + e.getMessage());
        }
        System.out.println(retStr);
        System.out.println("=================== 业务 END ===================");
    }
    /**
     * =================== 业务 END ===================
     */

}
