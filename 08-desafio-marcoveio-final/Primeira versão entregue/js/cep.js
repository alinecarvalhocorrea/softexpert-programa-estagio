function pcep(){
            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#cep").val("");
            }
            
            //Quando o campo cep perde o foco.

                //Nova variável "cep" somente com dígitos.
                var cep = $("#cep").val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#resultadoCEP").val("...");
                        
                        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {
                            
                        //verifica se os dados foram puxados
                        console.log(dados);
                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#resultadoCEP").val("Para chegar ao CEP "+cep+", pegue um avião ao estado de "+dados.uf+", um ônibus para a cidade de "+dados.localidade+" e encontre de carro no bairro "+dados.bairro+" a rua "+dados.logradouro+".");
                                console.log($("#resultadoCEP").val());
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                $("#resultadoCEP").val("CEP não encontrado.");
                                setTimeout(function(){$("#resultadoCEP").val("");}, 3000);
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        $("#resultadoCEP").val("Número de CEP inválido. Por favor verifique o CEP informado.");
                        setTimeout(function(){$("#resultadoCEP").val("");}, 3000);
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            
};