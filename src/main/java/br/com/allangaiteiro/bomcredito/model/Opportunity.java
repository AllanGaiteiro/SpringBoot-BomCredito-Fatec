package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import javax.xml.crypto.Data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String cpf;
    public String institutionId;
    public Date createdAt;

    public Opportunity(String cpf, String institutionId) {
        this.cpf = cpf;
        this.institutionId = institutionId;
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Opportunity [id=" + id + ", institutionId=" + institutionId + ", cpf=" + cpf + ", createdAt="
                + createdAt + "]";
    }

     
}
