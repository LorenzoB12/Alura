import {Cliente} from "./Cliente.js";

export class ContaCorrente {
    static NumCC = 0;
    agencia;
    _cliente;
    _saldo = 0;



    set cliente(valCliente){
        if (valCliente instanceof Cliente){
            this._cliente = valCliente;
        }
    }

    get cliente(){
        return this._cliente;
    }

    get saldo(){
        return this._saldo;
    }


  
    constructor(agencia, cliente){
        this.agencia = agencia;
        this.cliente = cliente;
        ContaCorrente.NumCC += 1;
    }



    sacar(valor){
        if (valor <= this._saldo){
            this._saldo -= valor;
            return valor;
        }
    }

    depositar(valor){
        if (valor <= 0) return
        this._saldo += valor;
    }

    transferir(valor, conta){
        this.sacar(valor);
        conta.depositar(valor)
        conta.cidade = "São Paulo"
    }
}