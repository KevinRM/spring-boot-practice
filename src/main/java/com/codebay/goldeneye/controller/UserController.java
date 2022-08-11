package com.codebay.goldeneye.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codebay.goldeneye.model.JobPosition;
import com.codebay.goldeneye.model.User;
import com.codebay.goldeneye.service.UserService;

/*
 * Controler for the "user.html" view
 */
@Controller
public class UserController {
    private UserService userService = new UserService();
    private Map<String, List<JobPosition>> jobs = new HashMap<String, List<JobPosition>>();
    
    UserController(UserService userService) {
        userService.getJobPositions().forEach(job -> {
            if (!jobs.containsKey(job.getLocation())) {
                jobs.put(job.getLocation(), new ArrayList<JobPosition>());
            }
            jobs.get(job.getLocation()).add(new JobPosition(job.getId(), job.getLocation(), job.getDepartment()));
        });
    }

    private void addAttributes(Model model) {
        model.addAttribute("jobs", jobs);

    }
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("userModel", new User());

        addAttributes(model);
        return "user";
    }

    @PostMapping("/")
	public String sendForm(@Valid @ModelAttribute("userModel") User userModel, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            model.addAttribute("noErrors", true);
            userService.createUser(userModel);
        }
        
        addAttributes(model);
        return "user";
	}
}