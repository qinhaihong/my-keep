package cn.home.hq.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanou on 17/1/12.
 */
public class ListMemory {

    public static void main(String[] args) {
        long freeMemory=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(KB) : "+freeMemory);
        System.out.println("totalMemory(KB) : "+Runtime.getRuntime().totalMemory());

        for(int i=0;i<10000;i++){
            List list=new ArrayList();
        }
        long freeMemoryNew=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(KB) : "+freeMemoryNew+" freeMemory use(KB) : "+(freeMemory-freeMemoryNew));
        System.out.println("totalMemory(KB) : "+Runtime.getRuntime().totalMemory());

        for(int i=0;i<10000;i++){
            List list=null;
        }
        long freeMemoryNull=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(KB) : "+freeMemoryNull+" freeMemory use(KB) : "+(freeMemoryNew-freeMemoryNull));
        System.out.println("totalMemory(KB) : "+Runtime.getRuntime().totalMemory());
    }

}
