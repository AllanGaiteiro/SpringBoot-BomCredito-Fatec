package br.com.allangaiteiro.bomcredito.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allangaiteiro.bomcredito.model.Customer;
import br.com.allangaiteiro.bomcredito.repositories.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer create(Customer customer) throws Exception {
        try {
            Customer customerRepo = repository.save(customer);
            System.out.println("Customer Service Create - Succes");
            return customerRepo;
        } catch (Exception e) {
            System.out.println("Customer Service Create - Not Found");
            throw new Exception("not-create");
        }

    }

    public Customer update(Integer id, Customer customerUpdate) throws Exception {
        try {
            Customer customerRepo = repository.findById(id).get();
            customerRepo.setName(customerUpdate.getName());
            customerRepo.setCpf(customerUpdate.getCpf());
            Customer customer = repository.save(customerRepo);
            System.out.println("Customer Service Update - Succes");
            return customer;
        } catch (Exception e) {
            System.out.println("Customer Service Update - Not Found");
            throw new Exception("not-found");
        }
    }

    public Customer findById(Integer id) throws Exception {
        try {
            Customer customer = repository.findById(id).get();
            System.out.println("Customer Service Find By Id - Succes");
            return customer;
        } catch (Exception e) {
            System.out.println("Customer Service  Find By Id - Not Found");
            throw new Exception("not-found");
        }
    }

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<Customer>();
        customers = repository.findAll();
        return customers;
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            System.out.println("Customer Service Delete - Succes");
            return;
        } catch (Exception e) {
            System.out.println("Customer Service Delete - Not Found");
            throw new Exception("not-delete");
        }

    }

        //////// Metrics
        public long countAll() {
            return repository.countAll();
        }
    
        public long countMonth() {
            return repository.countMonth();
        }
    
        public long countBeforeMonth() {
            return repository.countBeforeMonth();
        }
    
        public long countDAY() {
            return repository.countDAY();
        }
    
        public long countBeforeDAY() {
            return repository.countBeforeDAY();
        }

}
