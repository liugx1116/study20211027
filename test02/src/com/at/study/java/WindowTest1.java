package com.at.study.java;

/**
 * 同步 :在Java中，我们通过同步机制，来解决线程的安全问题。
 * 方式一： 同步代码块
 *synchronized{
 *     // 需要被同步的代码块
 *}
 *说明：1.操作共享数据的代码，即为需要被同步的代码 --> 不能包含代码多了，也不能包含代码少了.
 *     2.共享数据：多个线程共同操作变量： 例如 票ticket 就是共享数据
 *     3.同步监视器，俗称：锁。 任何一个类的对象都可以充当锁
 *      要求：多个线程必须共用同一个锁
 *补充： 实现Runable接口创建的多线程，可以考虑使用this充当同步监视器
 * 方式二：同步方法
 *      如果操作共享数据的代码完整的声明在一个方法中，可以将此方法申明为同步的。
 *  说明： 同步的方式，解决了线程的安全问题（好处），另一方面操作同步代码时，只能有一个线程参与，其他的线程等待
 *      相当于是一个单线程的过程，效率低（局限性）。
 */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();
        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
