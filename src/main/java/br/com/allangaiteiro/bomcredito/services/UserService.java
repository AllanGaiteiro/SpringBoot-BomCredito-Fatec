package br.com.allangaiteiro.bomcredito.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allangaiteiro.bomcredito.model.UserAuth;
import br.com.allangaiteiro.bomcredito.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserAuth create(UserAuth user) throws Exception {
        try {
            System.out.println(user);
            UserAuth userRepo = repository.save(user);
            System.out.println("User Service Create - Succes");
            return userRepo;
        } catch (Exception e) {
            System.out.println("User Service Create - Not Found");
            throw new Exception("not-create");
        }

    }

    public UserAuth update(Integer id, UserAuth userUpdate) throws Exception {
        try {
            UserAuth userRepo = repository.findById(id).get();
            userRepo.setName(userUpdate.getName());
            UserAuth user = repository.save(userRepo);
            System.out.println("User Service Update - Succes");
            return user;
        } catch (Exception e) {
            System.out.println("User Service Update - Not Found");
            throw new Exception("not-found");
        }
    }

    public UserAuth findById(Integer id) throws Exception {
        try {
            UserAuth user = repository.findById(id).get();
            System.out.println("User Service Find By Id - Succes");
            return user;
        } catch (Exception e) {
            System.out.println("User Service  Find By Id - Not Found");
            throw new Exception("not-found");
        }
    }

    public List<UserAuth> findAll() {
        List<UserAuth> users = new ArrayList<UserAuth>();
        users = repository.findAll();
        return users;
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            System.out.println("User Service Delete - Succes");
            return;
        } catch (Exception e) {
            System.out.println("User Service Delete - Not Found");
            throw new Exception("not-delte");
        }

    }

}
