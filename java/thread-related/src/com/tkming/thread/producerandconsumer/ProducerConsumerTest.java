package com.tkming.thread.producerandconsumer;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 14:08
 * @desc 经典生产者和消费者问题：生产者不断往仓库中放产品，消费者从仓库中拿产品
 * 其中生产者和消费者可以有多个
 * 仓库规则：容量有限，库满时不能存放，库空时不能取产品
 */
public class ProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new Storage();
        new Thread(new Producer(storage), "生产者1").start();
        //new Thread(new Producer(storage), "生产者2").start();
        Thread.sleep(1000);
        new Thread(new Consumer(storage), "消费者1").start();
        //new Thread(new Consumer(storage), "消费者2").start();
    }
}