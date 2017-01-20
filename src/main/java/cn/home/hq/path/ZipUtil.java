package cn.home.hq.path;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by yanou on 16/12/20.
 */
public class ZipUtil {

    public static void main(String[] args) throws Exception {
        String relativelyPath = System.getProperty("user.dir");
        System.out.println("user.dir: " + relativelyPath);

        String pocketName = "/82_圣托里尼岛_Santorini";

        /**
         * 压缩
         */
        String sourcePath = relativelyPath + "/pocket/zip" + pocketName;
        String targetPath = sourcePath + ".zip";
        System.out.println("sourcePath: " + sourcePath);
        addZip(new File(sourcePath), new File(targetPath));

        /**
         * 解压
         */
        String outPath = relativelyPath + "/pocket/unzip";
        String zipFilePath = outPath + pocketName + ".zip";
        System.out.println("zipFilePath: " + zipFilePath + "; outPath: " + outPath);
//        upZipFile(zipFilePath, outPath);
    }

    private static void addZip(File zipSource, File zipTarget) {
        System.out.println("addZip source zipSource: " + zipSource);
        System.out.println("addZip source zipTarget: " + zipTarget);

        ZipOutputStream zos = null;
        try {
            zos = new ZipOutputStream(new FileOutputStream(zipTarget));
            addEntry("/", zipSource, zos); // 添加对应的文件Entry
            zos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeQuietly(zos);
        }
    }

    /**
     * 扫描添加文件Entry
     *
     * @param base
     *            基路径
     * @param add
     *            待压文件
     * @param zos
     *            Zip文件输出流
     *
     * @throws IOException
     */
    private static void addEntry(String base, File add, ZipOutputStream zos) throws IOException {
        String entry = base + add.getName(); // 按目录分级，形如：/1.html 或 /img
        System.out.println("zip addEntry entry: " + entry);

        putEntry(entry, add, zos);
        if (add.isDirectory()) {
            for (File file : add.listFiles()) {
                addEntry(entry + "/", file, zos); // 递归列出目录下的所有文件，添加文件Entry
            }
        }
    }

    private static void putEntry(String entry, File add, ZipOutputStream zos) throws IOException {
        int indexSeparator = entry.indexOf("/", 1);
        if (indexSeparator < 0) {
            return;
        } else {
            entry = entry.substring(indexSeparator+1);
        }
        entry = directoryEntry(add, entry);
        System.out.println("zip addEntry putEntry entry: " + entry);
        writeEntry(entry, add, zos);
    }

    private static String directoryEntry(File entryFile, String entry){
        if (entryFile.isDirectory()) {
            if (!entry.endsWith("/")) {
                entry += "/";
            }
        }
        return entry;
    }

    private static void writeEntry(String entry, File add, ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(entry);
        if (add.isDirectory()) {
            zipEntry.setTime(add.lastModified());
            zipEntry.setComment(null);
            zipEntry.setMethod(ZipEntry.STORED);
            zipEntry.setSize(0);
            zipEntry.setCrc(0);
        }
        zos.putNextEntry(zipEntry);
        if (add.isFile()) {
            writeZos(add, zos);
        }
        zos.closeEntry();
    }

    private static void writeZos(File add, ZipOutputStream zos) throws IOException {
        System.out.println("zip addEntry putEntry writeZos add: " + add);
        BufferedInputStream bis = null;
        try {
            int read;
            byte[] buffer = new byte[1024 * 10];
            bis = new BufferedInputStream(new FileInputStream(add), buffer.length);
            while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                zos.write(buffer, 0, read);
            }
        } finally {
            closeQuietly(bis);
        }
    }

    private static boolean upZipFile(String zipFilePath, String outPath) throws Exception {
        File file = new File(zipFilePath);
        if (!file.exists() || !file.isFile()) {
            return false;
        }

        if (!outPath.endsWith(File.separator)) {
            outPath = outPath + File.separator;
        }

        File outDir = new File(outPath);
        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        ZipFile zFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> zList = zFile.entries();
        byte[] buf = new byte[1024];

        ZipEntry ze;
        while (zList.hasMoreElements()) {
            ze = zList.nextElement();
            if (ze.isDirectory()) {
                String zeDirectory = outPath + ze.getName();
                File fileDirectory = new File(zeDirectory);
                fileDirectory.mkdir();
                continue;
            }

            OutputStream os = null;
            InputStream is = null;

            try {
                String fileName = outPath + ze.getName();
                File fileTarget = new File(fileName);

                /*String filePath = fileTarget.getParent();
                File filePathDir = new File(filePath);
                if (!filePathDir.exists()) {
                    filePathDir.mkdirs();
                }*/

                os = new BufferedOutputStream(new FileOutputStream(fileTarget));
                is = new BufferedInputStream(zFile.getInputStream(ze));
                int readLen;
                while ((readLen = is.read(buf, 0, 1024)) != -1) {
                    os.write(buf, 0, readLen);
                }
                os.flush();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                    if (is != null) {
                        is.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        if (zFile != null) {
            zFile.close();
        }
        return true;
    }


    /**
     * 关闭一个或多个流对象
     *
     * @param closeables
     *            可关闭的流对象列表
     */
    private static void closeQuietly(Closeable... closeables) {
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
    private static void close(Closeable... closeables) throws IOException {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        }
    }

}
