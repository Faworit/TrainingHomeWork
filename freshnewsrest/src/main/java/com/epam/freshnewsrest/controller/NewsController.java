package com.epam.freshnewsrest.controller;

import com.epam.freshnewsrest.DTO.ArticleDTO;
import com.epam.freshnewsrest.converter.Converter;
import com.epam.freshnewsrest.entity.Article;
import com.epam.freshnewsrest.repository.ArticleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class NewsController {

    Converter converter = new Converter();

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping("/")
    public String newsList() {
        Pageable firstPage = PageRequest.of(0, 2);
        Page<Article> articles =  articleRepository.findAll(firstPage);

        String json = new Gson().toJson(articles);
        return json;
    }

    @GetMapping("/pagination")
    public String pagination(@RequestParam int page) {
        System.out.println("TEST in pagination");
        Pageable firstPage = PageRequest.of(page, 2);
        Page<Article> articles =  articleRepository.findAll(firstPage);

        String json = new Gson().toJson(articles);
        return json;
    }

    @PostMapping(value = "/addArticle")
    public ResponseEntity addArticle(@Valid @RequestBody ArticleDTO articleDTO) {
        Article article = Converter.article.convert(articleDTO);
        articleRepository.save(article);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping(value = "/showArticle/{id}")
    public String showArticle(@PathVariable String id) {
        ArticleDTO articleDTO = converter.convertEntity(articleRepository.findByArticleId(Integer.parseInt(id)));
        String json = new Gson().toJson(articleDTO);
        return json;
    }

    @PostMapping(value = "/deleteNews")
    public ResponseEntity deleteNews(@RequestBody String delete) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        List<ArticleDTO> dtoList = mapper.readValue(delete, new TypeReference<List<ArticleDTO>>(){});

        for (ArticleDTO articleDTO : dtoList) {
            Article article = converter.convertArticleDTO(articleDTO);
            articleRepository.delete(article);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
