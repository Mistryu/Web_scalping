package com.projects;

public class Main {

    public static void main(String[] args) {
        String[] urls =  {""};

        String[] urls2 = {""};

        //Here you can put multiple files
        Thread t1 = new Thread(new ThreadProgram(urls, "src/com/projects/test.txt"));
        Thread t2 = new Thread(new ThreadProgram(urls2, "src/com/projects/test2.txt"));

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (Exception ex){
            System.out.println("Exception");
        }

    }
}
