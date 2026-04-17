package com.mylab.reflect;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilTest {

    @Test
    void main() {
        User u = new User(1L, "kimi", 18);
        try {
            System.out.println(ReflectionUtil.dump(u));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test() {
        String s = "123";
        try {
            ReflectionUtil.dump(s);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test1() throws NoSuchFieldException, IllegalAccessException {
        Config c = new Config("123");
        Field f = Config.class.getDeclaredField("apiKey");
        f.setAccessible(true);
        f.set(c,"NEW");
        System.out.println(c.apiKey);
    }

    public class Config{
        private final String apiKey;
        public Config(String apiKey){
            this.apiKey = apiKey;
        }
    }

    @Test
    void name() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<?> clazz = User.class;
        Constructor<?> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);
        Object instance = ctor.newInstance();

        User u = (User) instance;
    }

    @Test
    void i2() {
//        User original = new User(1L, "kim", 30);
//        User shallow = original;
//        shallow.name = "modified";
//
//        User deep = deepCopy(original);
//        deep.name = "modified";
    }

    @Test
    void main3() throws IllegalAccessException {
        User u = Instantiator.newInstance(User.class);
        System.out.println(u);
        System.out.println(ReflectionUtil.dump(u));

    }
}