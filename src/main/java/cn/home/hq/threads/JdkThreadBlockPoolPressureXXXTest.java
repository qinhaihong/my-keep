package cn.home.hq.threads;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.home.hq.calendar.DateTool;

/*
import com.jd.payment.risk.audi.client.AudiFacade;
import com.jd.payment.risk.audi.model.QuotaMonthFact;
import com.jd.payment.risk.audi.model.QuotaYearFact;
import com.jd.payment.risk.audi.model.RuleDataTransEntity;
import com.jd.payment.risk.common.util.FastjsonUtil;
*/

/**
 * <br/>Title: JdkThreadBlockPoolPressureXXXTest
 * <br/>Description:提供给多线程压力测试使用
 * <br/>Company: ChinaBank
 * <br/>ClassName: JdkThreadBlockPoolPressureXXXTest
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月18日 下午2:16:12
 * <br/>version 1.0.0
 */
public class JdkThreadBlockPoolPressureXXXTest extends JdkThreadBlockPoolTestBase {
	private static Logger lgr = Logger.getLogger("JdkThreadBlockPoolPressureXXXTest");
	
	/*private static AudiFacade audiFacade;
	static {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:/spring/spring-audi-client.xml");
		audiFacade = (AudiFacade) ac.getBean("audiFacade");
	}*/
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final ExecutorService exec = newFixedThreadBlockPool_TPE(100, 150);
		
		long l1 = DateTool.getSystemMillisecond();
		for(int i=1; i<1000; i++) {
			final int temp = i ;
			Future<String> f = exec.submit(new Callable<String>() {
				 public String call() throws Exception { 
					/*try {
						executeApp();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}*/
					return "* pass no： " + temp ;
				}
			});
			String r = f.get(); //同步结果
			lgr.info("CLIENT - 返回值: " + r) ;
//			f.cancel(true);
		}
		long l2 = DateTool.getSystemMillisecond();
		long l = DateTool.getDifferenceValue(l2, l1);
		lgr.info("CLIENT - 费毫秒数: " + l) ;
		
		exec.shutdown();
		while (! exec.awaitTermination(100, TimeUnit.MILLISECONDS)) {
			lgr.info("CLIENT - 线程池没有正常结束，被超时终止.");
		}
	}
	
	/*static void executeApp() throws Exception {
		String jsonsr = "{user:'express',pass:'express',bankCardNo:'d89de280f9c2013636a2fdc32f514f2c',tradeAmount:'400',businessType:'87',extRequestSN:'2013062700001',extTradeDN:'1234567890',cardType:'111',merchantNo:'22310462',cardExpireDate:'1306',currencyType:'CNY',tranStartTime:'1380515727283',tranEndTime:'0'}";
		Map<String,String> mapParams = FastjsonUtil.jsonToMap(jsonsr);
		RuleDataTransEntity rv = audiFacade.queryOfflineData(mapParams);
		List<Object> lst = rv.getFacts();
		if (lst!=null) {
			for(Object obj : lst) {
				if (obj instanceof QuotaMonthFact) {
					QuotaMonthFact fact = (QuotaMonthFact) obj;
					lgr.info("CLIENT - ".concat(rv.isSuccess()+"|"+rv.getErrorMsg()+"|"+fact.getQuotaMonth()));
				}
				if (obj instanceof QuotaYearFact){
					QuotaYearFact fact = (QuotaYearFact) obj;
					lgr.info("CLIENT - ".concat(rv.isSuccess()+"|"+rv.getErrorMsg()+"|"+fact.getQuotaYear()));
				}
			}
		}
	}*/

	@Override
	protected String executeApplication() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
