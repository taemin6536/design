package com.design.pattern.sync;

import java.util.concurrent.Semaphore;

public class SemaphoreResource {
    private static final Semaphore semaphore = new Semaphore(3); // 최대 3개 스레드 접근 가능

    public void accessResource() {
        try {
            semaphore.acquire(); // 자원 사용 요청 (카운터 감소)
            System.out.println(Thread.currentThread().getName() + " 자원 사용 중...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // 자원 반환 (카운터 증가)
            System.out.println(Thread.currentThread().getName() + " 자원 반환");
        }
    }
}

class SemaphoreTest {
    public static void main(String[] args) {
        SemaphoreResource semaphore = new SemaphoreResource();

        for (int i = 1; i <= 5; i++) {
            new Thread(semaphore::accessResource, "Thread-" + i).start();
        }
    }
}
