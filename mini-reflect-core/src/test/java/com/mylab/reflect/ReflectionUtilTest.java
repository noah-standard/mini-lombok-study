package com.mylab.reflect;

import org.junit.jupiter.api.Test;

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
}