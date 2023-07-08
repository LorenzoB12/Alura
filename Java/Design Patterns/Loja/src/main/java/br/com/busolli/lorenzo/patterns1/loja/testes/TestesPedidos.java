package br.com.busolli.lorenzo.patterns1.loja.testes;

import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;
import br.com.busolli.lorenzo.patterns1.loja.pedido.GeradorPedido;
import br.com.busolli.lorenzo.patterns1.loja.pedido.GeradorPedidoHandler;
import br.com.busolli.lorenzo.patterns1.loja.pedido.Pedido;
import br.com.busolli.lorenzo.patterns1.loja.service.EmailSenderService;
import br.com.busolli.lorenzo.patterns1.loja.service.ExecutarAoGerarPedido;
import br.com.busolli.lorenzo.patterns1.loja.service.SalvarPedidoDBService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestesPedidos {
    public static void main(String[] args) {
        String cliente = "Ana da Silva";
        BigDecimal valorOrcamento = new BigDecimal("745.99");
        int quantidadeItens = 3;

        List<ExecutarAoGerarPedido> acoes = Arrays.asList(new SalvarPedidoDBService(), new EmailSenderService());

        GeradorPedido gerador = new GeradorPedido(cliente, valorOrcamento, quantidadeItens);
        GeradorPedidoHandler handler = new GeradorPedidoHandler(acoes);
        handler.executar(gerador);
    }
}
