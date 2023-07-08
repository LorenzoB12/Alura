var botao = document.querySelector('#importar-pacientes');

botao.addEventListener('click', function(event){
    event.preventDefault();
    
    var xhr = new XMLHttpRequest();
    
    xhr.open('GET', 'https://raw.githubusercontent.com/loresgarcia/Pacientes-API/master/pacientes.json');

    var mensagemErroImportacao = document.querySelector('#mensagem-erro-importacao');
    xhr.addEventListener('load', function(){
        
        if (xhr.status == 200){
            var stringPacientes = xhr.responseText;
            var pacientes = JSON.parse(stringPacientes);
            pacientes.forEach(paciente => {
                criaPaciente(paciente);
            })
            mensagemErroImportacao.hidden = true;

        } else{
            mensagemErroImportacao.hidden = false;
            console.log(xhr.responseText);
        }
        
    })

    xhr.send();
})