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

import br.com.allangaiteiro.bomcredito.model.UserAuth;
import br.com.allangaiteiro.bomcredito.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserAuth>> getAll() {
        System.out.println("Get All Users");
        List<UserAuth> users = service.findAll();
        return ResponseEntity.ok().body(users);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserAuth> getById(@PathVariable("id") Integer id) {
        System.out.println("Get Curso: " + id);
        try {
            UserAuth user = service.findById(id);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/")
    public ResponseEntity<URI> create(@RequestBody UserAuth user) {
        System.out.println("Create User");
        try {
            UserAuth u = service.create(user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
            return ResponseEntity.ok().body(uri);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("{id}")
    public ResponseEntity<URI> create(@PathVariable("id") Integer id, @RequestBody UserAuth user) {
        System.out.println("Delete User");
        try {
            UserAuth ua = service.update(id, user);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ua.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> create(@PathVariable("id") Integer id) {
        System.out.println("Delete User");
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
