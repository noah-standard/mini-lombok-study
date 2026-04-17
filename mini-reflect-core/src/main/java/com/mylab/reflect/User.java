package com.mylab.reflect;

public class User extends Entity{

    private String name;
    public int age;
    private boolean active;
    private String email;

    public static final String TYPE = "USER";

    public User(){

    }

    public User(Long id,String name, int age){
        super(id);
        this.name = name;
        this.age = age;
        this.active = true;
    }
}
