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
    @JoinColumn(name = "id_institution")
    private Institution institution;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Institution customer;

    public Opportunity() {
    }
    public Opportunity(Customer customer, Institution institution) {
        this.institution = institution;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
    public Institution getCustomer() {
        return customer;
    }
    public void setCustomer(Institution customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    @Override
    public String toString() {
        return "Opportunity [createdAt=" + createdAt + ", customer=" + customer + ", id=" + id + ", institution="
                + institution + "]";
    }

}
