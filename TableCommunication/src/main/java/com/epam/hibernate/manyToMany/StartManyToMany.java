package com.epam.hibernate.manyToMany;

import com.epam.hibernate.manyToMany.dao.ArticleDAO;
import com.epam.hibernate.manyToMany.dao.AuthorDAO;
import com.epam.hibernate.manyToMany.dao.impl.ArticleDAOImpl;
import com.epam.hibernate.manyToMany.dao.impl.AuthorDAOImpl;
import com.epam.hibernate.manyToMany.entity.Article;
import com.epam.hibernate.manyToMany.entity.Author;

import java.util.HashSet;
import java.util.Set;

public class StartManyToMany {
    private static AuthorDAO authorDAO = new AuthorDAOImpl();
    private static ArticleDAO articleDAO = new ArticleDAOImpl();

    public static void main(String[] args) {
        //save();
        //saveAuthor();
        saveArticle();
        //deleteAuthor();
        //updateAuthor();
        //getAuthor(75);
    }

    private static void saveAuthor() {
        Author author = new Author();
        author.setName("Maksim");
        author.setSurname("Dorofeev");

        authorDAO.saveAuthor(author);

    }

    private static void getAuthor(int id) {
        AuthorDAO authorDAO = new AuthorDAOImpl();
        Author author = authorDAO.getAuthor(id);
    }

    private static void updateAuthor() {
        Author author = authorDAO.getAuthor(73);
        Article article = new Article();

        article.setTitle("Test article part 2");
        Set<Article> articles = new HashSet<Article>();
        for (Article a : author.getArticles()) {
            articles.add(a);
        }
        articles.add(article);

        author.setArticles(articles);
        authorDAO.updateAuthor(author);
    }

    private static void deleteAuthor() {
        Author author = authorDAO.getAuthor(66);
        authorDAO.deleteAuthor(author);
    }

    private static void save() {
        Author author = new Author();
        author.setName("Roger");
        author.setSurname("Zelazny");
        Author author1 = new Author();
        author1.setName("Stephan");
        author1.setSurname("King");

        Article article = new Article();

        article.setTitle("Test article");
        HashSet<Article> articles = new HashSet<Article>();
        articles.add(article);
        author.setArticles(articles);
        authorDAO.saveAuthor(author);
    }

    private static void saveArticle() {
        Author author = authorDAO.getAuthor(80);

        Article article = new Article();
        article.setTitle("How make money");

        Set<Article> articles = author.getArticles();
        articles.add(article);
        author.setArticles(articles);
        authorDAO.updateAuthor(author);





    }
}
