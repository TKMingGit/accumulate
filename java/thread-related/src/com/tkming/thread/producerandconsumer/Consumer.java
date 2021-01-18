package com.tkming.thread.producerandconsumer;

import java.util.Random;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 15:14
 * @desc 暂无
 */
class Consumer implements Runnable {
    private Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
        while (true) {
            try {
                storage.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(new Random().nextInt(10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
