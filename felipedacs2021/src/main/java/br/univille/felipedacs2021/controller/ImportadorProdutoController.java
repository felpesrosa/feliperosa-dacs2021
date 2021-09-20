package br.univille.felipedacs2021.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.net.URL;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.io.IOException;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {

    @GetMapping
    public ModelAndView index() {

        try {
            URL endereco = new URL("https://0650-186-237-248-5.ngrok.io/api/v1/produtos");
            HttpURLConnection conn = (HttpURLConnection)endereco.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);

            Scanner leitor = new Scanner(endereco.openStream());
            while (leitor.hasNext()) {
                System.out.println(leitor.nextLine());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return new ModelAndView("importproduto/index");
    }
    
}
