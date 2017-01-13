package cn.home.hq.collection;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.collections.ListUtils.EMPTY_LIST;

/**
 * Created by yanou on 17/1/12.
 */
public class ListMemory {

    public static void main(String[] args) {
        long freeMemory=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(B) : "+freeMemory);
        System.out.println("totalMemory(B) : "+Runtime.getRuntime().totalMemory());
        System.out.println("************************");

        for(int i=0;i<100000;i++){
            List list=null;
        }
        long freeMemoryNull=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(B) : "+freeMemoryNull+" freeMemoryNull use(B) : "+(freeMemory-freeMemoryNull));
        System.out.println("totalMemory(B) : "+Runtime.getRuntime().totalMemory());
        System.out.println("************************");

        for(int i=0;i<100000;i++){
            List list= EMPTY_LIST;
        }
        long freeMemoryEmpty=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(B) : "+freeMemoryEmpty+" freeMemoryEmpty use(B) : "+(freeMemory-freeMemoryEmpty));
        System.out.println("totalMemory(B) : "+Runtime.getRuntime().totalMemory());

        for(int i=0;i<100000;i++){
            List list=new ArrayList();
        }
        long freeMemoryNew=Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory(B) : "+freeMemoryNew+" freeMemoryNew use(B) : "+(freeMemory-freeMemoryNew));
        System.out.println("totalMemory(B) : "+Runtime.getRuntime().totalMemory());
        System.out.println("************************");
    }

}
