package br.com.allangaiteiro.bomcredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.User;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@SpringBootApplication
public class BomcreditoApplication {

	public static void main(String[] args) {
		
		User user = new User("333-333-33","allan");
		Institution institution = new Institution("caixa","Caixa");
		OpportunityService.create(user, institution);
		//SpringApplication.run(BomcreditoApplication.class, args);
	}

}
