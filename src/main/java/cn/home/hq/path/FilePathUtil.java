package cn.home.hq.path;

import java.io.File;
import java.net.URL;

/**
 * Created by yanou on 16/8/1.
 */
public class FilePathUtil {

    public static void main(String[] args) {
        URL url = FilePathUtil.class.getResource("/");
        String rootPath1 = url.toString();
        System.out.println(rootPath1);
        String rootPath2 = url.getPath();
        System.out.println(rootPath2);
        String rootPath3 = url.getFile().toString();
        System.out.println(rootPath3);

        String relativelyPath = System.getProperty("user.dir");
        System.out.println(relativelyPath);

        File file = new File(relativelyPath + "/README.md");
        if (file.exists()) {
            System.out.println("README.md 存在.");
        } else {
            System.out.println("README.md 不存在！");
        }
    }

}
