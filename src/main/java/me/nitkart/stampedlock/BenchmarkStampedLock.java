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
    public String benchmarkBadImpl() {
        return badImpl.methodOne(); //returning to avoid dead code elimination by compiler
    }
}
