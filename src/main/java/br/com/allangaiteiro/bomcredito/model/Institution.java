package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Institution extends Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    public String name;

    @JoinColumn(name = "created_at")
    private Date createdAt;

    public Institution() {
    }

    public Institution(float valueMin, float valueMax, String guarantee, Integer id, String name, Date createdAt) {
        super(valueMin, valueMax, guarantee);
        this.id = id;
        this.name = name;
        this.createdAt = new Date();
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
