package com.epam.ryabtsev.config;

import com.epam.ryabtsev.aspect.AspectLogger;
import com.epam.ryabtsev.dao.ArticleDAO;
import com.epam.ryabtsev.dao.impl.ArticleDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ArticleDAO articleDAO() {
        return new ArticleDAOImpl();
    }

    @Bean
    public AspectLogger aspectLogger() {
        return new AspectLogger();
    }

}
