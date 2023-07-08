var filtro = document.querySelector("#filtrar-tabela");
filtro.addEventListener("input", function() {filtraPacientes(filtro)});

/*FUNÇÕES*/

function filtraPacientes(filtro) {
    var filtroValue = filtro.value.toUpperCase();
    var pacientes = document.querySelectorAll(".info-nome");
    var nomesPacientes = [];
    var regex = new RegExp(filtroValue, 'i');
    console.log(nomesPacientes);
    pacientes.forEach(paciente => {
        nomesPacientes.push(paciente.textContent.toUpperCase());

        nomesPacientes.forEach(nomePaciente =>{
            if (regex.test(nomePaciente)){
                paciente.parentNode.hidden = false;
            } else{
                paciente.parentNode.hidden = true;
            }  
        })

    })
    
}