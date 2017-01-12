package cn.home.hq.string;

/**
 * Created by yanou on 16/9/15.
 */
public class HashCode {

    public static void main(String args[]){
        String str1 = "aaa";
        String str2 = str1;
        String str3 = "bbb";
        System.out.println(str1.equals(str2));
        System.out.println("str1.hashCode():"+str1.hashCode());
        System.out.println("str2.hashCode():"+str2.hashCode());
        System.out.println("str3.hashCode():"+str3.hashCode());
    }

}
