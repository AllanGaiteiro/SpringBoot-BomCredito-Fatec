package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.CreditRequest;
import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.model.OpportunityMetric;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.dashboard.DashboardMonth;
import br.com.allangaiteiro.bomcredito.services.CreditRequestService;
import br.com.allangaiteiro.bomcredito.services.InstitutionService;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@RequestMapping("/opportunities")
@Controller
public class OpportunityController {
    @Autowired
    private OpportunityService service;
    @Autowired
    private InstitutionService instService;
    @Autowired
    private CreditRequestService creditservice;

    @GetMapping("/list")
    public String list(Model model) {
        List<Opportunity> opportunities = service.findAll();

        long total = service.countAll();
        long day = service.countDAY();
        long beforeDay = service.countBeforeDAY();
        long month = service.countMonth();
        long beforeMonth = service.countBeforeMonth();
        OpportunityMetric oppMetric = new OpportunityMetric(total, day, beforeDay, month, beforeMonth);

        List<RequestDay> requestDays = service.dashboardMonth();
        DashboardMonth dashboardMonth = new DashboardMonth("Opportunidades cadastrados nesse mes", requestDays);

        model.addAttribute("listDays", dashboardMonth.listDays);
        model.addAttribute("listValue", dashboardMonth.listValue);
        model.addAttribute("opportunities", opportunities);
        model.addAttribute("oppMetric", oppMetric);
        return this.pathReturn("list");
    }

    @GetMapping("/{id}")
    public String create(Model model, @PathVariable("id") Integer id) {
        try {
            Opportunity opportunity = service.findById(id);
            model.addAttribute("opportunity", opportunity);
            return this.pathReturn("view");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return this.pathReturn("list");
    }

    @GetMapping("/create")
    public String create(Model model, Opportunity opportunity) {
        List<Institution> institutions = instService.findAll();
        List<CreditRequest> creditRequest = creditservice.findAll();

        model.addAttribute("institutions", institutions);
        model.addAttribute("creditRequests", creditRequest);

        System.out.println("institutions" + institutions);
        System.out.println("creditRequests" + creditRequest);
        return this.pathReturn("create");
    }

    @PostMapping("/save")
    public String save(Opportunity opportunity) {
        try {
            System.out.println("opportunity:" + opportunity);
            Opportunity opp = service.create(opportunity);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/opportunities/list";
    }

    @PostMapping("/update/{id}")
    public String save(@PathVariable("id") Integer id, Opportunity opportunity) {
        try {
            Opportunity opp = service.update(id, opportunity);
            System.out.println(id + " - " + opp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/pportunities/list";
    }

    private String pathReturn(String param) {
        return "opportunities/opportunity-" + param;
    }
}
