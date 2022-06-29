package br.com.allangaiteiro.bomcredito.model;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;


public interface RequestMonth {
    public Integer getMonth();
    public Integer getTotal();
    
}
