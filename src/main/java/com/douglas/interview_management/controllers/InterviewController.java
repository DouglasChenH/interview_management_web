package com.douglas.interview_management.controllers;

import com.douglas.interview_management.models.Interview;
import com.douglas.interview_management.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class InterviewController {

    @Autowired
    InterviewRepository interviewRepository;


    @RequestMapping("/interview")
    public String product(Model model) {
        model.addAttribute("interviews", interviewRepository.findAll());
        return "interview";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        return "add";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String positionName, @RequestParam String positionDesc,
          @RequestParam String companyName, @RequestParam Date interviewTime, @RequestParam String interviewLocation) {
        Interview interview = new Interview();
        interview.setPositionName(positionName);
        interview.setPositionDesc(positionDesc);
        interview.setCompanyName(companyName);
        interview.setInterviewTime(interviewTime);
        interview.setInterviewLocation(interviewLocation);
        interviewRepository.save(interview);

        return "redirect:/show/" + interview.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("product", interviewRepository.findOne(id));
        return "show";
    }

}
