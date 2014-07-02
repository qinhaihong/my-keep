package cn.home.hq.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import cn.home.hq.calendar.DateTool;

/**
 * <br/>Title: JdkThreadBlockPoolTestBase
 * <br/>Description:基础测试类
 * <br/>Company: ChinaBank
 * <br/>ClassName: JdkThreadBlockPoolTestBase
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月29日 下午4:27:27
 * <br/>version 1.0.0
 */
public abstract class JdkThreadBlockPoolTestBase extends JdkThreadBlockPool {
	private static Logger lgr = Logger.getLogger("ThreaBlockPoolTest");
	
	protected void test1_callable(ExecutorService exec) {
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			Callable<String> c = getCallable();
			Future<String> f = exec.submit(c);
			String fr = null;
			try {
				fr = f.get(); //同步结果
			} catch (Exception e) {
				f.cancel(true);
				e.printStackTrace();
			}
			lgr.info("CLIENT - 返回值: " + fr) ;
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		try {
			while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void test2_runnable(ExecutorService exec) {
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			Future<String> f = (Future<String>) exec.submit(getRunnableFuture());
			String fr = null;
			try {
				fr = f.get(25, TimeUnit.SECONDS); //同步结果
			} catch (Exception e) {
				f.cancel(true);
				e.printStackTrace();
			}
			lgr.info("CLIENT - 返回值: " + fr) ;
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		try {
			while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void test3_runnable(ExecutorService exec) {
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			Future<String> f = exec.submit(getRunnableFuture(), " from test3 ");
			String fr = null;
			try {
				fr = f.get(5, TimeUnit.SECONDS); //同步结果
			} catch (Exception e) {
				f.cancel(true);
				e.printStackTrace();
			}
			lgr.info("CLIENT - 返回值: " + fr) ;
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		try {
			while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void test4_runnable(ExecutorService exec) {
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			FutureTask<String> f = getRunnableFuture();
			exec.execute(f);
			String fr = null;
			try {
				fr = f.get(5, TimeUnit.SECONDS); //同步结果
			} catch (Exception e) {
				f.cancel(true);
				e.printStackTrace();
			}
			lgr.info("CLIENT - 返回值: " + fr) ;
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		try {
			while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void test5_runnable(ExecutorService exec) {
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			FutureTask<String> f = getRunnableFuture();
			exec.submit(f);
			String fr = null;
			try {
				fr = f.get(); //同步结果
			} catch (Exception e) {
				f.cancel(true);
				e.printStackTrace();
			}
			lgr.info("CLIENT - 返回值: " + fr) ;
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		try {
			while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
				lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*@Override
	protected String executeApplication() throws Exception {
		return "* this is basic class.";
	}*/

}
