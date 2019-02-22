package com.onlineanswer.hc.utils;

import java.util.ArrayList;
import java.util.Random;

/**
 * 产生ID唯一编码
 */
public class IDUtil {
    private static byte[] lock = new byte[0];

    private final static long w = 100000000;

    /**
     * 创建主键CODE
     * @param name
     * @return
     */
    public static String createID(String name) {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        return name+System.currentTimeMillis() + String.valueOf(r).substring(1);
    }

    /**
     * 创建电子票
     * @return
     */
    public static String createTicket() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }
        return String.valueOf(r).substring(1);
    }

    /**
     * 产生20个随机数且不重复
     * @return
     */
//    public static String getRandomNum() {
//        long r = 0;
//        Random random=new Random();
//        synchronized (lock) {
//            r = random.nextInt(20);
//        }
//        return String.valueOf(r);
//    }
    public static void main(String[] args){
        ArrayList<Integer> li=new ArrayList<>();
        int count=1;
        do {
            int result = getRandomNum();
            if (!li.contains(result)) {
                li.add(result);
            }
            count++;
        }while (li.size()<20);
        System.out.println(li.toString());
        System.out.println("循环次数："+count);
    }
    public static int getRandomNum(){
        Random random=new Random();
        return random.nextInt(30);
    }
}
