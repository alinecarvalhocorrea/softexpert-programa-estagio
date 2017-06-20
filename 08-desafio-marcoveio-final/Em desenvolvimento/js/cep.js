 $('#botaoCep').on('click', function() { pcep(); });

function pcep(){
    var cep = $("#cep").val().replace(/\D/g, '');
    if (cep != "") {
        var validacep = /^[0-9]{8}$/;
            if(validacep.test(cep)) {
                $("#resultadoCEP").val("...");
                $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                    console.log(dados);
                    if (!("erro" in dados)) {
                        $("#resultadoCEP").val("Para chegar ao CEP "+cep+", pegue um avião ao estado de "+dados.uf+", um ônibus para a cidade de "+dados.localidade+" e encontre de carro no bairro "+dados.bairro+" a rua "+dados.logradouro+".");
                        console.log($("#resultadoCEP").val());
                    }else {
                        $("#resultadoCEP").val("CEP não encontrado.");
                        setTimeout(function(){$("#resultadoCEP").val("");}, 3000);
                    }
                });
            } else {
                $("#resultadoCEP").val("Número de CEP inválido. Por favor verifique o CEP informado.");
                setTimeout(function(){$("#resultadoCEP").val("");}, 3000);
            }
    } else {
        limpa_formulário_cep();
    }          
}

function limpa_formulário_cep() {
        $("#cep").val("");
}