import java.util.Scanner;
class desafio{
        public static void main(String[] args){
            
        String vetorTentativa[] = new String[5];
        String vetorSistema[] = new String[5]; 
        String vetorUsuario[] = new String[5];
        String numOficial = "";
        String numSys;
        String numUse;
        String numUser;

            for (int contador = 0;contador<5;contador++){                         //Contador para percorrer array vetorSistema
                int numeroSystem = 1 + (int) (Math.random()*9);                   //Gera numero aleatorios entre 0 e 9 
                String numSystem = Integer.toString(numeroSystem);                //Transforma o int gerado em String
                vetorSistema[contador] = numSystem;                               //Acrescenta a String no array vetorSistema
                numOficial = numOficial + vetorSistema[contador];
            }
            System.out.println("Numero gerado: ***** ");                                       
            Scanner usuario = new Scanner(System.in);                              //Inicia scanner
            for (int tentativa = 0;tentativa<=5;tentativa++){                      //Loop 5 tentativas
                System.out.print("Digite sua tentativa: " );
                int numeroUser = usuario.nextInt();                                //Usuario entra com numero(int) 
                numUser = Integer.toString(numeroUser);                            //Transforma int do usuario em String 
                System.out.println("Usuario digitou: "+numeroUser+" (tentativa "+tentativa+")");
                
                for(int stringUser = 0; stringUser<5; stringUser++){               //Percorre string e captura o caractere do numero inserido em cada posicao
                    int posicao2 = stringUser + 1;
                    numUse = numUser.substring(stringUser,posicao2);                          
                    vetorUsuario[stringUser] = numUse;                             //Acrescenta o caractere no array vetorUsuario
                }
                                              
                for (int p = 0;p<5;p++){                                           //Percorrendo posicoes dos arrays do usuario e do sistema
                    String user = vetorUsuario[p];                                 //Pega valor de determinada do array usuario
                    String system = vetorSistema[p];                               //Pega valor de determinada posicao do array sistema
                    //System.out.println("Sistema:"+ system + " Usuario: " + user); Apresentando valor de determinada posição dos arrays 
                    if(user.equals(system)){                                       //Se valor do array vetorUsuario for diferente do valor da msm posicao do array vetorSistema
                            vetorTentativa[p] = vetorSistema[p];                   //vetorTentativa[contador] vai receber *
                    }else{                                                         //Senao vetorTentativa[contador] vai receber o valor de vetorSistema[contador]
                        
                        vetorTentativa[p] = "*"; 
                    }
                }
                String tentativaU = vetorTentativa[0] + vetorTentativa[1] + vetorTentativa[2] + vetorTentativa[3] + vetorTentativa[4];
                if(numUser.equals(numOficial)){                                    //Se o número inserido é o mesmo número que o sistema gerou
                    System.out.println("Adivinhou a Senha! " + numOficial);        //Imprime a senha e finaliza class
                    return;
                }else{                 
                    System.out.println("Sistema informa: "+ tentativaU);           //Senao, informa a tentativa
                }
                if(tentativa == 5){                                                //Se a tentativa for a 5, verifica se a resposta dada é o numero que o sistema gerou
                    if(tentativaU.equals(numOficial)){
                        System.out.println("Adivinhou a Senha! " + numOficial);    //Se usuario acertou, imprime a senha e finaliza class
                        return;
                    }else{
                        System.out.println("Game Over");                           //Senao imprime Game Over e finaliza class
                        return;
                    }
                }
            }
            usuario.close();                                                       //Fim scanner
    }
}