package com.epam.springXML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartXML {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("TEST: " + context.getBean("person", Person.class));

        context.close();
    }
}
