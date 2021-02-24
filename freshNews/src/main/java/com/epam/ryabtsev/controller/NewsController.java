package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.DTO.ArticleDTO;
import com.epam.ryabtsev.config.SpringConfig;
import com.epam.ryabtsev.converter.Converter;
import com.epam.ryabtsev.dao.ArticleDAO;
import com.epam.ryabtsev.dao.impl.ArticleDAOImpl;
import com.epam.ryabtsev.entity.Article;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes
public class NewsController {

    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    Converter converter = new Converter();
    ArticleDAO articleDAO = (ArticleDAO) context.getBean("articleDAO");

    @RequestMapping("/")
    public String newsList(Model model) {
        List<Article> articles = articleDAO.getArticles();

        model.addAttribute("articleDTO", new ArticleDTO());
        model.addAttribute("listArticle", articles);
        return "newsList";
    }

    @RequestMapping("/home")
    public String home() {
        return "redirect:/";
    }


    @Monitor
    @RequestMapping(value = "/add")
    public String add(Model m) {

        LocalDate currentDate = LocalDate.now();
        m.addAttribute("articleDTO", new ArticleDTO());
        m.addAttribute("currentDate", currentDate);
        return "addNews";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public String addArticle(@Valid @ModelAttribute("articleDTO") ArticleDTO articleDTO, BindingResult bindingResult, Model m) {
        if (bindingResult.hasErrors()) {
            System.out.println("we have problem with valid");
            m.addAttribute("articleDTO", new ArticleDTO());
            return "addNews";
        }
        Article article = converter.convertArticleDTO(articleDTO);
        articleDAO.saveArticle(article);

        List<Article> articles = articleDAO.getArticles();

        m.addAttribute("articleDTO", new ArticleDTO());
        m.addAttribute("listArticle", articles);
        return "newsList";
    }

    /*@PostMapping(value = "/editArticle")
    public String editArticle(@ModelAttribute("article") Article article, BindingResult result, Model m) {
        ArticleDAO articleDAO1 = (ArticleDAO) context.getBean("articleDAO");
        if (result.hasErrors()) {

            System.out.println("we have problem with valid");
            m.addAttribute("articleDTO", new ArticleDTO());
            return "addNews";
        }

        ArticleDAO articleDAO = new ArticleDAOImpl();
        articleDAO1.updateArticle(article);
        List<Article> articles = articleDAO.getArticles();
        m.addAttribute("listArticle", articles);
        return "newsList";
    }*/

    @GetMapping(value = "/showArticle/{id}/{action}")
    public String showArticle(@PathVariable String id, @PathVariable String action, Model model) {
        ArticleDTO articleDTO = converter.convertEntity(articleDAO.getArticle(Integer.parseInt(id)));

        model.addAttribute("command", new ArticleDTO());
        model.addAttribute("article", articleDTO);
        if (action.equals("show")) {
            return "newsView";
        } else if (action.equals("edit")) {
            return "editArticle";
        }

        return "redirect:/";
    }

    @PostMapping(value = "/showArticle/{id}/update")
    public String updateArticle(@ModelAttribute("articleDTO") ArticleDTO articleDTO, Model model) {
        Article article = converter.convertArticleDTO(articleDTO);
        articleDAO.updateArticle(article);
        List<Article> articles = articleDAO.getArticles();
        model.addAttribute("listArticle", articles);

        return "redirect:/";
    }

    @PostMapping(value = "/deleteNews")
    public String deleteNews(@ModelAttribute("articleDTO") ArticleDTO articleDTO) {
        System.out.println("TEST delete: " + articleDTO.getIdDel().length);
        for (String a : articleDTO.getIdDel()) {
            System.out.println("test id: " + a);
            articleDAO.deleteArticle(Integer.parseInt(a));
        }
        return "redirect:/";
    }
}
