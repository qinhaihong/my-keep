package cn.home.hq.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <br/>Title: JdkThreadBlockPool
 * <br/>Description:基础构建类
 * <br/>Company: ChinaBank
 * <br/>ClassName: JdkThreadBlockPool
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月28日 下午2:04:27
 * <br/>version 1.0.0
 */
public abstract class JdkThreadBlockPool {
	
	/**
	 * @Fields temp : 记录用户数（执行次数排序） 
	 */
	protected static AtomicInteger temp = new AtomicInteger(0);
	
	/**
	 * <p>Description: 提供RunnableFuture</p>
	 */
	protected FutureTask<String> getRunnableFuture() {
		FutureTask<String> futureTask = new FutureTask<String>(
					getCallable()
				);
		return futureTask;
	}
	
	/**
	 * <p>Description: 提供Callable</p>
	 */
	protected Callable<String> getCallable() {
		Callable<String> callable = 
				new Callable<String>() {
					public String call() throws Exception {
						return executeApplication();
					}
				};
		return callable;
	}
	
	/**
	 * <p>Description: 提供实际执行实现，子类必须实现</p>
	 */
	protected abstract String executeApplication() throws Exception;
		
	/**
	 * 	ThreadPoolExecutor
	 */
	protected static ExecutorService newFixedThreadBlockPool_TPE(int poolSize, int queueSize) {
        return new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS
        		, new LinkedBlockingQueue<Runnable>(queueSize)
        		, new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }
	
	/**
	 * 	Executors
	 */
	protected static ExecutorService newFixedThreadBlockPool_EXE(int poolSize) {
        return Executors.newFixedThreadPool(poolSize);
    }
	
	/**
	 * 	ThreadPoolExecutor
	 */
	protected static ExecutorService newCachedThreadBlockPool_TPE(int corePoolSize) {
        return new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS
        		, new SynchronousQueue<Runnable>()
        		, new ThreadPoolExecutor.CallerRunsPolicy()
        );
	}
	
	/**
	 * 	Executors
	 */
	protected static ExecutorService newCachedThreadBlockPool_EXE() {
        return Executors.newCachedThreadPool();
    }
	
	/**
	 * 	ThreadPoolExecutor
	 */
	protected static ExecutorService newScheduledThreadBlockPool_TPE(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
	}
	
	/**
	 * 	Executors
	 */
	protected static ExecutorService newScheduledThreadBlockPool_EXE(int corePoolSize) {
        return Executors.newScheduledThreadPool(corePoolSize);
    }
	
}
