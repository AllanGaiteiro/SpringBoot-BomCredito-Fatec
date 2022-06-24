package br.com.allangaiteiro.bomcredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
