package com.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description
 * @Date 2022/11/25
 */
public class TestReadWriteLock {

    static volatile Map<Integer,String> hashMap = new HashMap();

    public static String getMap(int key){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock readLock = lock.readLock();
        String s = null;
        readLock.lock();
        try {
            s = hashMap.get(key);
        }catch (Exception e){

        }finally{
            readLock.unlock();
        }
        return s;
    }

    public static String putMap(int key,String value){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Lock writeLock = lock.writeLock();
        String s = null;
        writeLock.lock();
        try {
            s = hashMap.put(key, value);
        }catch (Exception e){

        }finally{
            writeLock.unlock();
        }
        return s;
    }


    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    //Thread.sleep(1000);
                }catch (Exception e){

                }
                final int temp=i;
                new Thread(()->{
                    putMap(temp, temp+"");
                    System.out.println("put"+temp);
                }).start();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    //Thread.sleep(1000);
                }catch (Exception e){

                }
                final int temp=i;
                new Thread(()->{
                    String s = getMap(temp);
                    System.out.println("get"+temp+s);
                }).start();
            }
        }).start();
    }

}
