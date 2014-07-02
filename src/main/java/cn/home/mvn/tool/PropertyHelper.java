package cn.home.mvn.tool;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * <p>Title: PropertyHelper</p>
 * <p>Description: 配置文件类</p>
 * <p>Company: ChinaBank</p>
 * @ClassName: PropertyHelper
 * @author qinhaihong
 * @date 2013年9月3日 下午3:15:20
 * @version 1.0.0
 */
public class PropertyHelper {
	
	private ResourceBundle propBundle; 
	
	public PropertyHelper(String bundle){
		propBundle = PropertyResourceBundle.getBundle(bundle);
	}
	
	public String getValue(String key){
		return this.propBundle.getString(key);
	}

}
