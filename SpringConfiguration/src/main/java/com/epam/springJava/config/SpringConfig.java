package com.epam.springJava.config;

import com.epam.springJava.Start;
import com.epam.springJava.entity.Animal;
import com.epam.springJava.entity.Cat;
import com.epam.springJava.entity.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public Animal dog() {
        return new Dog("Rex", 5);
    }

    @Bean
    public Animal cat() {
        return new Cat(2, "murzik");
    }

    @Bean
    public Start start(){
        return new Start();
    }
}
