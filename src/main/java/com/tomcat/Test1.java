package com.tomcat;

/**
 * @Description
 * @Date 2023/1/31
 *
 *
 * 测试创建线程，线程里的引用会不会导致外部线程oom
 *
 */
public class Test1 {


    public static void main(String[] args) {

        new Thread(()->{
            byte[] bytes = new byte[1];
        }).start();
    }
}
