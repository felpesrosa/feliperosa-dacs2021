package br.univille.felipedacs2021.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class HomeController {
    
    @GetMapping
    public ModelAndView index(){
                
        HashMap<String, String> dados = new HashMap<>();
        dados.put("nomeapp", "Aplicação Java rodando!!");
        
        return new ModelAndView("home/index", dados);
    }


    
}