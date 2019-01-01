package br.rafaelbernabeu.springProject.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {

    private static ExecutorService executorService;

    public static ExecutorService getExecutorService() {
        if (executorService == null) {
            synchronized (ThreadUtil.class) {
                if (executorService == null) {
                    executorService = Executors.newCachedThreadPool();
                }
            }
        }
        return executorService;
    }
}