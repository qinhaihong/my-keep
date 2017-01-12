package cn.home.hq.path;

import java.io.File;
import java.net.URL;

/**
 * Created by yanou on 16/8/1.
 */
public class FilePathUtil {

    public static void main(String[] args) throws Exception {
        URL url = FilePathUtil.class.getResource("/");

        String cPath1 = url.toString();
        System.out.println("url.tos" + cPath1);

        String cPath2 = url.getPath();
        System.out.println("url.path" + cPath2);

        String cPath3 = url.getFile();
        System.out.println("url.file" + cPath3);

        String relativelyPath = System.getProperty("user.dir");
        System.out.println("user.dir" + relativelyPath);

        File file = new File(relativelyPath + "/README.md");
        System.out.println("README.md path: " + file.getPath());
        System.out.println("README.md name: " + file.getName());
        System.out.println("README.md name2: " + file.getName().substring(file.getName().lastIndexOf(File.separator) + 1));

        if (file.exists()) {
            System.out.println("README.md exist.");
        } else {
            System.out.println("README.md no exist ！");
        }
    }

}
