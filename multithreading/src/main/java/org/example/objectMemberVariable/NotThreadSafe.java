package org.example.objectMemberVariable;

public class NotThreadSafe {

    public static void main(String[] args) {
        NotThreadSafe sharedInstance = new NotThreadSafe();
        new Thread(new MyRunnable(sharedInstance)).start();
        new Thread(new MyRunnable(sharedInstance)).start();
        System.out.println(sharedInstance.builder.toString());
    }
    StringBuilder builder = new StringBuilder();

    public void add(String text){
        this.builder.append(text);
    }

    public static class MyRunnable implements Runnable{
        NotThreadSafe instance = null;

        public MyRunnable(NotThreadSafe instance){
            this.instance = instance;
        }

        public void run(){
            this.instance.add("some text");
        }
    }
}
