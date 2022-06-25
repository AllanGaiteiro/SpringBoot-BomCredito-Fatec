package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.services.InstitutionService;

@RequestMapping("/institutions")
@Controller
public class InstitutionController {
    @Autowired
    private InstitutionService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Institution> institutions = service.findAll();
        model.addAttribute("institutions", institutions);
        return this.pathReturn("list");
    }

    @GetMapping("/create")
    public String create(Institution institution) {
        return this.pathReturn("create");
    }

    @PostMapping("/save")
    public String save(Institution institution) {
        try {
            Institution inst = service.create(institution);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/" + this.pathReturn("save");
    }

    private String pathReturn(String param) {
        return "institutions/institution-" + param;
    }
}
