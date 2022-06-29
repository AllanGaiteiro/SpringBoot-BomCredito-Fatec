package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "id_credit_request")
    private CreditRequest creditRequest;

    @ManyToOne
    @JoinColumn(name = "id_institution")
    private Institution institution;

    public Opportunity() {
    }

    public Opportunity(Institution institution, CreditRequest creditRequest) {
        this.institution = institution;
        this.creditRequest = creditRequest;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(CreditRequest creditRequest) {
        this.creditRequest = creditRequest;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Opportunity [createdAt=" + createdAt + ", creditRequest=" + creditRequest + ", id=" + id
                + ", institution=" + institution + "]";
    }

}
