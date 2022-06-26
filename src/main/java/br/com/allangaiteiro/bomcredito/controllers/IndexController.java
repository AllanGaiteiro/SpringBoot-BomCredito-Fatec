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
    @GetMapping("/")
    public String index() {
     return "redirect:/opportunities/list";   
    }
}
