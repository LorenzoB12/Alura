package br.com.busolli.lorenzo.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.busolli.lorenzo.mvc.mudi.model.Pedido;
import br.com.busolli.lorenzo.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	public List<Pedido> findByStatus(StatusPedido status);
}
