package me.nitkart.stampedlock;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class BenchmarkStampedLock {

    BadImpl badImpl;


    @Setup
    public void setup() {
        badImpl = new BadImpl();
    }


    @Benchmark
    public void benchmarkBadImpl() {
        badImpl.methodOne();
    }
}
