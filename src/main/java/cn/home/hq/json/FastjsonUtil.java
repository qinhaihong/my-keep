package cn.home.hq.json;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * <br/>Title: FastjsonUtil
 * <br/>Description:JSON格式转换
 * <br/>Company: ChinaBank
 * <br/>ClassName: FastjsonUtil
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年9月29日 下午4:52:58
 * <br/>version 1.0.0
 */
public class FastjsonUtil {
	
	protected Logger logger = LoggerFactory.getLogger(FastjsonUtil.class);
	
	public static String objectToJson(Object result) {
		return JSON.toJSONString(result);
	}
	
	public static Object jsonToObject(String jsonsr, Class<Object> clazz) {
		return JSON.parseObject(jsonsr, clazz);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, String> jsonToMap(String jsonsr) {
		Map<String, String> map = null;
		map = (Map<String, String>) JSON.parse(jsonsr) ;
		return map;
	}

}
