package com.design.pattern.sync;

import java.util.concurrent.locks.ReentrantLock;

public class Mutex {
    private final ReentrantLock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();  // 🔒 뮤텍스 잠금
        try {
            System.out.println(Thread.currentThread().getName() + " 자원 사용 중...");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  // 🔓 뮤텍스 해제
            System.out.println(Thread.currentThread().getName() + " 자원 반환");
        }
    }
}

class MutexTest {
    public static void main(String[] args) {
        Mutex mutex = new Mutex();

//        Runnable task = () -> {
//            mutex.accessResource();
//        };
//
//        Thread thread1 = new Thread(task, "Thread 1");
//        Thread thread2 = new Thread(task, "Thread 2");
//
//        thread1.start();
//        thread2.start();

        for (int i = 1; i <= 3; i++) {
            new Thread(mutex::accessResource, "Thread-" + i).start();
        }
    }
}
