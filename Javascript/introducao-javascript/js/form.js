/*-------------------*/
//EXECUÇÃO DO PROGRAMA
/*-------------------*/

var botao = document.querySelector("#adicionar-paciente");

botao.addEventListener("click", function (event) {
    event.preventDefault();
    var paciente = cadastroDadosPaciente();
    criaPaciente(paciente);
    zeraFormCadastro();
});

/*--------*/
//FUNCTIONS
/*--------*/

function cadastroDadosPaciente(){
    var nome = document.querySelector("#nome").value;
    var peso = document.querySelector('#peso').value.replace(",", ".");
    var altura = document.querySelector('#altura').value.replace(",", ".");
    var gordura = document.querySelector('#gordura').value.replace(",", ".");

    var paciente = {
        nome: nome,
        peso: peso,
        altura: altura,
        gordura: gordura,
        imc: calculaIMC(peso, altura, nome)
    };
    return paciente;
};

function calculaIMC(peso, altura){
    var imc = parseInt(peso) / (parseFloat(altura) * parseFloat(altura));
    imc = imc.toFixed(2);
    return imc;
}

function zeraFormCadastro(){
    document.querySelector("#form-adiciona").reset();
}

function criaPaciente(paciente){
    var tabelaPacientes = document.querySelector('#tabela-pacientes');
    var tr = document.createElement('tr');
    var pacienteValues = Object.values(paciente);
    var classes = ["info-nome", "info-peso", "info-altura", "info-gordura", "info-imc"];

    if(!validaDados(paciente.peso, paciente.altura, paciente.nome)){
        return;
    };

    pacienteValues.forEach(elemento => {
        var td = document.createElement('td');
        td.textContent = elemento;
        tr.appendChild(td);
    });

    var i = 0;
    classes.forEach(elemento => {
        var td = tr.querySelectorAll('td');
        td[i].classList.add(elemento);
        i++;
    });

    tr.classList.add('paciente');

    tabelaPacientes.appendChild(tr);
}