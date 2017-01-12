package cn.home.hq.path;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by yanou on 16/12/20.
 */
public class ZipUtil {

    public static void main(String[] args) throws Exception {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println("user.dir: " + relativelyPath);

        String sourcePath = relativelyPath + new String("/17_长滩岛_Boracay".getBytes("GBK"), "UTF-8") + File.separator;
        System.out.println("sourcePath: " + sourcePath);

        zip(sourcePath);
    }

    private static void zip(String zipSourcePath) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zos = null;
        try {
            File zipSource = new File(zipSourcePath);
            if (zipSource.exists()) {
                String zipName = zipSource.getName() + ".zip"; // 压缩文件名=源文件名.zip

                File zipTarget = new File(zipSource.getParent(), zipName);
                if (zipTarget.exists()) {
                    zipTarget.delete(); // 删除旧的zip文件
                }

                fos = new FileOutputStream(zipTarget);
                bos = new BufferedOutputStream(fos);
                zos = new ZipOutputStream(bos);
                addEntry(File.separator, zipSource, zos); // 添加对应的文件Entry
                zos.flush();

            } else {
                System.out.println("zip source no exists. zipSourcePath: {}" + zipSourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(zos, bos, fos);
        }
    }

    private static void addEntry(String base, File add, ZipOutputStream zos) throws IOException {
        String entry = base + add.getName(); // 按目录分级，形如：/52_洛杉矶_Los-Angeles/1.html
        System.out.println("zip addEntry base:" + base + "; entry:" + entry);

        if (add.isDirectory()) {
            for (File file : add.listFiles()) {
                addEntry(entry + File.separator, file, zos); // 递归列出目录下的所有文件，添加文件Entry
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(add);
                bis = new BufferedInputStream(fis, buffer.length);

                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
                closeQuietly(bis, fis);
            }
        }
    }

    /**
     * 关闭一个或多个流对象
     *
     * @param closeables
     *            可关闭的流对象列表
     */
    public static void closeQuietly(Closeable... closeables) {
        try {
            close(closeables);
        } catch (IOException e) {
            // do nothing
        }
    }

    /**
     * 关闭一个或多个流对象
     *
     * @param closeables
     *            可关闭的流对象列表
     *
     * @throws IOException
     */
    public static void close(Closeable... closeables) throws IOException {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }

}
