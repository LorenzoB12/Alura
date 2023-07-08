package br.com.busolli.lorenzo.patterns1.loja.service;

import br.com.busolli.lorenzo.patterns1.loja.pedido.Pedido;

public class SalvarPedidoDBService implements ExecutarAoGerarPedido{
    @Override
    public void executarAoGerarPedido(Pedido pedido) {
        System.out.println("Pedido salvo no BD!!!");
    }
}
