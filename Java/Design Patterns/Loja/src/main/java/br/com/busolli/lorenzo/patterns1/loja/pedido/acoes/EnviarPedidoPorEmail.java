package br.com.busolli.lorenzo.patterns1.loja.pedido.acoes;

import br.com.busolli.lorenzo.patterns1.loja.pedido.Pedido;

public class EnviarPedidoPorEmail implements AcaoAposGerarPedido {
	
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando email para cliente sobre pedido...");
	}

}
