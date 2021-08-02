package br.univille.felipedacs2021.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("home/produto");
    }
    
}