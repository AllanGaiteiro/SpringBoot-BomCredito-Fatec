package br.com.allangaiteiro.bomcredito.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.allangaiteiro.bomcredito.model.Customer;
import br.com.allangaiteiro.bomcredito.services.CustomerService;

@RequestMapping("/customers")
@Controller
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public String list(Model model) {
        List<Customer> customers = service.findAll();
        model.addAttribute("customers", customers);
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
        return "redirect:/" + this.pathReturn("save");
    }

    private String pathReturn(String param) {
        return "customers/customer-" + param;
    }
}
