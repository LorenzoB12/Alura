var tempoInicial = $("#tempo-digitacao").text();
var campo = $(".campo-digitacao");

$(function(){
    atualizarTamanhoFrase();
    inicializarContador();
    inicializarCronometro();
    inicializarMarcadores();
    $(".botao-remover").click(deletarLinhaPlacar)
    $("#botao-reiniciar").click(reiniciarJogo);
    $("#botao-placar").click(toggleShowPlacar);
});

function atualizarTamanhoFrase(){
    var frase = $(".frase").text();
    var numPalavras = frase.split(" ").length;
    var tamanhoFrase = $('#tamanho-frase');
    tamanhoFrase.text(numPalavras);
};

function inicializarContador(){
    campo.on("input", function(){
        var conteudo = campo.val();
    
        var qtdPalavras = conteudo.split(/\S+/).length - 1;
        $("#contador-palavras").text(qtdPalavras);
    
        var qtdCaracteres = conteudo.length;
        $("#contador-caracteres").text(qtdCaracteres);
    });
};

function inicializarCronometro(){
    var tempoRestante = $("#tempo-digitacao").text();
    campo.one("focus", function(){
        $("#botao-reiniciar").attr("disabled", true);
        var cronometroID = setInterval(function(){
            tempoRestante--;
            $("#tempo-digitacao").text(tempoRestante);
    
            if (tempoRestante < 1){
                clearInterval(cronometroID);
                finalizarJogo();
            }
            
        }, 1000)
    })
};

function inicializarMarcadores(){
    campo.on("input", function(){
        var palavraDigitada = campo.val();
        var palavraIdeal = $(".frase").text().substr(0, palavraDigitada.length);
        if(palavraDigitada === palavraIdeal){
            campo.addClass("borda-verde");
            campo.removeClass("borda-vermelha");
        } else{
            campo.addClass("borda-vermelha");
            campo.removeClass("borda-verde");
        }
    });
};

function finalizarJogo(){
    campo.attr("disabled", true);
    $("#botao-reiniciar").attr("disabled", false);
    campo.addClass("campo-desativado");
    criarPlacar();
};

function reiniciarJogo(){
    $("#contador-caracteres").text(0);
    $("#contador-palavras").text(0);
    campo.val("");
    campo.attr("disabled", false);
    campo.removeClass("campo-desativado");
    $("#tempo-digitacao").text(tempoInicial);
    inicializarCronometro();
    campo.removeClass("borda-verde");
    campo.removeClass("borda-vermelha");
};
