function tocaSom(id){
    const elemento = document.querySelector(id);
    
    if(document.querySelector(id) === 'audio'){
        document.querySelector(id).play();
    }
    else{
        console.log('Elemento não encontrado!');
    }
}

const listaDeTeclas = document.querySelectorAll('.tecla');

for(let contador = 0; contador < listaDeTeclas.length; contador++){
    const tecla = listaDeTeclas[contador];
    const instrumento = tecla.classList[1];
    const parametro = `#som_${instrumento}`;

    tecla.onclick = function(){
        tocaSom(parametro);
    };

    tecla.onkeydown = function(event){
        if(event.code === 'Space'){
            tecla.classList.add('ativa');
        }
    }

    tecla.onkeyup = function(event){
        if(event.code === 'Space'){
            tecla.classList.remove('ativa');
        }
    }
}
