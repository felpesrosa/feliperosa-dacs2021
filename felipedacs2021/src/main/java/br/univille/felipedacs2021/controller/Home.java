package br.univille.felipedacs2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "EU NÃO ACREDITO felipe rosa";
    };

    @RequestMapping("/outro")
    @ResponseBody
    public String outraPagina(){
        return "EU NAO ACREDITO NA OUTRA PAGINA";
    }
}
