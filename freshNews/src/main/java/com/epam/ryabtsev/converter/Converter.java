package com.epam.ryabtsev.converter;

import com.epam.ryabtsev.DTO.ArticleDTO;
import com.epam.ryabtsev.entity.Article;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static com.oracle.jrockit.jfr.DataType.UTF8;

public class Converter {

    public Article convertArticleDTO(ArticleDTO artcileDTO) {
        Article article = new Article();
        Timestamp time = null;

        try {
            time = new Timestamp(new SimpleDateFormat("yyyy-MM-dd").parse(artcileDTO.getStart()).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (artcileDTO.getArticleId() != 0) {
            article.setArticleId(artcileDTO.getArticleId());
        }

        article.setTitle(new String(artcileDTO.getTitle().getBytes(), StandardCharsets.UTF_8));
        article.setBrief(artcileDTO.getBrief());
        article.setStart(time);
        article.setContent(artcileDTO.getContent());

        return article;
    }

    public ArticleDTO convertEntity(Article article) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(article.getTitle());
        articleDTO.setBrief(article.getBrief());
        articleDTO.setContent(article.getBrief());
        articleDTO.setArticleId(article.getArticleId());
        String date = new Date(article.getStart().getTime()).toString();
        articleDTO.setStart(date);

        return articleDTO;
    }
}
