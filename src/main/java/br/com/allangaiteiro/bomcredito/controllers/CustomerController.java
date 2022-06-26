package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Customer;
import br.com.allangaiteiro.bomcredito.model.CustomerMetric;
import br.com.allangaiteiro.bomcredito.services.CustomerService;

@RequestMapping("/customers")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customers = service.findAll();
                
        long total = service.countAll();
        long day = service.countDAY();
        long beforeDay = service.countBeforeDAY();
        long month = service.countMonth();
        long beforeMonth = service.countBeforeMonth();
        CustomerMetric coMetric = new CustomerMetric(total, day, beforeDay, month, beforeMonth);

        model.addAttribute("coMetric", coMetric);
        model.addAttribute("customers", customers);
        return this.pathReturn("list");
    }

    @GetMapping("/{id}")
    public String create(Model model,@PathVariable("id") Integer id) {
        try {
        Customer customer = service.findById(id);
        model.addAttribute("customer", customer);
        return this.pathReturn("view");           
        } catch (Exception e) {
            //TODO: handle exception
        }
        return this.pathReturn("list");            
    }

    @GetMapping("/create")
    public String create(Customer customer) {
        return this.pathReturn("create");
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        try {
            Customer opp = service.create(customer);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/customers/list";
    }
    @PostMapping("/update/{id}")
    public String save(@PathVariable("id") Integer id,Customer customer) {
        try {
            Customer opp = service.update(id,customer);
            System.out.println(id + " - " + opp);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "redirect:/customers/list";
    }

    private String pathReturn(String param) {
        return "customers/customer-" + param;
    }
}
