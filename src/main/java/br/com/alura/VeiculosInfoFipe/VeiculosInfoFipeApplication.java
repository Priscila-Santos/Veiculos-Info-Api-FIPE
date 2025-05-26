package br.com.alura.VeiculosInfoFipe;

import br.com.alura.VeiculosInfoFipe.controller.VeiculoController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeiculosInfoFipeApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
//		Main main = new Main();
//		main.exibirMenu();
		VeiculoController controller = new VeiculoController();
		controller.iniciarConsulta();
	}

	public static void main(String[] args) {
		SpringApplication.run(VeiculosInfoFipeApplication.class, args);
	}

}
