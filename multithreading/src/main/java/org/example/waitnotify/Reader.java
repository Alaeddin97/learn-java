package org.example.waitnotify;

public class Reader implements Runnable {
    Message message;
    public Reader(Message message){
        this.message=message;
    }
    @Override
    public void run() {
        String name= Thread.currentThread().getName();
        synchronized (message){
           try{
               System.out.println(name+ " processed message: " + message.getMessage());
               message.wait();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
            System.out.println(name + " is waiting to be notified");
            System.out.println(Thread.currentThread().getName() + " is proceeding execution");
        }
    }
}
