package br.com.busolli.lorenzo.JUnit.model;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal getPercentual() {
            return new BigDecimal("0.20");
        }
    };

    public abstract BigDecimal getPercentual();
}
