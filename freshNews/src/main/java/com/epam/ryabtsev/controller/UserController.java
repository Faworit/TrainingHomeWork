package com.epam.ryabtsev.controller;

import com.epam.ryabtsev.DTO.UserDTO;
import com.epam.ryabtsev.entity.Role;
import com.epam.ryabtsev.entity.User;
import com.epam.ryabtsev.repository.UserReposiroty;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class UserController {

    @Autowired
    UserReposiroty userReposiroty;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("UserDTO", new UserDTO());

        return "registration";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/signUp")
    public ModelAndView signUp(@ModelAttribute(value = "UserDTO") @Valid UserDTO userDTO, BindingResult bindingResult) {
        System.out.println("test registration");
        if (bindingResult.hasErrors()) {
            return new ModelAndView("registration", bindingResult.getModel());
        }

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        System.out.println("user: " + user.getUsername() + "password: " + user.getPassword());
        userReposiroty.save(user);

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());

        return modelAndView;

    }
}
