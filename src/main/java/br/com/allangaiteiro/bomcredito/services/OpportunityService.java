package br.com.allangaiteiro.bomcredito.services;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.Opportunity;
import br.com.allangaiteiro.bomcredito.model.User;

public class OpportunityService {
    
    public static void create(User user,Institution institution) {
        Opportunity opportunity = new Opportunity(user.name, institution.name);

        System.out.println(opportunity.toString());
    }
}
