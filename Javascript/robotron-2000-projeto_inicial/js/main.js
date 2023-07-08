const robo = document.querySelector('.robotron');
const braco = document.querySelector('#braco');
const controle = document.querySelectorAll("[data-controle]");
const estatisticas = document.querySelectorAll("[data-estatistica]");
const corRobo = document.querySelectorAll("[data-corRobo]");
const roboImg = document.querySelectorAll("[data-roboImg");
const pecas = {
    "bracos": {
        "forca": 29,
        "poder": 35,
        "energia": -21,
        "velocidade": -5
    },

    "blindagem": {
        "forca": 41,
        "poder": 20,
        "energia": 0,
        "velocidade": -20
    },
    "nucleos":{
        "forca": 0,
        "poder": 7,
        "energia": 48,
        "velocidade": -24
    },
    "pernas":{
        "forca": 27,
        "poder": 21,
        "energia": -32,
        "velocidade": 42
    },
    "foguetes":{
        "forca": 0,
        "poder": 28,
        "energia": 0,
        "velocidade": -2
    }
};

controle.forEach(controle => {
    controle.addEventListener("click", (evento) => {
        peca = evento.target.parentNode;
        manipulaDados(evento, evento.target.dataset.controle, peca);
        atualizaEstatisticas(evento.target.dataset.peca);
    })
})

function manipulaDados(evento, operador, peca){
    const controle = peca.querySelector("[data-contador]");
    if(operador === "+"){
        controle.value = parseInt(controle.value) + 1;
    } 
    if(operador === "-"){
        controle.value = parseInt(controle.value) - 1;
    }
}

function atualizaEstatisticas(peca){
    estatisticas.forEach((elemento) => {
        console.log(elemento);
        elemento.textContent = parseInt(elemento.textContent) + pecas[peca][elemento.dataset.estatistica];
    }
    );
}



