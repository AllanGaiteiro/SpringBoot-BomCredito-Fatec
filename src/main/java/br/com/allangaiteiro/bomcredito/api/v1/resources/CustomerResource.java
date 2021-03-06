package br.com.allangaiteiro.bomcredito.api.v1.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.allangaiteiro.bomcredito.model.Customer;
import br.com.allangaiteiro.bomcredito.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerResource {
    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll() {
        System.out.println("Get All Customers");
        List<Customer> customers = service.findAll();
        return ResponseEntity.ok().body(customers);

    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id) {
        System.out.println("Get Customer: " + id);
        try {
            Customer customer = service.findById(id);
            return ResponseEntity.ok().body(customer);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<URI> create(@RequestBody Customer customer) {
        System.out.println("Create Customer");
        try {
            Customer co = service.create(customer);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(co.getId()).toUri();
            return ResponseEntity.ok().body(uri);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<URI> create(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        System.out.println("Delete Customer");
        try {
            Customer co = service.update(id, customer);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(co.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Integer id) {
        System.out.println("Delete customer");
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
