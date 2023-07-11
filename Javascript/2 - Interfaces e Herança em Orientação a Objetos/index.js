import {Cliente} from "./Cliente.js";
import {Conta} from "./Conta/Conta.js";
import {ContaCorrente} from "./Conta/ContaCorrente.js";
import {ContaPoupanca} from "./Conta/ContaPoupanca.js";
import {ContaSalario} from "./Conta/ContaSalario.js";
import {Diretor} from "./Funcionarios/Diretor.js";
import {Gerente} from "./Funcionarios/Gerente.js";
import {Funcionarios} from "./Funcionarios/Funcionarios.js";
import {SistemaAutenticacao} from "./SistemaAutenticacao.js";


const cliente1 = new Cliente("Ricardo", 11122233309);
const cliente1CC = new ContaCorrente(1001, cliente1, 0);

//----------------------------------------//

const cliente2 = new Cliente("Alice", 88822233309);
const cliente2CC = new ContaCorrente(1001, cliente2, 0);

//----------------------------------------//

const cliente3 = new Cliente("Marcio", 55566677709);
const cliente3CP = new ContaPoupanca(1005, cliente3, 0);

//----------------------------------------//

const cliente4 = new Cliente("Lorenzo", 2166328032);
const cliente4CS = new ContaSalario(1003, cliente4, 0);

//----------------------------------------//

//const cliente1CP = new Conta(1001, cliente1, 0);

//----------------------------------------//

cliente1CC.depositar(1000); // 0 + 1000 == 1000
cliente2CC.depositar(300);
cliente1CC.transferir(200, cliente2CC);
cliente2CC.transferir(100, cliente1CC);
cliente4CS.depositar(2000);
cliente3CP.depositar(1000);
cliente3CP.sacar(100);
cliente3CP.transferir(100, cliente1CC);
cliente1CC.sacar(100);

//----------------------------------------//

const gerente1 = new Gerente("Claudio", 5000, 12345678900);
const diretor1 = new Diretor("Fabio", 10000, 12345678901);
gerente1.senhaAcesso("123");
diretor1.senhaAcesso("1234");
cliente1.senhaAcesso("12345");

console.log(SistemaAutenticacao.login(diretor1, "1234"), SistemaAutenticacao.login(gerente1, "123"), SistemaAutenticacao.login(cliente1, "12345"))

//----------------------------------------//

/*console.log(cliente1CC);
console.log(cliente2CC);
console.log(cliente3CP);
console.log(cliente4CS);
console.log(`Número de Contas Corrente: ${ContaCorrente.NumCC}`)
console.log(`Número de Contas Poupança: ${ContaPoupanca.NumCP}`)
console.log(`Número de Contas Salário: ${ContaSalario.NumCS}`)*/

//----------------------------------------//

