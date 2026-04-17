package com.mylab.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class DeepCopier {

    /**
     * 객체를 복사합니다.
     *
     * 한계 : List, Map 같은 가변 참조 필드는 원본과 공유됩니다.
     * 예 : original.tags.add(...) 하면 copy.tags 도 영향받습니다.
     * 진짜 독립 복사는 아직 구현 안됨.
     * @param obj
     * @return
     * @param <T>
     */
    public static <T> T copy(T obj){
        if (obj == null) return null;

        @SuppressWarnings("unchecked")
                Class<T> clazz = (Class<T>) obj.getClass();

        T copy = Instantiator.newInstance(clazz);
        copyFieldRecursively(obj, copy, clazz);
        return copy;
    }

    private static void copyFieldRecursively(Object obj, Object copy, Class<?> clazz) {
        if (clazz == null || clazz == Object.class) return;

        copyFieldRecursively(obj, copy, clazz.getSuperclass());

        for (Field f : clazz.getDeclaredFields()) {
            if(Modifier.isStatic(f.getModifiers())) continue;

            f.setAccessible(true);
            try {
                Object value = f.get(obj);
                f.set(copy,value);
            }catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
