package com.at.Serializable.test;

import java.io.*;

public class TestObjSerializeAndDeserialize {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializePerson();
        Person person = DeserializePerson();
        System.out.println("反序列化结果"+" name="+person.getName()+", age="+person.getAge()+", sex"+person.getSex());

    }
    private static void SerializePerson() throws IOException {
        Person person = new Person();
        person.setName("张三");
        person.setAge(25);
        person.setSex("男");

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person序列化成功");
        oo.close();
    }

    private static Person DeserializePerson() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:/Person.txt")));
        Person p = (Person) ois.readObject();
        System.out.println("对象反序列化成功");
        return p;
    }
}
