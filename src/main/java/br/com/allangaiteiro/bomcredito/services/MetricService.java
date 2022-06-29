package br.com.allangaiteiro.bomcredito.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.allangaiteiro.bomcredito.repositories.CustomerRepository;
import br.com.allangaiteiro.bomcredito.repositories.InstitutionRepository;
import br.com.allangaiteiro.bomcredito.repositories.OpportunityRepository;

public class MetricService {
    @Autowired
    private CustomerRepository coRepository;
    @Autowired
    private InstitutionRepository instRepository;
    @Autowired
    private OpportunityRepository oppRepository;

        //////// Metrics
        public long sizeCustomer() {
            return coRepository.countAll();
        }

        public long sizeInstitution() {
            return instRepository.countAll();
        }

        public long sizeOpportunity() {
            return oppRepository.countAll();
        }
    

}
