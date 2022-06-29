package br.com.allangaiteiro.bomcredito.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.RequestMonth;
import br.com.allangaiteiro.bomcredito.repositories.InstitutionRepository;

@Service
public class InstitutionService {
    @Autowired
    private InstitutionRepository repository;

    public Institution create(Institution institution) throws Exception {
        try {
            institution.setCreatedAt(new Date());
            Institution institutionRepo = repository.save(institution);
            System.out.println("Institution Service Create - Succes");
            return institutionRepo;
        } catch (Exception e) {
            System.out.println("Institution Service Create - Not Found");
            throw new Exception("not-create");
        }

    }

    public Institution update(Integer id, Institution institutionUpdate) throws Exception {
        try {
            Institution institutionRepo = repository.findById(id).get();
            institutionRepo.name = institutionUpdate.name;
            Institution institution = repository.save(institutionRepo);
            System.out.println("Institution Service Update - Succes");
            return institution;
        } catch (Exception e) {
            System.out.println("Institution Service Update - Not Found");
            throw new Exception("not-found");
        }
    }

    public Institution findById(Integer id) throws Exception {
        try {
            Institution institution = repository.findById(id).get();
            System.out.println("Institution Service Find By Id - Succes");
            return institution;
        } catch (Exception e) {
            System.out.println("institution Service  Find By Id - Not Found");
            throw new Exception("not-found");
        }
    }

    public List<Institution> findAll() {
        List<Institution> institutions = new ArrayList<Institution>();
        institutions = repository.findAll();
        return institutions;
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            System.out.println("Institution Service Delete - Succes");
            return;
        } catch (Exception e) {
            System.out.println("Institution Service Delete - Not Found");
            throw new Exception("not-delte");
        }

    }

    //// metodos

    ///////// Dashboards
    public List<RequestDay> dashboardMonth() {
        return repository.dashboardMonth();
    }

    public List<RequestMonth> dashboardYear() {
        return repository.dashboardYear();
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
