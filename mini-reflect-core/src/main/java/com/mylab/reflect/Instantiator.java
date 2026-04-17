package com.mylab.reflect;

import java.lang.reflect.Constructor;

public class Instantiator {

    public static <T> T newInstance(Class<T> clazz) {
        try{
            Constructor<T> ctor = clazz.getDeclaredConstructor();
            ctor.setAccessible(true);
            return ctor.newInstance();

        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Cannot instantiate " + clazz.getName() + " . Does it have a no-arg constructor?");
        }

    }
}
