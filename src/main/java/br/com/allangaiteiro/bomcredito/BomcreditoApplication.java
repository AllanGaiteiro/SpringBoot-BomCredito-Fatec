package br.com.allangaiteiro.bomcredito;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BomcreditoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BomcreditoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//TODO: Utilizar como auxilio em testes...
	}
}
