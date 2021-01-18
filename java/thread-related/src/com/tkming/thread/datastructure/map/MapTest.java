package com.tkming.thread.datastructure.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/13 14:22
 * @desc 暂无
 */
public class MapTest {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> unsafe = new HashMap<>();
        Map<String, String> safe = Collections.synchronizedMap(new HashMap<>());
        ConcurrentHashMap<String, String> safe2 = new ConcurrentHashMap<>();

        MapSub t1 = new MapSub(unsafe);
        MapSub t2 = new MapSub(safe);
        MapSub t3 = new MapSub(safe2);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t1);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t2);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(t3);
            t.start();
        }

        Thread.sleep(2000);
        System.out.println("unsafe size:" + t1.map.size());
        System.out.println("safe1 size:" + t2.map.size());
        System.out.println("safe2 size:" + t3.map.size());


        System.out.println("unsafe content:");
        t1.map.keySet().forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe content:");
        t2.map.keySet().forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
        System.out.println();
        System.out.println("safe2 content:");
        t3.map.keySet().forEach(s -> {
            if (null == s) {
                System.out.print("null ");
            } else {
                System.out.print(s + " ");
            }
        });
    }
}

class MapSub implements Runnable {
    public Map<String, String> map;

    public MapSub(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(Thread.currentThread().getName() + "-" + i, i + "");
            i++;
        }
    }
}
