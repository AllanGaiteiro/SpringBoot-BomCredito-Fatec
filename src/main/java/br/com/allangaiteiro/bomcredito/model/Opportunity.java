package br.com.allangaiteiro.bomcredito.model;

import java.util.Date;

import javax.xml.crypto.Data;

public class Opportunity {
    public String userName;
    public String institutionName;
    public Date createdAt;

    public Opportunity(String userName, String institutionName) {
        this.userName = userName;
        this.institutionName = institutionName;
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Opportunity [createdAt=" + createdAt.toString() + ", institutionName=" + institutionName + ", userName=" + userName
                + "]";
    }
     
}
