package br.com.busolli.lorenzo.JUnit.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Funcionario {

    private String nome;
    private BigDecimal salario;
    private LocalDate dataContratacao;
    private Desempenho desempenho;

}
