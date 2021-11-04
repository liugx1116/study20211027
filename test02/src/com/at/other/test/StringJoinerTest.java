package com.at.other.test;

import org.junit.Test;

import java.util.StringJoiner;

public class StringJoinerTest {

    /**
     * StringJoiner 测试
     */
    @Test
    public void  testStringJoiner(){
        StringJoiner stringJoiner = new StringJoiner(",","(","}");
        System.out.println(stringJoiner.toString());
        stringJoiner.add("哈哈");
        System.out.println(stringJoiner.toString());
        stringJoiner.add("嘿嘿");
        stringJoiner.add("呵呵");
        System.out.println(stringJoiner);

    }
}
