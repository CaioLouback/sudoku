package com.mycompany.sudoku;

public class Tela {
    
    public void menuBoasVindas(){
        System.out.println("############################################");
        System.out.println("|        SEJA BEM-VINDO AO SUDOKU!         |");
        System.out.println("|          CRIADOR: CAIO LOUBACK           |");
        System.out.println("|               VERSAO: 2.4                |");
        System.out.println("############################################");
    }
    
    public void menuInicial(){   
        System.out.println("############################################");
        System.out.println("|        Opcoes disponiveis:               |");
        System.out.println("|        1. Definir o proprio jogo.        |");
        System.out.println("|        2. Jogo aleatorio.                |");
        System.out.println("############################################");
    }
    
    public void menuAleatorio(){
        System.out.println("############################################");
        System.out.println("|  Insira a quantidade de numeros a serem   |");
        System.out.println("| sortiados para o seu tabuleiro do Sudoku. |");
        System.out.println("|      Lembrando: numeros entre 0 e 20.     |");
        System.out.println("############################################");
    }
    
    public void menuJogadas(){
        System.out.println("############################################");
        System.out.println("|        Opcoes disponiveis:               |");
        System.out.println("|        1. Adicionar jogada.              |");
        System.out.println("|        2. Remover jogada.                |");
        System.out.println("|        3. Dica.                          |");
        System.out.println("|        4. Verificar condicao do jogo.    |");
        System.out.println("|        5. Finalizar o jogo.              |");
        System.out.println("############################################");
    }
    
    public void menuAdcionarJogadas(){
        System.out.println("############################################");
        System.out.println("|  Favor realizar as entradas no seguinte  |");
        System.out.println("|       formato: (linha,coluna,valor)      |");
        System.out.println("|    Serao aceitas entradas sequenciais    |");
        System.out.println("|                                          |");
        System.out.println("|  Quando desejar finalizar a insercao,    |");
        System.out.println("|    favor inserir no final (-1, -1, -1)   |");
        System.out.println("############################################");
    }
    
    public void menuRemocaoDeJogada(){
        System.out.println("############################################");
        System.out.println("|       Digite a linha e a coluna          |");
        System.out.println("|       que voce deseja remover no         |");
        System.out.println("|       seguinte formato: (linha,coluna)   |");
        System.out.println("|       ou digite (-1,-1) para sair.       |");
        System.out.println("############################################");     
    }
    
    public void msgCondicao(){
        System.out.println("#############################################");
        System.out.println("|    Esta tudo correto com o seu jogo.      |");
        System.out.println("|                Continue...                |");
        System.out.println("#############################################");
    }
    
    public void msgRemocaoInvalida(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("|    So serao aceitas para a remocao       |");
        System.out.println("| linhas e colunas inseridas pelo jogador! |");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");   
    }
    
    public void msgValorNulo(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("|    Nao e possivel realizar a remocao     |");
        System.out.println("|            de valores nulos!             |");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");   
    }
    
    public void menuDica(){
        System.out.println("############################################");
        System.out.println("|  Digite a linha e a coluna para receber  |");
        System.out.println("|  uma dica de jogada. Lembrando, use o    |");
        System.out.println("|     seguinte formato: (linha,coluna)     |");
        System.out.println("############################################");   
    }
    
    public void msgError(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("|  Favor inserir um numero por gentileza.   |");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    
    public void msgOpcaoVazia(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("|  Favor inserir uma linha e coluna vazia   |");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    
    public void msgInvalida(){
        System.out.println(">>>>>>>>>>>>>> OPCAO INVALIDA! <<<<<<<<<<<<<<");
    }
   
    public void msgFinal(){
        System.out.println("############################################");
        System.out.println("|          Sudoku foi finalizado.          |");
        System.out.println("|   Obrigado por jogar! Ate uma proxima!   |");
        System.out.println("############################################");
    }
    
    public void msgVencedor(){
        System.out.println("############################################");
        System.out.println("|    PARABENS VOCE FINALIZOU O SUDOKU!     |");
        System.out.println("|         Deseja jogar novamente?          |");
        System.out.println("|                 1)Sim                    |");
        System.out.println("|                 2)Nao                    |");
        System.out.println("############################################");
    }
}
