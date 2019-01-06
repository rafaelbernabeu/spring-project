package br.rafaelbernabeu.springProject.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SingletonUtil {

    private static final Map<Class, Object> singletonInstances = new HashMap<>();

    public static <T> T getInstance(Class<T> requestedInstance) {
        return getInstance(requestedInstance, null);
    }

    public static <T> T getInstance(Class<T> requestedInstance, Class[] parameterTypes, Object... objArgs) {
        return getInstance(requestedInstance, false, parameterTypes, objArgs);
    }

    public static <T> T getInstance(Class<T> requestedInstance, boolean override, Class[] parameterTypes, Object... objArgs) {
        T instance = getFromMap(requestedInstance);
        if (instance == null) {
            synchronized (SingletonUtil.class) {
                if (getFromMap(requestedInstance) == null) {
                    try {
                        return (T) putInMap(requestedInstance.getDeclaredConstructor(parameterTypes).newInstance(objArgs), override);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
        }
        return instance;
    }

    private static <T> T putInMap(T instance, Boolean override) {
        if (override || !singletonInstances.containsKey(instance.getClass())) {
            synchronized (SingletonUtil.class) {
                if (override || !singletonInstances.containsKey(instance.getClass())) {
                    singletonInstances.put(instance.getClass(), instance);
                }
            }
        }
        return (T) singletonInstances.get(instance.getClass());
    }

    private static <T> T getFromMap(Class<T> requestedInstance) {
        return (T) singletonInstances.get(requestedInstance);
    }

}
