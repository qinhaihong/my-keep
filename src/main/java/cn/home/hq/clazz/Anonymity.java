package cn.home.hq.clazz;

/**
 * <p>Title: Anonymity</p>
 * <p>Description: 内部类、静态内部类、匿名类</p>
 * <p>Company: ChinaBank</p>
 * @ClassName: Anonymity
 * @author qinhaihong
 * @date 2014年1月26日 下午2:10:08
 * @version 1.0.0
 */
public class Anonymity {
	int id=0;
	static int ids=1;
	
	public static void main(String[] args) {
		Anonymity test = new Anonymity();  
		test.invoke();
		test.invoke1();
		
		Anonymity.Inner inner = test.new Inner();
		inner.invoke();
		
		Anonymity.Inner1 inner1 = new Anonymity.Inner1();
		inner1.invoke();
	}
	
	private void invoke() {
		Inner inner = new Inner() {
			int id=3;
        	void invoke() {
        		System.out.println("This is inner class overwrite."+id);
        	}
        };
        inner.invoke();
	}
	
	private void invoke1() {
		Inner1 inner1 = new Inner1() {
			int id=4;
        	void invoke() {
        		System.out.println("This is inner1 class overwrite."+id);
        	}
        };
        inner1.invoke();
	}
	
	class Inner {		
		int id=2;
		void invoke() {
	        System.out.println("This is inner class."+id);
	    }
	}
	
	static class Inner1 {
		void invoke() {
	        System.out.println("This is inner1 class."+ids);
	    }
	}

}
