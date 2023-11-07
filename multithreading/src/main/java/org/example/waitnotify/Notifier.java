package org.example.waitnotify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable{
    Message message;
    public Notifier(Message m){
        this.message=m;
    }
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        try{
            TimeUnit.MILLISECONDS.sleep(100);
            synchronized (message){
                message.setMessage(name + "Notifier work done");
                message.notify();
                //message.notifyAll();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " is finished work");
    }
}
