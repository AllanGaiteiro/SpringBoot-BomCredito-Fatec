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

import br.com.allangaiteiro.bomcredito.model.CreditRequest;
import br.com.allangaiteiro.bomcredito.services.CreditRequestService;

@RestController
@RequestMapping("/api/v1/credit-request")
public class CreditRequestResource {
    @Autowired
    private CreditRequestService service;

    @GetMapping("/")
    public ResponseEntity<List<CreditRequest>> getAll() {
        System.out.println("Get All CreditRequest");
        List<CreditRequest> crediRequests = service.findAll();
        return ResponseEntity.ok().body(crediRequests);

    }

    @GetMapping("{id}")
    public ResponseEntity<CreditRequest> getById(@PathVariable("id") Integer id) {
        System.out.println("Get CreditRequest: " + id);
        try {
            CreditRequest creditRequest = service.findById(id);
            return ResponseEntity.ok().body(creditRequest);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<URI> create(@RequestBody CreditRequest creditRequest) {
        System.out.println("Create CreditRequest");
        try {
            CreditRequest cr = service.create(creditRequest);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cr.getId()).toUri();
            return ResponseEntity.ok().body(uri);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<URI> create(@PathVariable("id") Integer id, @RequestBody CreditRequest CreditRequest) {
        System.out.println("Delete CreditRequest");
        try {
            CreditRequest cr = service.update(id, CreditRequest);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cr.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Integer id) {
        System.out.println("Delete CreditRequest");
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    //// metrics
     
    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        System.out.println("count All CreditRequest");
        long size = service.countAll();
        return ResponseEntity.ok().body(size);

    }
}