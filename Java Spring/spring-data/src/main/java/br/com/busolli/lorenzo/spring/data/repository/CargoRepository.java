package br.com.busolli.lorenzo.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.busolli.lorenzo.spring.data.modelo.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer>{

}
