function criarPlacar(){
    var tBody = $("tbody")
    var nome = "Lorenzo"
    var numPalavras = $("#contador-palavras").text();
    /*var trNovo = `<tr>
                    <td>${nome}</td>
                    <td>${numPalavras}</td>
                    <td><a href="#"class="botao-remover"><i class="small material-icons">delete</i></a></td>
                 </tr>`*/
    var trNovo = novaLinha(nome, numPalavras);
    tBody.prepend(trNovo);

    $(".botao-remover").click(deletarLinhaPlacar)

    $(".placar").slideDown(500);
    placarSlideDown();
};

function novaLinha(nome, numPalavras){
    var trNovo = $("<tr>");
    var tdNome = $("<td>").text(nome);
    var tdNumPalavras = $("<td>").text(numPalavras);
    var tdBotaoRemover = $("<td>");
    var ancor = $("<a>").addClass("botao-remover").attr("href", "#");
    var icon = $("<i>").addClass("small").addClass("material-icons").text("delete");

    ancor.append(icon);
    tdBotaoRemover.append(ancor);

    trNovo.append(tdNome);
    trNovo.append(tdNumPalavras);
    trNovo.append(tdBotaoRemover);

    return trNovo;
};

function deletarLinhaPlacar(/*event*/){
    /*event.preventDefault();*/
    var linha = $(this).parent().parent();
    linha.fadeOut(500);
    setTimeout(function(){
        linha.remove();
    }, 500)
};

function toggleShowPlacar(){
    $(".placar").stop().slideToggle(500);
}

function placarSlideDown(){
    var posicaoPlacar = $(".placar").offset().top;
    $("html, body").animate(
    {
    scrollTop: posicaoPlacar
    }, 1000);
}