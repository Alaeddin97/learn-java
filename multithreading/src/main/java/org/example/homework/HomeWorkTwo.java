package org.example.homework;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HomeWorkTwo {
    public static void main(String[] args) throws InterruptedException {
    Spam spam=new Spam(2);
        ExecutorService es= Executors.newFixedThreadPool(2);

    for (int i=0;i<spam.getMessages().length;i++){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Add time interval: ");
        int time=scanner.nextInt();
        System.out.println("Add corresponding message: ");
        String message=scanner.next();
        spam.addTimeIntervalMessage(time,message);
    }
    for (int i=0;i<spam.getMessages().length;i++){
        System.out.println(spam.getMessages()[i]);
        TimeUnit.MILLISECONDS.sleep(spam.getTimeIntervals()[i]);
    }

    }
}








class Spam{
    private static int index=0;
    private final int[] timeIntervals;
    private final String[] messages;

    public Spam(int length){
        timeIntervals=new int[length];
        messages=new String[length];
    }

    public void addTimeIntervalMessage(int time,String message){
       if (index<timeIntervals.length){
           this.timeIntervals[index]=time;
           this.messages[index]=message;
           index++;
       }
    }

    public int[] getTimeIntervals() {
        return timeIntervals;
    }

    public String[] getMessages() {
        return messages;
    }
}
