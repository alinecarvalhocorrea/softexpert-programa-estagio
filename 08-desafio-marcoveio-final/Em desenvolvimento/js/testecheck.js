
var selecao = document.querySelector('.paypal');

selecao.onclick = function(){
    var atual = selecao.getAttribute("src");
    if(atual == "imagens/check_before.png"){
        atual = selecao.setAttribute("src","imagens/check_after.png");
    }else{
        atual = selecao.setAttribute("src","imagens/check_before.png");
        }
    return false
};










