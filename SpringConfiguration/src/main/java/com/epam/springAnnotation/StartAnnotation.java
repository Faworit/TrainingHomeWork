package com.epam.springAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartAnnotation {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextMix.xml");


        System.out.println(context.getBean("person", Person.class));



    }
}
