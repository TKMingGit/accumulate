package com.tkming.thread.producerandconsumer;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/11 15:15
 * @desc 暂无
 */
class Storage {
    Product[] products = new Product[10];
    int top = 0;
    /**
     * 生产者放入产品
     */
    synchronized void push(Product product) throws InterruptedException {
        while (top == products.length) {
            System.out.println("producer wait");
            wait();
        }
        products[top++] = product;
        System.out.println(Thread.currentThread().getName() +"生产产品: " + product  + ",库存: " + top);
        notifyAll();
    }

    /**
     * 消费者拿出产品
     */
    synchronized Product pop() throws InterruptedException {
        while (top == 0) {
            System.out.println("consumer wait");
            wait();
        }
        --top;
        Product product = new Product(products[top].getId(), products[top].getName());
        products[top] = null;
        System.out.println(Thread.currentThread().getName() + "消费产品: " + product + ",库存: " + top);
        notifyAll();
        return product;
    }
}
