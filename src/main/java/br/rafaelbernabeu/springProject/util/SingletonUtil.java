package br.rafaelbernabeu.springProject.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SingletonUtil {

    private static final Map<Class, Object> singletonInstances = new HashMap<>();

    public static <T> T createInstance(Class<T> requestedInstance) {
        return createInstance(requestedInstance, null);
    }

    public static <T, E> T createInstance(Class<T> requestedInstance, Class<E>[] parameterTypes, Object... objArgs) {
        try {
            return (T) putInstance(requestedInstance.getDeclaredConstructor(parameterTypes).newInstance(objArgs));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T putInstance(T instance) {
        return SingletonUtil.putInstance(instance, Boolean.FALSE);
    }

    public static <T> T putInstance(T instance, Boolean override) {
        if (override || !singletonInstances.containsKey(instance.getClass())) {
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
