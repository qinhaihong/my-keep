package cn.home.hq.stri;

/**
 * <p>Title: MatchUtil</p>
 * <p>Description: regex</p>
 * <p>Company: ChinaBank</p>
 * @ClassName: MatchUtil
 * @author haihong.qhh
 * @date 2014-4-21 ÏÂÎç05:05:52
 * @version 1.0.0
 */
public class MatchUtil {

	/**
	 * <p>Description: main</p>
	 * @param args
	 * @author haihong.qhh
	 * @date 2014-4-21 ÏÂÎç05:05:53
	 */
	public static void main(String[] args) {
		int daul = 5;
		String ru =  String.valueOf(daul);
		Object ro = ru;
		long buyLimit = Long.valueOf(ro.toString());
		System.out.println("buyLimit£º"+buyLimit);

		if (ru.matches("^[0-9]*$")) {
			System.out.println("Êý×Ö"+ru);
		} else {
			System.out.println("*!"+ru);
    	}
	}

}
