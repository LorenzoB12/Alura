import {Conta} from "./Conta.js";

export class ContaCorrente extends Conta{
    static NumCC = 0;
  
    constructor(agencia, cliente, saldoInicial){
        super(agencia, cliente, saldoInicial)
        ContaCorrente.NumCC += 1;
    }

    sacar(valor){
        let taxa = 1.001
        return this._sacar(valor, taxa)
    }

}