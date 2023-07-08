package br.com.busolli.lorenzo.patterns1.loja.pedido;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;
import br.com.busolli.lorenzo.patterns1.loja.service.ExecutarAoGerarPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class GeradorPedidoHandler {

    private List<ExecutarAoGerarPedido> acoes;

    public GeradorPedidoHandler(List<ExecutarAoGerarPedido> acoes) {
        this.acoes = acoes;
    }

    public void executar(GeradorPedido geradorPedido) {
        Orcamento orcamento = new Orcamento(geradorPedido.getValorOrcamento(), geradorPedido.getQuantidadeItens());
        Pedido pedido = new Pedido(geradorPedido.getCliente(), LocalDateTime.now(), orcamento);

        acoes.forEach(acao -> acao.executarAoGerarPedido(pedido));
    }
}
