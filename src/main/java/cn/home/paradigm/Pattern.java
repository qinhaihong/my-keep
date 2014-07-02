package cn.home.paradigm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <br/>Title: Pattern
 * <br/>Description:TODO
 * <br/>Company: ChinaBank
 * <br/>ClassName: Pattern
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月18日 上午10:56:43
 * <br/>version 1.0.0
 */
public class Pattern {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		submit1(
			new Callable<String>() {
				public String call() {
					return null;				
				}
			}
		);
		
		Future<String> r = submit2(
			new Callable<String>() {
				public String call() {
					return "* is submit2.";				
				}
			}
		);
		r.get();
	}
	
	protected static <T> void submit1(Callable<T> task) {
		
	}
	
	protected static <T> Future<T> submit2(Callable<T> task) {
		return null;		
	}

}
