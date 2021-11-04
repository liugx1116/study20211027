package com.at.study.java;

/**
 *使用同步方法处理继承Thread类的方式中的线程安全问题
 */
public class WindowTest03 {

    public  static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();


        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window3 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private static synchronized void show() {
        if(ticket >0){
            System.out.println(Thread.currentThread().getName()+"：票号为："+ticket);
            ticket--;
        }
    }
}
