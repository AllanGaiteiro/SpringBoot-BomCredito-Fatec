package br.com.allangaiteiro.bomcredito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexControllers {
    
    public String index() {
     return "index";   
    }
}
