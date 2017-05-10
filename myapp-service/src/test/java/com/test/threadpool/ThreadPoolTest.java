package com.test.threadpool;import java.util.concurrent.ExecutorService;import java.util.concurrent.Executors;import java.util.concurrent.ScheduledExecutorService;import java.util.concurrent.TimeUnit;/** * Created by zhaogang3 on 2017/2/13. */public class ThreadPoolTest {    public static void main(String[] args) throws InterruptedException {        ExecutorService executorService = Executors.newFixedThreadPool(10);        for (int i = 0; i < 1000000; i++) {            executorService.execute(new Runnable() {                @Override                public void run() {                    for(int j=0;j<10000000;j++){                        try {                            //Thread.sleep(100L);                            Math.sin(j);                            //System.out.println("hello"+Thread.currentThread().getName());                        } catch (Exception e                            ) {                            //e.printStackTrace();                        }                    }                }            });        }        executorService.awaitTermination(1, TimeUnit.DAYS);        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();    }}