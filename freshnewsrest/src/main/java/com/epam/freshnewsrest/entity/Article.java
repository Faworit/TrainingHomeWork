package com.epam.freshnewsrest.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "artile_id")
    private int articleId;
    @Column(name = "title")
    private String title;
    @Column(name = "date")
    private Timestamp start;
    @Column(name = "brief")
    private String brief;
    @Column(name = "content")
    private String content;

    public Article() {
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}