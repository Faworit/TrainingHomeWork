package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.DTO.ArticleDTO;
import com.epam.ryabtsev.converter.Converter;
import com.epam.ryabtsev.entity.Article;
import com.epam.ryabtsev.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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
        //List<Article> articles = articleRepository.findAll();
        Pageable firstPage = PageRequest.of(0, 2);
        Page<Article> articles =  articleRepository.findAll(firstPage);

        model.addAttribute("articleDTO", new ArticleDTO());
        model.addAttribute("number", articles.getNumber());
        model.addAttribute("totalPages", articles.getTotalPages());
        model.addAttribute("totalElements", articles.getTotalElements());
        model.addAttribute("size", articles.getSize());

        model.addAttribute("listArticle", articles.getContent());
        return "newsList";
    }

    @RequestMapping("/home")
    public String home() {
        return "redirect:/";
    }

    @GetMapping("/pagination")
    public String pagination(@RequestParam int page, Model model) {
        System.out.println("TEST in pagination");
        Pageable firstPage = PageRequest.of(page, 2);
        Page<Article> articles =  articleRepository.findAll(firstPage);
        model.addAttribute("articleDTO", new ArticleDTO());
        model.addAttribute("number", articles.getNumber());
        model.addAttribute("totalPages", articles.getTotalPages());
        model.addAttribute("totalElements", articles.getTotalElements());
        model.addAttribute("size", articles.getSize());

        model.addAttribute("listArticle", articles.getContent());
        return "newsList";
    }

   // @PreAuthorize("hasAnyAuthority('ADMIN')")
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
            return new ModelAndView("addNews", bindingResult.getModel());
        }
        Article article = Converter.article.convert(articleDTO); //converter.convertArticleDTO(articleDTO);

        //articleDAO.saveArticle(article);
        articleRepository.save(article);

        List<Article> articles = articleRepository.findAll();

       // m.addAttribute("articleDTO", new ArticleDTO());
      // m.addAttribute("listArticle", articles);
        ModelAndView modelAndView = new ModelAndView("redirect: /");
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
        return "redirect:/";
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
