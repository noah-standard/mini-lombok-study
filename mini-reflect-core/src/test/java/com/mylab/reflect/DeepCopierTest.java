package com.mylab.reflect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeepCopierTest {

    @Test
    void name() throws IllegalAccessException {
        User original = new User(1L, "kim", 30);
        User copy = DeepCopier.copy(original);

        System.out.println(original == copy);
        System.out.println(original.getId() == copy.getId());

        copy.setName("park");
        System.out.println(
                ReflectionUtil.dump(original)
        );
        System.out.println(ReflectionUtil.dump(copy));

    }
}