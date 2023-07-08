package br.com.busolli.lorenzo.patterns1.loja.service;

import br.com.busolli.lorenzo.patterns1.loja.pedido.Pedido;

public class EmailSenderService implements ExecutarAoGerarPedido{
    @Override
    public void executarAoGerarPedido(Pedido pedido) {
        System.out.println("Email enviado!!!");
    }
}
