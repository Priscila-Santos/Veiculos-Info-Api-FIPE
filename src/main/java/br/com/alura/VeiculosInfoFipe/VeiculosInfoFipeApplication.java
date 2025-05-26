package br.com.alura.VeiculosInfoFipe;

import br.com.alura.VeiculosInfoFipe.main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeiculosInfoFipeApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.exibirMenu();
	}

	public static void main(String[] args) {
		SpringApplication.run(VeiculosInfoFipeApplication.class, args);
	}

}
