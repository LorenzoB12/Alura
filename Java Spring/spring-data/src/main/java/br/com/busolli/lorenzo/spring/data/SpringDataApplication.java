package br.com.busolli.lorenzo.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.busolli.lorenzo.spring.data.repository.CargoRepository;
import br.com.busolli.lorenzo.spring.data.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{

	private final CargoRepository repository;
	
	public SpringDataApplication(CargoRepository repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Integer action = 1;
		while (action != 0) {
			
			System.out.println("Cadastro desejado:");
			System.out.println(" 0 - Sair");
			System.out.println(" 1 - Cargo");
			
			Scanner scanner = new Scanner(System.in);
			action = scanner.nextInt();
			
			switch(action) {
			
			case 0:
				break;
				
			case 1:
				CrudCargoService crudCargo = new CrudCargoService(repository);
				crudCargo.inicial(scanner);
				break;
				
			default:
				System.out.println("Opcao invalida!");
				//action = scanner.nextInt();
				break;

			}
		}
	} 

}
