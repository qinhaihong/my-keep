package cn.home.prop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import sun.rmi.runtime.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanou on 15/12/25.
 */
@Slf4j
public class TokenGenerator {

    public static void main(String[] args) {
        String token = new TokenGenerator().getToken();
        log.info("Token£º" + token);
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
                log.error(e.getMessage(), e);
            }
        }
        return result;
    }

}
