package com.epam.springJava.entity;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog() {
    }

    public void voice() {
        System.out.println("I'm barking");
    }
}
