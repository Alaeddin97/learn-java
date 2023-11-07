package org.example.waitnotify;

public class MainClass {
    public static void main(String[] args) {
        Message message=new Message("the message");
        Reader reader=new Reader(message);
        Notifier notifier=new Notifier(message);

        Thread reader1=new Thread(reader,"READER 1");
        reader1.start();
        Thread reader2=new Thread(reader,"READER 2");
        reader2.start();
        new Thread(notifier,"NOTIFIER").start();
        System.out.println("All threads are started");
    }
}
