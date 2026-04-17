package com.mylab.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectionUtil {

    public static String dump(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        StringBuilder sb = new StringBuilder();

        sb.append(clazz.getSimpleName()).append("{\n");
        while(clazz != null && clazz != Object.class) {
            for (Field f : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) continue;
                appendField(obj, f, sb);
            }
            clazz = clazz.getSuperclass();
        }

        sb.append("}");
        return sb.toString();
    }

    private static void appendField(Object obj, Field f, StringBuilder sb) throws IllegalAccessException {
        f.setAccessible(true);
        Object value = f.get(obj);
        sb.append(String.format("\t%s (%s) = %s\n", f.getName(), f.getType().getSimpleName(), value));
    }
}
