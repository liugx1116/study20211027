package com.at.study.java;

/**
 * 使用同步方法解决实现Runable接口 线程安全问题
 *
 * 关于同步方法总结：
 *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显示声明
 */
public class WindowTest02 {

    public  static void main(String[] args) {
        Window2 w3 = new Window2();
        Thread t1 = new Thread(w3);
        Thread t2 = new Thread(w3);
        Thread t3 = new Thread(w3);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Window2 implements Runnable{

    private  int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }
    private  synchronized void show() {
        if(ticket >0){
            System.out.println(Thread.currentThread().getName()+"：票号为："+ticket);
            ticket--;
        }
    }
}