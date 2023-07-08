package br.com.busolli.lorenzo.patterns1.loja.testes;

import br.com.busolli.lorenzo.patterns1.loja.imposto.CalculadoraImpostos;
import br.com.busolli.lorenzo.patterns1.loja.orcamento.Orcamento;
import br.com.busolli.lorenzo.patterns1.loja.imposto.ICMS;

import java.math.BigDecimal;

public class TesteCalculadoraImpostos {

    public static void main(String[] args) {

        CalculadoraImpostos calculadora = new CalculadoraImpostos();
        ICMS icms = new ICMS();
        Orcamento orcamento = new Orcamento(new BigDecimal("1000"), 1);

        System.out.println(calculadora.calcularImposto(orcamento, icms));

    }

}
