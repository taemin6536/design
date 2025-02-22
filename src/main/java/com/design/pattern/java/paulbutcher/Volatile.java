package com.design.pattern.java.paulbutcher;

public class Volatile {
    private volatile boolean running = true; // volatile 사용

    public void stop() {
        running = false; // 즉시 모든 스레드에 반영됨
    }

    public void run() {
        while (running) { // 항상 최신 값을 확인
            // 작업 수행
        }
    }

}
