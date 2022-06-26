package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    public String name;
    
    @JoinColumn(name = "created_at")
    private Date createdAt;

    public Institution() {
    }

    public Institution(String name,Date createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Institution [createdAt=" + createdAt + ", id=" + id + ", name=" + name + "]";
    }

}
