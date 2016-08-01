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
        jsonObject.put("sex", "��");
        jsonObject.put("QQ", "999999999");
        jsonObject.put("Min.score", new Integer(99));
        jsonObject.put("nickname", "�����ľ�");
        return jsonObject;
    }

    private static void jsonProperty() {
        JSONObject jsonObject = createJSONObject();
        List<Object> arr = jsonObject.names();//��ȡ��
        Collection<Object> arra = jsonObject.values();//��ȡֵ
        for(Object name:arr){
            System.out.println(name.toString());
        }
        for(Object value:arra){
            System.out.println(value.toString());
        }
    }

    private static void jsonTry() {
        JSONObject jsonObject = createJSONObject();

        //���jsonObject����
        System.out.println("jsonObject==>"+jsonObject);

        //�ж�������������
        boolean isArray = jsonObject.isArray();
        boolean isEmpty = jsonObject.isEmpty();
        boolean isNullObject = jsonObject.isNullObject();
        System.out.println("isArray:"+isArray+" isEmpty:"+isEmpty+" isNullObject:"+isNullObject);

        //�������
        jsonObject.element("address", "����ʡ������");
        System.out.println("������Ժ�Ķ���==>"+jsonObject);

        //����һ��JSONArray����
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1,"another jsonArray value");
        jsonObject.element("jsonArray", jsonArray);
        JSONArray array = jsonObject.getJSONArray("jsonArray");
        System.out.println("����һ��JSONArray����"+array);

        //���JSONArray���ֵ
        //{"username":"huangwuyi","sex":"��","QQ":"999999999","Min.score":99,"nickname":"�����ľ�","address":"����ʡ������","jsonArray":["this is a jsonArray value","another jsonArray value"]}
        System.out.println("���="+jsonObject);

        //����key����һ���ַ���
        String username = jsonObject.getString("username");
        System.out.println("username==>"+username);

        //���ַ�ת��Ϊ JSONObject��ת�������Key����ֵ
        String temp = jsonObject.toString();
        JSONObject object = JSONObject.fromObject(temp);
        System.out.println("qq="+object.get("QQ"));
    }

    /**
     * =================== ҵ�� BEGIN ===================
     */
    private static void formatJson() {
        System.out.println("=================== ҵ�� BEGIN ===================");
        String retStr = "";
        try {
            String msg = "{\"data\":[{\"content\":\"ȫ��δʹ�õ������,��Ʊ������CNY1;����δʹ�õ������,��Ʊ������CNY1;\",\"name\":\"��Ʊ����\"},{\"content\":\"ȥ�̸���������CNY1;�س̲��������;\",\"name\":\"���Ĺ���\"},{\"content\":\"��������ѯ���չ�˾;����ǩת.\",\"name\":\"���պ�ǩת����\"},{\"content\":\"���ǰ10Сʱ���������/��Ʊ������Ϊ���,�����CNY1\",\"name\":\"�������\"}]}";
            //String msg = "{\"data\":[{\"content\":\"��Ө����\",\"name\":\"����涨\"}]}";
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
            System.out.println("formatJsonForMail �˸�ǩ|����涨��ʽ���쳣." + e.getMessage());
        }
        System.out.println(retStr);
        System.out.println("=================== ҵ�� END ===================");
    }
    /**
     * =================== ҵ�� END ===================
     */

}
