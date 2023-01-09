package com.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * @Description
 * @Date 2022/11/25
 */
public class TestStampedLock {


    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        stampedLock.readLock();
        stampedLock.writeLock();
        stampedLock.tryReadLock();
        stampedLock.tryWriteLock();

    }
}
