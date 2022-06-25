package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@RequestMapping("/opportunities")
@Controller
public class OpportunityController {
    @Autowired
    private OpportunityService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Opportunity> opportunities = service.findAll();
        model.addAttribute("opportunities", opportunities);
        return this.pathReturn("list");
    }

    @GetMapping("/create")
    public String create(Opportunity opportunity) {
        return this.pathReturn("create");
    }

    @PostMapping("/save")
    public String save(Opportunity opportunity) {
        try {
            Opportunity opp = service.create(opportunity);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/opportunities/list";
    }

    private String pathReturn(String param) {
        return "opportunities/opportunity-" + param;
    }
}
