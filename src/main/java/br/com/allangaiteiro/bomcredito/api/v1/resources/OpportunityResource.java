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

import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@RestController
@RequestMapping("/api/v1/opportunities")
public class OpportunityResource {
    @Autowired
    private OpportunityService service;

    @GetMapping("/")
    public ResponseEntity<List<Opportunity>> getAll() {
        System.out.println("Get All Opportunity");
        List<Opportunity> opportunities = service.findAll();
        return ResponseEntity.ok().body(opportunities);

    }

    @GetMapping("{id}")
    public ResponseEntity<Opportunity> getById(@PathVariable("id") Integer id) {
        System.out.println("Get Opportunity: " + id);
        try {
            Opportunity opportunity = service.findById(id);
            return ResponseEntity.ok().body(opportunity);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<URI> create(@RequestBody Opportunity opportunity) {
        System.out.println("Create Opportunity");
        try {
            Opportunity op = service.create(opportunity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(op.getId()).toUri();
            return ResponseEntity.ok().body(uri);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<URI> create(@PathVariable("id") Integer id, @RequestBody Opportunity opportunity) {
        System.out.println("Delete Opportunity");
        try {
            Opportunity op = service.update(id, opportunity);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(op.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Integer id) {
        System.out.println("Delete Opportunity");
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

        //// metrics
        @GetMapping("/dash")
        public ResponseEntity<List<RequestDay>> dashboardMonth() {
            System.out.println("dash Opportunity");
            List<RequestDay> dash = service.dashboardMonth();
            return ResponseEntity.ok().body(dash);
    
        }

    //// metrics
    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        System.out.println("count All Opportunity");
        long size = service.countAll();
        return ResponseEntity.ok().body(size);

    }
}