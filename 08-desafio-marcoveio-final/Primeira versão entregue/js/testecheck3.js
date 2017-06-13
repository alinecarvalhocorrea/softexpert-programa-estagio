var selecao3 = document.querySelector('.paypal3');
selecao3.onclick = function(){
    var atual3 = selecao3.getAttribute("src");
    if(atual3 == "imagens/check_before1.png"){
        atual3 = selecao3.setAttribute("src","imagens/check_after3.png");
    }else{
        atual3 = selecao3.setAttribute("src","imagens/check_before3.png");
        }
    return false
};