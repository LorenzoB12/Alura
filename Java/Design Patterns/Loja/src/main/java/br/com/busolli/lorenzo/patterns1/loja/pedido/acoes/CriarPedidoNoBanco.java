package br.com.busolli.lorenzo.patterns1.loja.pedido.acoes;

import br.com.busolli.lorenzo.patterns1.loja.pedido.Pedido;

public class CriarPedidoNoBanco implements AcaoAposGerarPedido {

	public void executarAcao(Pedido pedido) {
		System.out.println("Salvando pedido no banco de dados...");
	}

}
