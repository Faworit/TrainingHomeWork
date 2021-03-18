package com.epam.ryabtsev.DTO;

import javax.persistence.Entity;
import javax.validation.constraints.*;


public class ArticleDTO {

    private int articleId;
    @NotBlank(message = "can't be null")
    private String title;
    @NotBlank(message = "not be null")
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}", message = "not correct format yyyy-mm-dd")
    private String start;
    @NotBlank(message = "not be null")
    @Size(max = 500)
    private String brief;
    @NotBlank(message = "can't be null")
    @Size(max = 2048)
    private String content;
    private String[] idDel;

    public ArticleDTO() {
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
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

    public String[] getIdDel() {
        return idDel;
    }

    public void setIdDel(String[] idDel) {
        this.idDel = idDel;
    }
}
