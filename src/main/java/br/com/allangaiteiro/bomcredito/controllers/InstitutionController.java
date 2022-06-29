package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.InstitutionMetric;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.dashboard.DashboardMonth;
import br.com.allangaiteiro.bomcredito.services.InstitutionService;

@RequestMapping("/institutions")
@Controller
public class InstitutionController {
    @Autowired
    private InstitutionService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Institution> institutions = service.findAll();

        long total = service.countAll();
        long day = service.countDAY();
        long beforeDay = service.countBeforeDAY();
        long month = service.countMonth();
        long beforeMonth = service.countBeforeMonth();
        
        InstitutionMetric instMetric = new InstitutionMetric(total, day, beforeDay, month, beforeMonth);

        List<RequestDay> requestDays = service.dashboardMonth();
        DashboardMonth dashboardMonth = new DashboardMonth("Instituições cadastrados nesse mes", requestDays);

        model.addAttribute("listDays", dashboardMonth.listDays);
        model.addAttribute("listValue", dashboardMonth.listValue);
        model.addAttribute("instMetric", instMetric);
        model.addAttribute("institutions", institutions);
        return this.pathReturn("list");
    }

    @GetMapping("/{id}")
    public String create(Model model,@PathVariable("id") Integer id) {
        try {
        Institution institution = service.findById(id);
        model.addAttribute("institution", institution);
        return this.pathReturn("view");           
        } catch (Exception e) {
            //TODO: handle exception
        }
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
        return "redirect:/institutions/list";
    }
    @PostMapping("/update/{id}")
    public String save(@PathVariable("id") Integer id,Institution institution) {
        try {
            Institution inst = service.update(id,institution);
            System.out.println(id + " - " + inst);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/Institutions/list";
    }

    private String pathReturn(String param) {
        return "institutions/institution-" + param;
    }
}
