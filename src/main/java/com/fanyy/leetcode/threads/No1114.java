package com.fanyy.leetcode.threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fanyuanyuan
 * @data 12/9/21
 */

public class No1114 {
    static class Foo {

        private AtomicInteger firstJobDone = new AtomicInteger();
        private AtomicInteger secondJobDone = new AtomicInteger();

        public Foo() {


        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstJobDone.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            while(firstJobDone.get() != -1) {

            }
            printSecond.run();

            secondJobDone.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            while (secondJobDone.get() != -1) {

            }
            printThird.run();
        }
    }


}
