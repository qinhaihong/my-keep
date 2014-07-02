package cn.home.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesUtil.class);
	
	/**
	 * 读入properties文件
	 * 
	 * @param fileName
	 * @return
	 */
	public static Properties loadProperties(String fileName) {
		Properties pro = null;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("loading properties file, fileName=" + fileName);
		}
		
		InputStream in = null;
		in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
		pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			LOG.error("error when loading properties file, fileName=" + fileName);
		} finally {
			try {in.close();} catch (Exception e) {}
		}
		
		return pro;
	}
	
}
