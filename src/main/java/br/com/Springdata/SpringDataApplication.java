package br.com.Springdata;

import br.com.Springdata.service.CrudCargoService;
import br.com.Springdata.service.RelatorioCargosDinamico;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {


	private final CrudCargoService CargoService;
	private final RelatorioCargosDinamico relatorioCargosDinamico;
	private Boolean system = true;

	public SpringDataApplication(CrudCargoService CargoService, RelatorioCargosDinamico relatorioCargosDinamico) {
		this.CargoService = CargoService;
		this.relatorioCargosDinamico = relatorioCargosDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);

		System.out.println("hello world");
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner Scn = new Scanner(System.in);
		while (system) {
			System.out.println("qual açao voce quer executar");
			System.out.println(" 0 - sair");
			System.out.println(" 1 - cargo");
			System.out.println(" 2 - Relatorio dinamico");


			int action = Scn.nextInt();

			switch (action) {
				case 1:
					CargoService.commence(Scn);
					break;
				case 2:
					relatorioCargosDinamico.commence(Scn);
					break;
				default:
					system = false;
					break;

			}
		}
	}
}

