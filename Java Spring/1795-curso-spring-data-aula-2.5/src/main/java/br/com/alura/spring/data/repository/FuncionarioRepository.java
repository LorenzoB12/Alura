package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {
	
	List<Funcionario> findByNomeContaining(String nome);
	
	@Query("SELECT f "
		   + "FROM Funcionario f "
		  + "WHERE f.nome = :nome "
		    + "AND f.salario >= :salario "
		    + "AND dataContratacao = :data")
	List<Funcionario> relatorio02(String nome, Double salario, LocalDate data);
	
	
	@Query(value = "SELECT * FROM funcionarios f where f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> relatorio03(LocalDate data);
	
	@Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f", nativeQuery = true)
	List<FuncionarioProjecao> relatorio04();
}
