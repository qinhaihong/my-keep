package cn.home.hq.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class FastjsonUtil {
	
	public static Map<String, String> jsonToMap(String jsonSr) {
		Map<String, String> map = (Map<String, String>) JSON.parse(jsonSr) ;
		return map;
	}

	public static String mapTojson(Map<String, String> map) {
		String jsonSr = JSON.toJSONString(map);
		return jsonSr;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		JSONObject json = new JSONObject();
		String depCityName = "beijing";
		String arrCityName = "xianggang";
		json.put("airlineCode", "ca");
		json.put("airLineName", "guohang");
		json.put("airlinePhone", "13001230123");

		Map<String,String> mapDep = new HashMap<>();
		mapDep.put("city_code", "bjs");
		mapDep.put("city_Name", depCityName);

		Map<String,String> mapArr = new HashMap<>();
		mapArr.put("city_code", "hkg");
		mapArr.put("city_Name", arrCityName);

		json.put("depCity", mapDep);
		json.put("arrCity", mapArr);

		json.put("orderId", "28900877");
		json.put("canCancelCheckIn", true);
		json.put("originDate", "2016-07-07");
		json.put("isLeave", true);

		System.out.println("page://flight_modify_calendar?params=" + URLEncoder.encode(json.toJSONString(), "utf-8"));
	}

}
