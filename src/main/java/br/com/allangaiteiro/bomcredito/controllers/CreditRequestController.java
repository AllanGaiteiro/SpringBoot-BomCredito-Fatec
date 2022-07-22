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
import br.com.allangaiteiro.bomcredito.model.Metric;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.dashboard.DashboardMonth;
import br.com.allangaiteiro.bomcredito.services.CreditRequestService;

@RequestMapping("/credit-requests")
@Controller
public class CreditRequestController {
    @Autowired
    private CreditRequestService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<CreditRequest> creditRequests = service.findAll();

        long total = service.countAll();
        long day = service.countDAY();
        long beforeDay = service.countBeforeDAY();
        long month = service.countMonth();
        long beforeMonth = service.countBeforeMonth();
        Metric oppMetric = new Metric(total, day, beforeDay, month, beforeMonth);

        List<RequestDay> requestDays = service.dashboardMonth();
        DashboardMonth dashboardMonth = new DashboardMonth("Opportunidades cadastrados nesse mes", requestDays);

        model.addAttribute("listDays", dashboardMonth.listDays);
        model.addAttribute("listValue", dashboardMonth.listValue);
        model.addAttribute("creditRequests", creditRequests);
        model.addAttribute("oppMetric", oppMetric);
        return this.pathReturn("list");
    }

    @GetMapping("/{id}")
    public String create(Model model, @PathVariable("id") Integer id) {
        try {
            CreditRequest creditRequest = service.findById(id);
            model.addAttribute("creditRequest", creditRequest);
            return this.pathReturn("view");
        } catch (Exception e) {
            // TODO: handle exception
        }
        return this.pathReturn("list");
    }

    @GetMapping("/create")
    public String create(Model model, CreditRequest creditRequest) {
        return this.pathReturn("create");
    }

    @PostMapping("/save")
    public String save(CreditRequest creditRequest) {
        try {
            System.out.println("creditRequest:" + creditRequest);
            CreditRequest credit = service.create(creditRequest);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/credit-requests/list";
    }

    @PostMapping("/update/{id}")
    public String save(@PathVariable("id") Integer id, CreditRequest creditRequest) {
        try {
            CreditRequest credit = service.update(id, creditRequest);
            System.out.println(id + " - " + credit);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/credit-requests/list";
    }

    private String pathReturn(String param) {
        return "credit-requests/credit-request-" + param;
    }
}
