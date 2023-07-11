export class Cliente {

    get cpf(){
        return this._cpf;
    }

    constructor(nome, cpf){
        this.nome = nome;
        this._cpf = cpf;
        this._senha;
    }

    senhaAcesso(senha){
        this._senha = senha;
    }

    autenticar(senha){
        return this._senha === senha;
    }
}