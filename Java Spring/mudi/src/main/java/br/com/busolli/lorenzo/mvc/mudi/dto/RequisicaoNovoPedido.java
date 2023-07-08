package br.com.busolli.lorenzo.mvc.mudi.dto;

import br.com.busolli.lorenzo.mvc.mudi.model.Pedido;
import br.com.busolli.lorenzo.mvc.mudi.model.StatusPedido;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequisicaoNovoPedido {

	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlProduto(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
