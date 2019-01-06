package br.rafaelbernabeu.springProject.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {

    public static ExecutorService getExecutorService() {
        return SingletonUtil.getInstance(ThreadPoolExecutor.class,
                new Class[]{int.class, int.class, long.class, TimeUnit.class, BlockingQueue.class},
                0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }
}