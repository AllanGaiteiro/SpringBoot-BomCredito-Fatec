package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CreditRequest extends Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @JoinColumn(name = "created_at")
    private Date createdAt;

    private Integer value;

    public CreditRequest() {
    }

    public CreditRequest(Integer id, Customer customer, Integer value) {
        this.id = id;
        this.customer = customer;
        this.value = value;
    }

    public CreditRequest(float valueMin, float valueMax, float guarantee, Integer id, Customer customer,
            Integer value) {
        super(valueMin, valueMax, guarantee);
        this.id = id;
        this.customer = customer;
        this.value = value;
        this.createdAt = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CreditRequest [createdAt=" + createdAt + ", customer=" + customer + ", id=" + id + ", value=" + value
                + "]";
    }

}
