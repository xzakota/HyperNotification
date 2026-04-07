package com.xzakota;

import java.time.Duration;
import java.time.Instant;

public class Timer {
    public static void measure(Runnable runnable) {
        measure("Task", runnable);
    }

    public static void measure(String taskName, Runnable runnable) {
        Instant start = Instant.now();

        try {
            runnable.run();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long ms = Duration.between(start, Instant.now()).toMillis();
            System.out.printf("[Timing] %s took %dms%n", taskName, ms);
        }
    }
}
