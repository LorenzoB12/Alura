package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatoriosDinamicosFuncionario {

	private final FuncionarioRepository funcionarioRepository;

	
	
	public RelatoriosDinamicosFuncionario(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	
	public void inicial(Scanner scanner) { 
		System.out.print("Digite um nome: ");
		String nome = scanner.next();
		if(nome == "NULL") {
			nome = null;
		}
		
		System.out.print("Digite um cpf: ");
		String cpf = scanner.next();
		if(cpf == "NULL") {
			cpf = null;
		}
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll(Specification
				.where(
						SpecificationFuncionario.nome(nome))
						.or(SpecificationFuncionario.cpf(cpf))
				);
		funcionarios.forEach(System.out::println);
	}
}
