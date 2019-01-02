package br.rafaelbernabeu.springProject.util;

import java.util.HashMap;
import java.util.Map;

public class SingletonUtil {

    private static final Map<Class, Object> singletonInstances = new HashMap<>();

    public static <T> T createInstance(Class<T> requestedInstance) throws IllegalAccessException, InstantiationException {
        return (T) putInstance(requestedInstance.newInstance());
    }

    public static <T> T putInstance(T instance) throws IllegalAccessException, InstantiationException {
        return SingletonUtil.putInstance(instance, Boolean.FALSE);
    }

    public static <T> T putInstance(T instance, Boolean override) throws InstantiationException, IllegalAccessException {
        if (!singletonInstances.containsKey(instance.getClass()) || override) {
            synchronized (SingletonUtil.class) {
                if (!singletonInstances.containsKey(instance.getClass()) || override) {
                    singletonInstances.put(instance.getClass(), instance);
                }
            }
        }
        return instance;
    }

    public static <T> T getInstance(Class<T> requestedInstance) {
        return (T) singletonInstances.get(requestedInstance);
    }

}
