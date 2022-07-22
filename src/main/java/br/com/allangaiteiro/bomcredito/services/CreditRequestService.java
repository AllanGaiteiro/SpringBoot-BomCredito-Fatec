package br.com.allangaiteiro.bomcredito.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.allangaiteiro.bomcredito.model.CreditRequest;
import br.com.allangaiteiro.bomcredito.model.RequestDay;
import br.com.allangaiteiro.bomcredito.model.RequestMonth;
import br.com.allangaiteiro.bomcredito.repositories.CreditRequestRepository;

@Service
public class CreditRequestService {
    @Autowired
    private CreditRequestRepository repository;

    public CreditRequest create(CreditRequest creditRequest) throws Exception {
        try {
            // create Credit request
            creditRequest.setCreatedAt(new Date());
            CreditRequest creditRequestRepo = repository.save(creditRequest);
            System.out.println("CreditRequest Service Create - Succes" + creditRequestRepo.toString());
            return creditRequest;
        } catch (Exception e) {
            System.out.println("CreditRequest Service Create - Not Found");
            throw new Exception("not-create");
        }

    }

    public CreditRequest update(Integer id, CreditRequest creditRequestUpdate) throws Exception {
        try {
            CreditRequest creditRequestRepo = repository.findById(id).get();
            creditRequestRepo.setCustomer(creditRequestUpdate.getCustomer());
            CreditRequest creditRequest = repository.save(creditRequestRepo);
            System.out.println("CreditRequest Service Update - Succes");
            return creditRequest;
        } catch (Exception e) {
            System.out.println("CreditRequest Service Update - Not Found");
            throw new Exception("not-found");
        }
    }

    public CreditRequest findById(Integer id) throws Exception {
        try {
            CreditRequest creditRequest = repository.findById(id).get();
            System.out.println("CreditRequest Service Find By Id - Succes");
            return creditRequest;
        } catch (Exception e) {
            System.out.println("CreditRequest Service  Find By Id - Not Found");
            throw new Exception("not-found");
        }
    }

    public List<CreditRequest> findAll() {
        List<CreditRequest> creditRequestList = new ArrayList<CreditRequest>();
        creditRequestList = repository.findAll();
        return creditRequestList;
    }

    public void delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            System.out.println("CreditRequest Service Delete - Succes");
            return;
        } catch (Exception e) {
            System.out.println("CreditRequest Service Delete - Not Found");
            throw new Exception("not-delte");
        }

    }
    
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
