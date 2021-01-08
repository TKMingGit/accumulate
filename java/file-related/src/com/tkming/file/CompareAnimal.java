package com.tkming.file;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2020/12/25 16:31
 * @desc 暂无
 */
public class CompareAnimal {
    public static void main(String[] args) {

        Animal[] as = new Animal[4];

        // 初始化
        Scanner sc = new Scanner(System.in);

        // 利用hasNextXXX()判断是否还有下一输入项
        if (sc.hasNext()) {
            as[0] = new Dog("dog1", sc.nextInt());
        }

        if (sc.hasNext()) {
            as[1] = new Cat("cat1", sc.nextInt());
        }

        if (sc.hasNext()) {
            as[2] = new Dog("dog2", sc.nextInt());
        }

        if (sc.hasNext()) {
            as[3] = new Cat("cat2", sc.nextInt());
        }

        // 请补充排序
        Arrays.sort(as);

        // 请补充升序输出结果
        for (Animal a : as) {
            System.out.println(a.name + "," + a.age);
        }


    }
}


