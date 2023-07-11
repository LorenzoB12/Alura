class Cliente {
    nome;
    cpf;

}

class ContaCorrente {
    agencia;
    saldo;
    sacar(valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
            return valor;
        }
    }

    depositar(valor){
        if (valor <= 0) return
        this.saldo += valor;
    }
}


const cliente1 = new Cliente();
cliente1.nome = "Ricardo";
cliente1.cpf = 11122233309;
const cliente1CC = new ContaCorrente();
cliente1CC.agencia = 1001;
cliente1CC.saldo = 0;
//console.log(cliente1, cliente1CC);

//----------------------------------------//

const cliente2 = new Cliente();
cliente2.nome = "Alice";
cliente2.cpf = 88822233309;
const cliente2CC = new ContaCorrente();
cliente2CC.agencia = 1001;
cliente2CC.saldo = 0;
//console.log(cliente2, cliente2CC);

//----------------------------------------//

cliente2CC.depositar(300);
valorSacado = cliente2CC.sacar(90);
console.log(`Você recebeu R$${valorSacado} `)
valorSacado = cliente2CC.sacar(30);
console.log(`Você recebeu R$${valorSacado} `)
cliente2CC.depositar(-50);
//console.log(cliente2CC);


