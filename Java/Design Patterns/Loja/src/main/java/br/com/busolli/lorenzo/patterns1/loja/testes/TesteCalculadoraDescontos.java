package br.com.busolli.lorenzo.patterns1.loja.testes;

import br.com.busolli.lorenzo.patterns1.loja.desconto.*;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteCalculadoraDescontos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("1000"), 6);

        CalculadoraDescontos calculadora = new CalculadoraDescontos();

        //Cadeia de descontos
        Desconto desconto2 = new DescontoZero(null); //ÚLTIMO
        Desconto desconto1 = new DescontoItens(desconto2);
        Desconto desconto = new DescontoValor(desconto1); //PRIMEIRO

        BigDecimal retorno = calculadora.calcular(orcamento, desconto);

        System.out.println(retorno);
    }

}
