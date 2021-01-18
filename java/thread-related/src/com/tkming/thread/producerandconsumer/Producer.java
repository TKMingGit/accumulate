package com.tkming.thread.producerandconsumer;

import java.util.Random;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 15:15
 * @desc 暂无
 */
class Producer implements Runnable {
    private Storage storage;

    public Producer(Storage storage) {
        this.storage = storage;
    }
    @Override
    public void run() {
        int i = 0;
        while (true) {
            i++;
            try {
                Product product = new Product(i , "电话" + new Random().nextInt(10000));
                storage.push(product);
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
