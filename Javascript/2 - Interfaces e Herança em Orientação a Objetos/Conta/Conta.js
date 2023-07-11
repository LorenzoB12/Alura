import {Cliente} from "../Cliente.js";

//Classe abstrata
export class Conta{

    constructor(agencia, cliente, saldoinicial){
        if(this.constructor == Conta){
            throw new error("Você não pode criar uma conta diretamente na classe Conta.")
        }
        
        this._agencia = agencia;
        this._cliente = cliente;
        this._saldo = saldoinicial;
    }



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

    //Método abstrato
    sacar(valor) {
        throw new error ("Você deve sobreescrever o método sacar em sua determinada classe.")
    }

    saqueTransf(valor){
        if (this._saldo >= valor) {
            this._saldo -= valor;
            return valor;
        }
    }

    _sacar(valor, taxa){
        const valorSacado = taxa * valor;
        if (this._saldo >= valorSacado) {
            this._saldo -= valorSacado;
            return valorSacado;
        }
        else{
            return 0;
        }
    }

    depositar(valor){
        if (valor <= 0) return
        this._saldo += valor;
    }

    transferir(valor, conta){
        this.saqueTransf(valor);
        conta.depositar(valor)
    }



}