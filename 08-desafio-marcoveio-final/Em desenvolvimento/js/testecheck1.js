var selecao1 = document.querySelector('.paypal1');
selecao1.onclick = function(){
    var a = selecao1.getAttribute("src");
    if(a == "imagens/check_before1.png"){
        a = selecao1.setAttribute("src","imagens/check_after1.png");
    }else{
        a = selecao1.setAttribute("src","imagens/check_before1.png");
        }
    return false
};