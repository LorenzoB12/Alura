import {Cliente} from "./Cliente.js"
import {ContaCorrente} from "./ContaCorrente.js"


const cliente1 = new Cliente("Ricardo", 11122233309);
const cliente1CC = new ContaCorrente(1001, cliente1);

//----------------------------------------//

const cliente2 = new Cliente("Alice", 88822233309);
const cliente2CC = new ContaCorrente(1001, cliente2);

//----------------------------------------//

let valorSacado = 0;
cliente2CC.depositar(300);
valorSacado = cliente2CC.sacar(90);
console.log(`${cliente2.nome} sacou R$${valorSacado} `)
valorSacado = cliente2CC.sacar(30);
console.log(`${cliente2.nome} sacou R$${valorSacado} `)
cliente2CC.depositar(-50);

//----------------------------------------//

cliente2CC.transferir(100, cliente1CC);
cliente1CC.transferir(10, cliente2CC)

//----------------------------------------//

console.log(cliente1CC);
console.log(cliente2CC);
console.log(`Números de Contas Correntes: ${ContaCorrente.NumCC}`)