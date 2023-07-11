export class SistemaAutenticacao {
    static login(pessoa, senha){
        if (SistemaAutenticacao.ehautenticavel(pessoa)){
        return (pessoa.autenticar(senha));
    }
    return false;
}

    static ehautenticavel(pessoa){
        return "autenticar" in pessoa && pessoa.autenticar instanceof Function
    }
}