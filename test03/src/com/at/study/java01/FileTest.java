package com.at.study.java01;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File file1 = new File("hello.txt");
        File file2 = new File("D:/aa/bb","hello");
        System.out.println(file1);
        System.out.println(file2);
        File file3 = new File(file2,"hell.txt");
        System.out.println(file3);
    }

}
