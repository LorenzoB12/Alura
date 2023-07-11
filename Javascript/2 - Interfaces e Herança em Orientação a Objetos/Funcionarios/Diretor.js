import {Funcionarios} from "./Funcionarios.js";

export class Diretor extends Funcionarios{
    constructor(nome, salario, cpf){
        super(nome, salario, cpf);
        let _bonificacao = 1.2;
    }
}