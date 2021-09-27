package br.univille.felipedacs2021.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import br.univille.felipedacs2021.model.Fornecedor;
import br.univille.felipedacs2021.service.FornecedorService;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {
    
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ModelAndView index(@ModelAttribute Fornecedor fornecedor){

        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        return new ModelAndView("/importproduto/index", "listafornecedor", listaFornecedor);
    }

    @PostMapping(params="form")
    public ModelAndView busca(Fornecedor fornecedor){
        System.out.println(fornecedor.getId());
        return new ModelAndView("/import-produto/index");
    }
}