package com.opencouncil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.opencouncil.hibernate.example.dao.TestDAO;

@Controller
public class HelloWorldController {
    
    @Autowired
    TestDAO dao;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String doGet(Model model){
        model.addAttribute("testList", dao.readAll());
        return "/index";
    }
}
