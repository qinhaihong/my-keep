package cn.home.hq.threads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <br/>Title: ConcurrentTest
 * <br/>Description:javaģ�Ⲣ����������ѹ������
 * <br/>Company: ChinaBank
 * <br/>ClassName: ConcurrentTest
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013��10��11�� ����3:54:48
 * <br/>version 1.0.0
 */
public class ConcurrentTest {
    private static int thread_num = 200;
    private static int client_num = 460;
    private static Map<String,String> keywordMap = new HashMap<String,String>();

    private static final ExecutorService exec = Executors.newCachedThreadPool() ;

    public static void main(String[] args) {
        // 50���߳̿���ͬʱ����
        final Semaphore semp = new Semaphore(thread_num);

        // ģ��2000���ͻ��˷���
        for (int index=0; index<client_num; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        semp.acquire(); //��ȡ���

                        System.out.println("Thread:" + NO);
                        String host = "http://10.99.23.42:7001/KMQueryCenter/query.do?";
                        String para = "method=getQueryResult&pageNum=1&pageSize=5&"
                                + "queryKeyWord="
                                + getRandomSearchKey(NO)
                                + "&questionID=-1&questionIdPath=-1&searchType=1"
                                + "&proLine=&proSeries=&proType=" + NO;
                        System.out.println(host + para);

                        URL url = new URL(host);// �˴���д�����Ե�url
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//						connection.setRequestMethod("POST");
//						connection.setRequestProperty("Proxy-Connection", "Keep-Alive");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);

                        PrintWriter out = new PrintWriter(connection.getOutputStream());
                        out.print(para);
                        out.flush();
                        out.close();

                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line = "";
                        String result = "";
                        while ((line = in.readLine()) != null) {
                            result += line;
                        }
                        System.out.println(result);
                        System.out.println("�ڣ�" + NO + " ��");

                        Thread.sleep((long) (Math.random()) * 10);
                        semp.release(); //�ͷ�
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }

        // �˳��̳߳�
        exec.shutdown();
    }

    private static String getRandomSearchKey(final int no) {
        String ret = "";
        ret = (keywordMap.entrySet().toArray())[no].toString();
        ret = ret.substring(0, ret.lastIndexOf("="));
        System.out.println("\t" + ret);
        return ret;
    }

}
