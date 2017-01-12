package cn.home.hq.clazz;

/**
 * Created by yanou on 16/10/3.
 */
public class GetClass {

    class A {

    }

    class B extends A {

    }

    public static void main(String[] args) {
        System.out.println(A.class);
        System.out.println(B.class);

        GetClass g = new GetClass();
        A a = g.new B();
        System.out.println(a.getClass());
    }

}
