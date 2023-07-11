import {Conta} from "./Conta.js";

export class ContaSalario extends Conta{
    static NumCS = 0;
    
    constructor(agencia, cliente, saldoInicial){
        super(agencia, cliente, saldoInicial);
        ContaSalario.NumCS += 1;
    }

    sacar(valor){
        let taxa = 1
        return this._sacar(valor, taxa);
    }


}