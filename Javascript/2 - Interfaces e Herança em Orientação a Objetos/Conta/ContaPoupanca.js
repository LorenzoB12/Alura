import {Conta} from "./Conta.js";

export class ContaPoupanca extends Conta{
    static NumCP = 0;
    
    constructor(agencia, cliente, saldoInicial){
        super(agencia, cliente, saldoInicial)
        ContaPoupanca.NumCP += 1;
    }

    transferir(valorDepositoSemTaxa, conta){
        let taxa = 1.005
        let valorSacarComTaxa = (valorDepositoSemTaxa * taxa);
        this.saqueTransf(valorSacarComTaxa);
        conta.depositar(valorDepositoSemTaxa);
    }

    sacar(valor){
        let taxa = 1.01
        return this._sacar(valor, taxa);
    }

}