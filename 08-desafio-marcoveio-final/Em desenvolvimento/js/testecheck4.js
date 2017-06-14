var selecao4 = document.querySelector('.paypal4');
selecao4.onclick = function(){
    var atual4 = selecao4.getAttribute("src");
    if(atual4 == "imagens/check_before1.png"){
        atual4 = selecao4.setAttribute("src","imagens/check_after4.png");
    }else{
        atual4 = selecao4.setAttribute("src","imagens/check_before4.png");
        }
    return false
};