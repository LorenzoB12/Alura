package br.com.busolli.lorenzo.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.busolli.lorenzo.spring.data.modelo.Cargo;
import br.com.busolli.lorenzo.spring.data.repository.CargoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	
	public void inicial(Scanner scanner) {
		Integer action = 1;
		while(action != 0) {
			
			System.out.println("Ação desejada:");
			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Consultar");
			System.out.println("4 - Deletar");
			action = scanner.nextInt();
			
			switch(action) {
			
			case 0:
				break;
			
			case 1:
				cadastrar(scanner);
				break;
				
			case 2:
				atualizar(scanner);
				break;
				
			case 3:
				consultarTodos();
				break;
				
			case 4:
				deletar(scanner);
				break;
				
			default:
				System.out.println("Opcao invalida");
				action = scanner.nextInt();
				break;
			}
			
		}

	}
	
	private void cadastrar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		
		String descricao = "";
		if (scanner.hasNext()) {
			descricao = descricao + " " + scanner.nextLine();
		}
		descricao = descricao + " " + scanner.nextLine();
		descricao = descricao.trim();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		
		cargoRepository.save(cargo);
		System.out.println("Salvo!");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("ID");
		Integer id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = "";
		if (scanner.hasNext()) {
			descricao = descricao + " " + scanner.nextLine();
		}
		descricao = descricao + " " + scanner.nextLine();
		descricao = descricao.trim();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado!");
	}
	
	private void consultarTodos() {
		cargoRepository.findAll().forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("ID");
		Integer id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Cargo de ID " + id + " deletado com sucesso!");
	}
}
