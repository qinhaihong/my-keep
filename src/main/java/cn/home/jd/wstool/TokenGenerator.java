package cn.home.jd.wstool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import cn.home.prop.PropertiesUtil;

/**
 * <p>Title: TokenGenerator</p>
 * <p>Description: token生成器</p>
 * <p>Company: ChinaBank</p>
 * @ClassName: TokenGenerator
 * @author qinhaihong
 * @date 2014年1月16日 下午2:15:25
 * @version 1.0.0
 */
public class TokenGenerator {
	
	public static void main(String[] args) {
		String token = new TokenGenerator().getToken();
		logger.info("Token：" + token);
	}
	
	private String getToken() {
		String seed = PropertiesUtil.loadProperties("props/wstool.properties").getProperty("auth.ws.seed");
		String content = PropertiesUtil.loadProperties("props/wstool.properties").getProperty("auth.ws.content");
		String result = "";
		if (!"".equals(seed) && !"".equals(content)) {
			MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				md.update((content + "-" + seed).getBytes());
				byte b[] = md.digest();
				result = new String(Base64.encodeBase64(b));
			} catch (NoSuchAlgorithmException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return result;
	}
	
	private static final Logger logger = Logger.getLogger(TokenGenerator.class);

}
