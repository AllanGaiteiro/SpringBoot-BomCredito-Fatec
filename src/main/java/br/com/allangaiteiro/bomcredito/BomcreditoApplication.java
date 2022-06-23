package br.com.allangaiteiro.bomcredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.allangaiteiro.bomcredito.model.Institution;
import br.com.allangaiteiro.bomcredito.model.User;
import br.com.allangaiteiro.bomcredito.services.OpportunityService;

@SpringBootApplication
public class BomcreditoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BomcreditoApplication.class, args);
	}

}
