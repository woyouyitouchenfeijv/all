package com.lock;

import java.util.concurrent.Exchanger;

/**
 * @Description
 * @Date 2023/2/11
 */
public class TestExchanger {

    /**
     * 定义一个被交换的类，里面有个属性name
     */
    public static class ChangeObj{
        private String name;
        public ChangeObj(String n ){
            name = n;
        }
    }


    /**
     * 俩需要交换的类 并且都是多线程
     */
    public static class aaa implements Runnable{
        Exchanger<ChangeObj> ex;

        public aaa(Exchanger<ChangeObj> e){
            ex = e;
        }
        @Override
        public void run() {
            ChangeObj changeObj = new ChangeObj("输出1");

            try {
                System.out.println("先执行1");
                ChangeObj exchange = ex.exchange(changeObj);
                System.out.println(exchange.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static class bbb implements Runnable{
        Exchanger<ChangeObj> ex;

        public bbb(Exchanger<ChangeObj> e){
            ex = e;
        }
        @Override
        public void run() {
            ChangeObj changeObj = new ChangeObj("输出2");
            try {
                System.out.println("先执行2");
                ChangeObj exchange = ex.exchange(changeObj);
                System.out.println(exchange.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




    public static void main(String[] args) throws InterruptedException {
        Exchanger<ChangeObj> changeObjExchanger = new Exchanger<>();
        new Thread(new aaa(changeObjExchanger)).start();
        new Thread(new bbb(changeObjExchanger)).start();
    }
}
