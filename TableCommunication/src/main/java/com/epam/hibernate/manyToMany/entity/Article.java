package com.epam.hibernate.manyToMany.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "article_id")
    private int articleId;
    @Column(name = "title")
    private String title;
    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER)
    private Set<Author> authors;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
