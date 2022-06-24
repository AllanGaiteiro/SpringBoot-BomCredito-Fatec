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

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.services.InstitutionService;

@RestController
@RequestMapping("/api/v1/institutions")
public class InstitutionResource {
    @Autowired
    private InstitutionService service;

    @GetMapping("/")
    public ResponseEntity<List<Institution>> getAll() {
        System.out.println("Get All Institutions");
        List<Institution> institutions = service.findAll();
        return ResponseEntity.ok().body(institutions);

    }

    @GetMapping("{id}")
    public ResponseEntity<Institution> getById(@PathVariable("id") Integer id) {
        System.out.println("Get Institution: " + id);
        try {
            Institution institution = service.findById(id);
            return ResponseEntity.ok().body(institution);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<URI> create(@RequestBody Institution institution) {
        System.out.println("Create Institution");
        try {
            Institution u = service.create(institution);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.ok().body(uri);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<URI> create(@PathVariable("id") Integer id, @RequestBody Institution institution) {
        System.out.println("Delete Institution");
        try {
            Institution ua = service.update(id, institution);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ua.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Integer id) {
        System.out.println("Delete Institution");
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }  
}
