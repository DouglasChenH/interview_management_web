package com.douglas.interview_management.controllers;

import com.douglas.interview_management.models.User;
import com.douglas.interview_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {
    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;

    @Autowired
    public LoginController(BCryptPasswordEncoder bCryptPasswordEncoder,
                              UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
    }


    // Return registration form template
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLogInPage(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String SignIn(@RequestParam String fullName, @RequestParam String password) {

        // Lookup user in database by e-mail
        User userExists = userService.findByNameAndPassword(fullName, password);

        if (userExists != null) {
            return "index";

        }
        return "erro";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
