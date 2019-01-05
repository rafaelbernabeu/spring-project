package br.rafaelbernabeu.springProject.util;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;

public class ForkJoinTaskUtil<T> extends RecursiveTask<List<T>> {

    private final ForkJoinPool pool;
    private final List<T> tasks;
    private final int start;
    private final int end;
    private final Consumer<T> command;
    private int splitValue;

    public ForkJoinTaskUtil(List<T> tasks, Consumer<T> command) {
        this(tasks, 0, tasks.size(), command, getSplitValue(tasks));
    }

    private ForkJoinTaskUtil(List<T> tasks, int start, int end, Consumer<T> command, int splitValue) {
        pool = SingletonUtil.createInstance(ForkJoinPool.class);
        this.tasks = tasks;
        this.start = start;
        this.end = end;
        this.command = command;
        this.splitValue = splitValue;
    }

    @Override
    protected List<T> compute() {
        if (end - start <= splitValue) {
            for (int i = start; i < end; i++) {
                command.accept(tasks.get(i));
            }
            return tasks.subList(start, end);
        } else {
            int middle = start + ((end - start) / 2);
            System.out.println("start: " + start + ", middle: " + middle + ", end: " + end);
            RecursiveTask<List<T>> otherTask = new ForkJoinTaskUtil<T>(tasks, start, middle, command, splitValue);
            otherTask.fork();
            List<T> resultList = new CopyOnWriteArrayList<>(new ForkJoinTaskUtil<T>(tasks, middle, end, command, splitValue).compute());
            resultList.addAll(otherTask.join());
            return resultList;
        }
    }

    public List<T> start() {
        return pool.invoke(this);
    }

    public List<T> start(int splitValue) {
        this.splitValue = splitValue;
        return pool.invoke(this);
    }

    private static <T> int getSplitValue(List<T> tasks) {
        int listSize = tasks.size();
        int cores = Runtime.getRuntime().availableProcessors();
        if (listSize >= 1000) {
            return listSize / (cores * 4);
        } else if (listSize >= 100) {
            return  listSize / (cores * 2);
        } else {
            return listSize / cores;
        }
    }
}
