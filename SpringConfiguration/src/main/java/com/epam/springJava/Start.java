package com.epam.springJava;

import com.epam.springJava.config.SpringConfig;


import com.epam.springJava.entity.Animal;
import com.epam.springJava.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Start {

    @Autowired
    @Qualifier("dog")
    private Animal animal;

    void print() {
        animal.voice();
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        System.out.println(context.getBean("cat"));

        Animal cat = (Animal) context.getBean("cat");
        cat.voice();

        Start start = (Start) context.getBean("start");

        start.print();




    }
}
