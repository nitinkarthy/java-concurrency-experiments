package me.nitkart.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class BadImpl {
    StampedLock lock = new StampedLock();
    String previousValue = "";
    String currValue = "";

    public String methodOne() {
        long stamp = lock.writeLock();
        previousValue = currValue;
        currValue = "" + System.currentTimeMillis();
        lock.unlock(stamp);
        return currValue;
    }
}
