package com.sourceit.courses.devs.classes.class09.example05;


class MonitorObj {
    // В данном классе объявлены 2 синхронизированных метода f() и g()
    private String name;
    public MonitorObj(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void f(){
        System.out.println("f() started for object" + name);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("f() finished for object" + name);
    }

    public synchronized void g(){
        System.out.println("g() started for object" + name);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("g() finished for object" + name);
    }
}

class Thread1 extends Thread{
    private MonitorObj myObj;
    public Thread1(MonitorObj myObj){ this.myObj = myObj; }
    public void run(){
        myObj.f();
    }
}


class Thread2 extends Thread{
    private MonitorObj myObj;
    public Thread2(MonitorObj myObj){ this.myObj = myObj; }
    public void run(){
        myObj.g();
    }
}

class Thread3 extends Thread{
    private final MonitorObj monitor;
    public Thread3(MonitorObj monitor){
        this.monitor = monitor;
    }
    public void run() {
        synchronized(monitor){
            System.out.println("synchronized section started for object" + monitor.getName());
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            System.out.println("synchronized section finished for object" + monitor.getName());
        }
    }
}

public class SynchTest {
    public static void main(String[] args) {
        MonitorObj myObj = new MonitorObj("Monitor 1");
        // Вызов потоков с синхронизацией по MyObject1
        Thread1 t1 = new Thread1(myObj);
        Thread2 t2 = new Thread2(myObj);
        Thread3 t3 = new Thread3(myObj);

        // Вызов потока с синхронизацией по MyObject2
        MonitorObj myObj1 = new MonitorObj("Monitor 2");
        Thread1 t4 = new Thread1(myObj1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

