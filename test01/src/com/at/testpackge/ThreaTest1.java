package com.at.testpackge;

/**
 * 创建多线程方式二： 实现Runable接口
 * 1.创建一个实现了Runable接口的类
 * 2.实现类中实现Runable中的抽象方法：run()
 * 3. 创建实现类的对象
 * 4. 将此对象作为参数传递到Threa类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用 start()
 *
 * 比较创建线程的两种发方式
 * 开发中优先选用 实现Runable接口的方式
 *      原因：1. 实现类没有类的单继承局限
 *           2. 实现的方式对于处理多线程之间的共享数据更便利
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中。
 */
public class ThreaTest1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        t1.start();
        t2.start();
    }
}
// 1.创建一个实现了Runable接口的类
class MyThread implements Runnable{
    // 2.实现类中实现Runable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0 ){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
