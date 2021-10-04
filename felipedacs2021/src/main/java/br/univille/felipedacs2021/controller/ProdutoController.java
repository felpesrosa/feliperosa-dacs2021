package br.univille.felipedacs2021.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.felipedacs2021.model.Produto;
import br.univille.felipedacs2021.service.ProdutoService;

import br.univille.felipedacs2021.model.Fornecedor;
import br.univille.felipedacs2021.service.FornecedorService;

import br.univille.felipedacs2021.model.Categoria;
import br.univille.felipedacs2021.service.CategoriaService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public ModelAndView index(){

        List<Produto> listaProdutos = service.getAllProdutos();

        return new ModelAndView("produto/index","listaProdutos",listaProdutos);
    }
    
    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Produto produto){
        HashMap<String,Object> dados = new HashMap<>();

        dados.put("produto",produto);
        List<Fornecedor> listaFornecedores = fornecedorService.getAllFornecedores();
        dados.put("listaFornecedores",listaFornecedores);
        List<Categoria> listaCategorias = categoriaService.getAllCategorias();
        dados.put("listaCategorias",listaCategorias);
        return new ModelAndView("produto/form",dados);
    }


    @PostMapping(params = "form")
    public ModelAndView save(Produto produto){
        service.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping(value = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto){

        HashMap<String,Object> dados = new HashMap<>();
        dados.put("produto",produto);
        List<Fornecedor> listaFornecedores = fornecedorService.getAllFornecedores();
        dados.put("listaFornecedores",listaFornecedores);
        List<Categoria> listaCategorias = categoriaService.getAllCategorias();
        dados.put("listaCategorias",listaCategorias);

        return new ModelAndView("produto/form",dados);
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Produto produto){
        service.delete(produto);
        return new ModelAndView("redirect:/produto");
    }

}
