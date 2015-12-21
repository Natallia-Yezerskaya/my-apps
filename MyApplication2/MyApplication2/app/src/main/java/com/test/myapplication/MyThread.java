package com.test.myapplication;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();

            while (isInterrupted())  {


                try {
                    sleep(5600);
                } catch (InterruptedException e) {

                }


            }



    }
}
