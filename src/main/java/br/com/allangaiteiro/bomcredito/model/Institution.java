package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

public class Institution {
    public String id;
    public String name;
    public Date createdAt;

    public Institution(String id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = new Date();
    }

    
    
}
