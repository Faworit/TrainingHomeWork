package com.epam.ryabtsev.config;

import com.epam.ryabtsev.aspect.AspectLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public AspectLogger aspectLogger() {
        return new AspectLogger();
    }
}
