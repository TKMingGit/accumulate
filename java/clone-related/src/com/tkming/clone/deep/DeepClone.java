package com.tkming.clone.deep;

import java.io.*;

/**
 * @author zhaoming-026
 * @version 1.0
 * @date 2020/3/24
 * @description 深克隆就是引用类型的属性完全复制
 * 1.clone函数的嵌套调用: 既然引用类型无法被完全克隆，那将引用类型也实现Cloneable接口重写clone方法，在User类中的clone方法调用属性的克隆方法，也就是方法的嵌套调用;
 * 2.序列化: 序列化方式只需要给每个类都实现一个Serializable接口，也是标记接口，最后同序列化和反序列化操作达到克隆的目的（包括数组的复制）
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        //clone函数的嵌套调用
        Grade grade = new Grade("three", "math");
        Teacher mrWang = new Teacher("MrWang", "male", grade);
        Teacher mrWangClone = (Teacher) mrWang.clone();
        mrWangClone.setName("MrWangClone");
        mrWangClone.setSex("female");
        mrWangClone.getGrade().setLevel("four");
        mrWangClone.getGrade().setSubject("Chinese");
        System.out.println(mrWang);
        System.out.println(mrWangClone);

        //序列化
        GradeSer grade2 = new GradeSer("three2", "math2");
        TeacherSer mrWang2 = new TeacherSer("MrWang2", "male2", grade2);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(mrWang2);
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        //反序列化
        TeacherSer mrWangClone2 = (TeacherSer) oi.readObject();
        mrWangClone2.setName("MrWangClone2");
        mrWangClone2.setSex("female2");
        mrWangClone2.getGradeSer().setLevel("four2");
        mrWangClone2.getGradeSer().setSubject("Chinese2");
        System.out.println(mrWang2);
        System.out.println(mrWangClone2);
    }
}
