package com.at.study.java;

/**
 * 使用同步机制将 单例模式中的懒汉式改写为线程安全
 */
public class Bank {

}

class BankTest{
    // 私有的构造器
    private BankTest (){}
    //
    private static BankTest instance = null;

    public static synchronized BankTest getInstance(){
        if(null == instance){
            instance =  new BankTest();
        }
        return instance;
    }
}
class Bank1{

    private Bank1(){}

    private static Bank1 instance1 = null;

    public static Bank1 getInstance1(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if(instance1 == null){
            synchronized (Bank1.class) {
                if(instance1 == null){

                    instance1 = new Bank1();
                }
            }
        }
        return instance1;
    }
}

class Bank2{
    private Bank2(){}
    private static Bank2 instance2 = null;
    public static Bank2 getInstance2(){
        if(instance2 == null){
            synchronized (Bank2.class){
                if(instance2 == null){
                    instance2 = new Bank2();
                }
            }
        }
        return  instance2;
    }
}