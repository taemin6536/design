package com.design.pattern.java.paulbutcher;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 3개의 작업이 끝날 때까지 대기

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 작업 완료");
                latch.countDown(); // 카운트 감소
            }).start();
        }


        latch.await(); // 모든 작업이 끝날 때까지 대기
        System.out.println("모든 작업 완료! 메인 스레드 진행");
    }
}
