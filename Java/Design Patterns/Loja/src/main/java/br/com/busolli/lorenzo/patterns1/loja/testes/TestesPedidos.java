package br.com.busolli.lorenzo.patterns1.loja.testes;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.busolli.lorenzo.patterns1.loja.pedido.GeraPedido;
import br.com.busolli.lorenzo.patterns1.loja.pedido.GeraPedidoHandler;
import br.com.busolli.lorenzo.patterns1.loja.pedido.acoes.CriarPedidoNoBanco;
import br.com.busolli.lorenzo.patterns1.loja.pedido.acoes.EnviarPedidoPorEmail;

public class TestesPedidos {

	public static void main(String[] args) {
		String cliente = "Ana da Silva";
		BigDecimal valorOrcamento = new BigDecimal("745.99");
		int quantidadeItens = 3;
		
		GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
		GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
				new EnviarPedidoPorEmail(),
				new CriarPedidoNoBanco()));
		handler.executar(gerador);
	}

}
