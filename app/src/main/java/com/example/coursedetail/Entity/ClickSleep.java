package com.example.coursedetail.Entity;


public class ClickSleep {
    private boolean isRuning = false;

    public boolean isRuning() {

        return isRuning;

    }

    //运行线程，开始休眠线程

    public void runWithTime(final long defaultSleepTime) {

        isRuning = true;

        new Thread() {

            @Override

            public void run() {

                try {

                    sleep(defaultSleepTime, 0);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                isRuning = false;

                super.run();

            }

        }.start();

    }

}

