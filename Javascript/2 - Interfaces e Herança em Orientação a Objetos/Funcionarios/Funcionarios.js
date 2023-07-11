export class Funcionarios {

    constructor (nome, salario, cpf){
        this._nome = nome;
        this._salario = salario;
        this._cpf = cpf;
        this._bonificacao = 1;
        this._senha;
    }

    senhaAcesso(senha){
        this._senha = senha;
    }

    autenticar(senha){
        return this._senha === senha
    }
}