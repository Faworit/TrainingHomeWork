package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.DTO.ArticleDTO;
import com.epam.ryabtsev.converter.Converter;
import com.epam.ryabtsev.entity.Article;
import com.epam.ryabtsev.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes
public class NewsController {

    Converter converter = new Converter();

    @Autowired
    ArticleRepository articleRepository;




    @RequestMapping("/")
    public String newsList(Model model) {
        List<Article> articles = articleRepository.findAll();

        model.addAttribute("articleDTO", new ArticleDTO());
        model.addAttribute("listArticle", articles);
        return "newsList";
    }

    @RequestMapping("/home")
    public String home() {
        return "redirect:/";
    }

    /*@RequestMapping("/hello")
    public String helloWorld(Model m) {
        String message = "Hello World, Spring MVC @ Javatpoint";
        m.addAttribute("message", message);
        return "hello";
    }*/

    @RequestMapping(value = "/add")
    public String add(Model m) {

        LocalDate currentDate = LocalDate.now();
        m.addAttribute("articleDTO", new ArticleDTO());
        m.addAttribute("currentDate", currentDate);
        return "addNews";
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    public ModelAndView addArticle(@ModelAttribute("articleDTO") @Valid ArticleDTO articleDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("we have problem with valid");
            System.out.println("test bindingresult: " + bindingResult.getObjectName() + " asd " + bindingResult.getFieldError());
            //m.addAttribute("articleDTO", new ArticleDTO());
           // m.addAttribute("errors", bindingResult.getModel());
            return new ModelAndView("addNews", bindingResult.getModel());
        }
        Article article = converter.convertArticleDTO(articleDTO);
        //articleDAO.saveArticle(article);
        articleRepository.save(article);

        List<Article> articles = articleRepository.findAll();

       // m.addAttribute("articleDTO", new ArticleDTO());
      // m.addAttribute("listArticle", articles);
        ModelAndView modelAndView = new ModelAndView("newsList");
        modelAndView.addObject("listArticle", articles);
        modelAndView.addObject("articleDTO", new ArticleDTO());
        //return "newsList";
        return modelAndView;
    }

    @PostMapping(value = "/editArticle")
    public String editArticle(@ModelAttribute("article") Article article, BindingResult result, Model m) {
        if (result.hasErrors()) {

            System.out.println("we have problem with valid");
            m.addAttribute("articleDTO", new ArticleDTO());
            return "addNews";
        }

        articleRepository.save(article);
        List<Article> articles = articleRepository.findAll();
        m.addAttribute("listArticle", articles);
        return "newsList";
    }

    @GetMapping(value = "/showArticle/{id}/{action}")
    public String showArticle(@PathVariable String id, @PathVariable String action, Model model) {
        ArticleDTO articleDTO = converter.convertEntity(articleRepository.findByArticleId(Integer.parseInt(id)));

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

        articleRepository.save(article);
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("listArticle", articles);

        return "redirect:/";
    }

    @PostMapping(value = "/deleteNews")
    public String deleteNews(@ModelAttribute("articleDTO") ArticleDTO articleDTO) {
        System.out.println("TEST delete: " + articleDTO.getIdDel().length);

        for (String id : articleDTO.getIdDel()) {
            System.out.println("test id: " + id);
            articleRepository.deleteByArticleId(Integer.parseInt(id));
        }
        return "redirect:/";
    }
}
