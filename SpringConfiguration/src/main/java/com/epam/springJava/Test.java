package com.epam.springJava;

import com.epam.springJava.entity.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Autowired
    @Qualifier("dog")
    Animal animal;
}
