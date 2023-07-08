var titulo = document.querySelector("h1");
titulo.textContent = "Nutricionista Aparecida";

var pacientes = document.querySelectorAll(".paciente");
pacientes.forEach((paciente) => {
    peso = paciente.querySelector(".info-peso").textContent;
    altura = paciente.querySelector(".info-altura").textContent;
    imc = peso / (altura * altura);
    nome = paciente.querySelector(".info-nome").textContent;

    if (!validaDados(peso, altura)) {
        paciente.querySelector(".info-imc").textContent = `Altura ou peso invalidos`;
        paciente.classList.add("paciente-invalido");

    } else {
        paciente.querySelector(".info-imc").textContent = imc.toFixed(2);

    };
});

function validaDados(peso, altura, nome){
    if(peso >= 700 || altura >= 2.7 || peso <= 0 || altura <= 0){
        console.log(peso, altura);
        var span = document.querySelector('#mensagem-erro');
        span.textContent = `Altura e (ou) peso de ${nome} invalido(s).`
        return false;

    } else{
        return true;

    }; 
};
