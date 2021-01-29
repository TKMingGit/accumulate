package com.otg.tkming.jvmrelated;

/**
 * @version 1.0
 * @Author zhaoming-026
 * @create 2021/1/27 9:12
 * @desc 暂无
 */
public class ClassLoadOrderTest {
    //变量test无static修饰符，不是类变量，类初始化的时候不会执行构造块及构造方法
    //Test test = new Test();
    static ClassLoadOrderTest classLoadOrderTest = new ClassLoadOrderTest();
    static {
        System.out.println("静态块1");
        //静态块可以给后面的静态变量赋值，但是不能使用
        a = 3;
        //System.out.println("静态块1-a:" + a); //使用后面的变量a,会编译错误：Illegal forward reference

    }
    {
        System.out.println("构造块3-a:" + a);
        System.out.println("构造块3-b:" + b);
    }
    //a如果不赋值执行静态块2时输出："静态块2-a:1",
    //a如果赋值3执行静态块2时输出："静态块2-a:3",
    public static int a;
    public static int b=3;
    static {
        a++;
        b++;
        System.out.println("静态块2-a:" + a);
        System.out.println("静态块2-b:" + b);
    }
    {
        System.out.println("构造块2-a:" + a);
        System.out.println("构造块2-b:" + b);
    }
    {
        System.out.println("构造块1-a:" + a);
        System.out.println("构造块1-b:" + b);
    }
    public ClassLoadOrderTest() {
        a++;
        b++;
        System.out.println("构造方法a:" + a);
        System.out.println("构造方法b:" + b);
    }

    public static void main(String[] args) {
        System.out.println(ClassLoadOrderTest.a);
        System.out.println(ClassLoadOrderTest.b);
    }
}
