package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioService;
import br.com.alura.spring.data.service.RelatoriosDinamicosFuncionario;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	private final RelatorioFuncionarioService relatorioFuncionarioService;
	
	private final RelatoriosDinamicosFuncionario relatoriosDinamicosFuncionario;
	
	
	
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeTrabalhoService,
			RelatorioFuncionarioService relatorioFuncionarioService,
			RelatoriosDinamicosFuncionario relatoriosDinamicosFuncionario) {

		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioFuncionarioService = relatorioFuncionarioService;
		this.relatoriosDinamicosFuncionario = relatoriosDinamicosFuncionario;
	}
	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - Relatorios dos Funcionarios");
			System.out.println("5 - Relatorios Dinâmicos dos Funcionarios");
			
			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					funcionarioService.inicial(scanner);
					break;
					
				case 2:
					cargoService.inicial(scanner);
					break;
				
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
					
				case 4:
					relatorioFuncionarioService.inicial(scanner);
					break;
					
				case 5:
					relatoriosDinamicosFuncionario.inicial(scanner);
					break;
					
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
