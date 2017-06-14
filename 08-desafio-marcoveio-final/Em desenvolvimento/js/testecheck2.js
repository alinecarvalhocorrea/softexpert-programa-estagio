var selecao2 = document.querySelector('.paypal2');
selecao2.onclick = function(){
    var a = selecao2.getAttribute("src");
    if(a == "imagens/check_before1.png"){
        a = selecao2.setAttribute("src","imagens/check_after2.png");
    }else{
        a = selecao2.setAttribute("src","imagens/check_before2.png");
        }
    return false
};