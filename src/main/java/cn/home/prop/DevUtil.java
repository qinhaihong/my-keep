package cn.home.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.*;
/**
 * 
 * @author liandahu@360buy.com
 * @date 2012-11-1
 * @time 下午04:35:37
 *
 */
public class DevUtil {

	private static final Logger LOG = LoggerFactory.getLogger(DevUtil.class);
	
	private static final String FILE = "dev.properties";
	private static final String KEY = "Dev.Pin";
	
	private static String[] devs = null;
	
	static{
		Properties prop = initProperties();
	}
	
	private static Properties initProperties(){
		Properties prop = null;
		InputStream is = null;
		try {
			is = DevUtil.class.getClassLoader().getResourceAsStream(FILE);
			if(is != null){
				prop = new Properties();
				prop.load(is);
				is.close();
			}
		} catch (Exception e) {
			LOG.error("加载研发配置文件错误，错误原因：" + e.getMessage(), e);
		}finally{
			if(is != null){
				try {is.close();} catch (IOException e) {}
			}
		}
		return prop;
	}
	
}
