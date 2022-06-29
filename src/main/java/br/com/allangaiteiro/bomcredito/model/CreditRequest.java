package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CreditRequest{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @JoinColumn(name = "created_at")
    private Date createdAt;

    private String guarantee;

    @JoinColumn(name = "credit_value")
    private Integer creditValue;

    public CreditRequest() {
    }

    public CreditRequest(String guarantee, Customer customer,
            Integer creditValue) {
        //super(value, value, guarantee);
        this.guarantee = guarantee;
        this.customer = customer;
        this.creditValue = creditValue;
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
        return creditValue;
    }

    public void setValue(Integer creditValue) {
        this.creditValue = creditValue;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CreditRequest [createdAt=" + createdAt + ", customer=" + customer + ", id=" + id + ", creditValue=" + creditValue
                + "]";
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public Integer getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(Integer creditValue) {
        this.creditValue = creditValue;
    }

}
