package com.mylab.reflect;

public class Entity {
    protected Long id;
    protected Long createAt;

    public Entity() {}

    public Entity(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
