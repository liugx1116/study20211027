package com.at.Serializable.test;

import java.io.Serializable;

/**
 * 测试序列化与反序列化
 * 步骤：
 * 1.需要实现接口：Serializable
 */
public class Person  implements Serializable {

    /*
    步骤：
    1.需要实现接口：Serializable
    2.当前类提供一个全局常量：serialVersionUID
    3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所属性
      也必须是可序列化的。（默认情况下，基本数据类型可序列化）
     */
    private static final long serialVersionUID = -5809782578272943888L;

    private int age ;
    private String name;
    private String sex;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

