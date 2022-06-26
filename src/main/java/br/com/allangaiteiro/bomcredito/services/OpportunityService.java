package br.com.allangaiteiro.bomcredito.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.repositories.OpportunityRepository;

@Service
public class OpportunityService {
    @Autowired
    private OpportunityRepository repository;

    public Opportunity create(Opportunity opportunity) throws Exception {
        try {
            opportunity.setCreatedAt(new Date());
            Opportunity opportunityRepo = repository.save(opportunity);
            System.out.println("Opportunity Service Create - Succes"+opportunityRepo.toString());
            return opportunity;
        } catch (Exception e) {
            System.out.println("Opportunity Service Create - Not Found");
            throw new Exception("not-create");
        }

    }

    public Opportunity update(Integer id, Opportunity opportunityUpdate) throws Exception {
        try {
            Opportunity opportunityRepo = repository.findById(id).get();
            opportunityRepo.setInstitution(opportunityUpdate.getInstitution());
            opportunityRepo.setCustomer(opportunityUpdate.getCustomer());
            Opportunity opportunity = repository.save(opportunityRepo);
            System.out.println("Opportunity Service Update - Succes");
            return opportunity;
        } catch (Exception e) {
            System.out.println("Opportunity Service Update - Not Found");
            throw new Exception("not-found");
        }
    }

    public Opportunity findById(Integer id) throws Exception {
        try {
            Opportunity opportunity = repository.findById(id).get();
            System.out.println("Opportunity Service Find By Id - Succes");
            return opportunity;
        } catch (Exception e) {
            System.out.println("Opportunity Service  Find By Id - Not Found");
            throw new Exception("not-found");
        }
    }

    public List<Opportunity> findAll() {
        List<Opportunity> opportunities = new ArrayList<Opportunity>();
        opportunities = repository.findAll();
        return opportunities;
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            System.out.println("Opportunity Service Delete - Succes");
            return;
        } catch (Exception e) {
            System.out.println("Opportunity Service Delete - Not Found");
            throw new Exception("not-delte");
        }

    }

    //////// Metrics
    public long contAll() {
        long size =  repository.contAll();
        System.out.println(size);
        return size;
    }
    public long contForMonth() {
        long size =  repository.contMonth();
        System.out.println(size);
        return size;
    }
    public long contForDay() {
        long size =  repository.contDAY();
        System.out.println(size);
        return size;
    }
}
