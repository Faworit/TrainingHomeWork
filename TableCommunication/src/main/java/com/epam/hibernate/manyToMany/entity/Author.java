package com.epam.hibernate.manyToMany.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "author_id")
    private int authorId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_article",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "article_id")}
    )
    private Set<Article> articles;

    public Author() {
    }

    public int getAuthorId() {
        return authorId;
    }


    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
