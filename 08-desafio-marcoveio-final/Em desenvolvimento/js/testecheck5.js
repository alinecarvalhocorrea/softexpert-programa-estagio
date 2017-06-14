var selecao5 = document.querySelector('.paypal5');
selecao5.onclick = function(){
    var atual5 = selecao5.getAttribute("src");
    if(atual5 == "imagens/check_before1.png"){
        atual5 = selecao5.setAttribute("src","imagens/check_after5.png");
    }else{
        atual5 = selecao5.setAttribute("src","imagens/check_before5.png");
        }
    return false
};