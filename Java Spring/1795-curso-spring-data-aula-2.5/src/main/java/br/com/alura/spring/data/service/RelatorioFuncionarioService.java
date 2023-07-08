package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioFuncionarioService {
	
	private Boolean system = true;
	private final FuncionarioRepository funcionarioRepository;
	private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	

	public RelatorioFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Encontrar pelo nome");
			System.out.println("2 - Relatorio 02");
			System.out.println("3 - Relatorio 03");
			System.out.println("4 - Visualizar Todos");
			System.out.println("5 - Relatorio 04");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				findByNome(scanner);
				break;
				
			case 2:
				relatorio02(scanner);
				break;
				
			case 3:
				relatorio03(scanner);
				break;
				
			case 4:
				visualizarTodos(scanner);
				break;
				
			case 5:
				relatorio04();
				break;
				
			default:
				system = false;
				break;
			}	
		}	
	}
	
	private void findByNome(Scanner scanner) {
		System.out.print("Nome do funcionario: ");
		String nome = scanner.next();
		funcionarioRepository.findByNomeContaining(nome).forEach(System.out::println);
	}
	
	private void relatorio02(Scanner scanner) {
		System.out.print("Nome do funcionario: ");
		String nome = scanner.next();
		
		System.out.print("Salario do funcionario: ");
		Double salario = scanner.nextDouble();
		
		System.out.print("Data contratacao: ");
		String data = scanner.next();
		LocalDate dataFormatada = LocalDate.parse(data, formatador);
		
		funcionarioRepository.relatorio02(nome, salario, dataFormatada).forEach(System.out::println);
	}
	
	private void relatorio03(Scanner scanner) {
		System.out.print("Data contratacao: ");
		String data = scanner.next();
		LocalDate dataFormatada = LocalDate.parse(data, formatador);
		
		funcionarioRepository.relatorio03(dataFormatada).forEach(System.out::println);
	}
	
	private void visualizarTodos(Scanner scanner) {
		System.out.print("Pagina que deseja visualizar: ");
		Integer pag = scanner.nextInt();
		
		Pageable pageable = PageRequest.of(pag, 1, Sort.by(Sort.Direction.ASC, "dataContratacao"));
		
		Page<Funcionario> lista = funcionarioRepository.findAll(pageable);
		
		System.out.println("TOTAL DE PAGINAS: " + lista);
		System.out.println("TOTAL DE ELEMENTOS: " + lista.getTotalElements());
		System.out.println("NUMERO DA PAGINA: " + lista.getNumber());
		lista.forEach(System.out::println);
	}
	
	private void relatorio04() {
		funcionarioRepository.relatorio04().forEach(f -> System.out.println("ID: " + f.getNome() + " - NOME: " + f.getNome() + " - SALARIO: " + f.getSalario()));
	}
}
