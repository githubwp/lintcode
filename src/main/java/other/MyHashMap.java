package other;

import java.security.cert.CertPathBuilder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;

public class MyHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.put("a", "4"));
        ;
        System.out.println(map.put("b", "5"));
        ;
        System.out.println(map.put("c", "6"));
        ;
        System.out.println(map.put("d", "7"));
        ;
        LinkedHashMap<String, String> map1 = new LinkedHashMap<>();
        System.out.println(map1.put("a", "4"));
        ;
        System.out.println(map1.put("b", "5"));
        ;
        System.out.println(map1.put("c", "6"));
        ;
        System.out.println(map1.put("d", "7"));
        ;
        System.out.println("ok");


        System.out.println(5 & 3);
        System.out.println(Integer.MIN_VALUE);

        float f = 1999999991808f;
        System.out.printf("%f\n", f);
        System.out.printf("%f\n", f+ 1);
        System.out.printf("%f\n", f+ 2);
        System.out.printf("%f\n", f+ 3);
        System.out.printf("%f\n", f+ 4);

        System.out.println((byte)0xff>>33);
        System.out.println((byte)0xff>>>7);

//        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
//        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
//                0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
//
//        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
//        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
//        singleThreadPool.shutdown();


    }


}
