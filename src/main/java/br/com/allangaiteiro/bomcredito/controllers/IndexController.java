package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@RequestMapping
@Controller
public class IndexController {
    @Autowired
    private OpportunityService service;

    @GetMapping("/")
    public String index(Model model) {
        List<Opportunity> opportunities = service.findAll();
        System.out.println(opportunities);
        model.addAttribute("opportunities", opportunities);
     return "index";   
    }
}
