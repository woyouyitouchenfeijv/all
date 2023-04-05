package com.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.StampedLock;

/**
 * @Description
 * @Date 2022/11/25
 */
public class TestStampedLock {
    private final static Logger logger = LoggerFactory.getLogger(TestStampedLock.class);

    final StampedLock stampedLock = new StampedLock();
    int param = 0;

    public int getParam() {
        long l = stampedLock.readLock();
        System.out.println(l);
        return param;
    }

    public void setParam(int param) {
        stampedLock.writeLock();
        this.param = param;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1<<6);
        TestStampedLock testStampedLock = new TestStampedLock();

        Thread writeThread1 = new Thread(() -> {
            testStampedLock.setParam(1);
            System.out.println("writeThread1 : " + testStampedLock.param);
        });
        Thread writeThread2 = new Thread(() -> {
            testStampedLock.setParam(2);
            System.out.println("writeThread2 : " + testStampedLock.param);
        });
        Thread readThread1 = new Thread(() -> {
            System.out.println("readThread1 : " + testStampedLock.getParam());
        });

        Thread readThread2 = new Thread(() -> {
            System.out.println("readThread2 : " + testStampedLock.getParam());
        });


        writeThread1.start();
        System.out.println("writeThread1 执行");
        writeThread2.start();
        System.out.println("writeThread2 执行");
        readThread1.start();
        System.out.println("readThread1 执行");
        readThread2.start();
        System.out.println("readThread2 执行");

    }
}
