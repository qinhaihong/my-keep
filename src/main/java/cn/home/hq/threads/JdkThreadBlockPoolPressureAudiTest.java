package cn.home.hq.threads;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*import com.jd.payment.risk.audi.client.AudiFacade;
import com.jd.payment.risk.audi.model.QuotaMonthFact;
import com.jd.payment.risk.audi.model.QuotaYearFact;
import com.jd.payment.risk.audi.model.RuleDataTransEntity;
import com.jd.payment.risk.common.util.FastjsonUtil;*/

/**
 * <br/>Title: JdkThreadBlockPoolPressureAudiTest
 * <br/>Description:提供给多线程压力测试使用
 * <br/>Company: ChinaBank
 * <br/>ClassName: JdkThreadBlockPoolPressureAudiTest
 * <br/>ProjectName: opencode-common
 * <br/>author qinhaihong
 * <br/>date 2013年10月29日 下午2:56:03
 * <br/>version 1.0.0
 */
public class JdkThreadBlockPoolPressureAudiTest extends JdkThreadBlockPoolTestBase {
	private static Logger lgr = Logger.getLogger("JdkThreadBlockPoolPressureAudiTest");
	
	/*private static AudiFacade audiFacade;
	static {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:/spring/spring-audi-client.xml");
		audiFacade = (AudiFacade) ac.getBean("audiFacade");
	}*/
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		final ExecutorService exec = newFixedThreadBlockPool_TPE(100, 150);
		final JdkThreadBlockPoolPressureAudiTest tbp = new JdkThreadBlockPoolPressureAudiTest();
		tbp.test1_callable(exec);
	}
	
	@Override
	protected String executeApplication() throws Exception {
		temp.incrementAndGet();
		String jsonsr = "{user:'express',pass:'express',bankCardNo:'d89de280f9c2013636a2fdc32f514f2c',tradeAmount:'400',businessType:'87',extRequestSN:'2013062700001',extTradeDN:'1234567890',cardType:'111',merchantNo:'22310462',cardExpireDate:'1306',currencyType:'CNY',tranStartTime:'1380515727283',tranEndTime:'0'}";
		/*Map<String,String> mapParams = FastjsonUtil.jsonToMap(jsonsr);
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
		}*/
		return "* pass no： " + temp;
	}

}
