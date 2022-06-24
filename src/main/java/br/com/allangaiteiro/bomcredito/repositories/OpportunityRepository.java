package br.com.allangaiteiro.bomcredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.allangaiteiro.bomcredito.model.Opportunity;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
    
}
