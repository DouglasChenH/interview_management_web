package com.douglas.interview_management.controllers;

import com.douglas.interview_management.models.User;
import com.douglas.interview_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Autowired
    public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder,
                              UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }

    // Return registration form template
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index1");
        return modelAndView;
    }

    // Process form input data
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String SignUp(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String password,
                         @RequestParam String passwordConfirm, @RequestParam String emailAddress) {

        // Lookup user in database by e-mail
        User userExists = userService.findByEmailAddress(emailAddress);

        if (userExists == null) {
            User user = new User(firstName, lastName, password, passwordConfirm, emailAddress);
            userService.saveUser(user);
        }
        return "home";
    }
}
