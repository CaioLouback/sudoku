package com.mycompany.sudoku;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jogo{
    private int modoDeJogo;
    private boolean valido;
    private final Verificador examine; //*netbeans aconselhou que fosse final*
    private final Tela exibirTela; //*
    private final Tabuleiro tabSudoku; //*
    private final Scanner teclado; //*
    
    public Jogo() {
        this.teclado = new Scanner(System.in);
        this.exibirTela = new Tela();
        this.tabSudoku = new Tabuleiro();
        this.examine = new Verificador(); // Passa as dependências
    }
    
    public void escolheTipoDeJogo(){
        exibirTela.menuInicial();
        valido = false; 
        modoDeJogo = examine.ehInteiro(); //verifica se a entrada é um num inteiro
        
        while (valido == false){ //ficará no loop caso o usuário não insirir opções válidas (1 ou 2)
            if(modoDeJogo < 1 || modoDeJogo > 2){ 
                System.out.println("Por favor, escolha uma das opcoes abaixo:");
                exibirTela.menuInicial(); 
                modoDeJogo = examine.ehInteiro(); // chama o método ehInteiro() para garantir entrada numérica
            }
        
            if (modoDeJogo == 1 || modoDeJogo == 2) {
                System.out.println(" ");
                
                if(modoDeJogo == 1){
                    jogoProprio();
                } else {
                    jogoAleatorio();
                }
                valido = true;
                
            } else {
                exibirTela.msgInvalida();
            }
        }   
    }
    
    private void jogoAleatorio(){
        System.out.println("Escolha a dificuldade do seu jogo: ");
        exibirTela.menuAleatorio();
       
        int numSudoku = examine.ehInteiro(); //verifica se a entrada é um num inteiro
        valido = false; 
        while (valido == false) { 
            
            if(numSudoku < 0 || numSudoku > 20){ 
                exibirTela.msgInvalida();
                System.out.println("Por favor, escolha um numero entre o intervalo abaixo:");
                exibirTela.menuAleatorio();
                numSudoku = examine.ehInteiro();
            } 
            
            if (numSudoku >=0 && numSudoku <=20) { 
                System.out.println("O seu jogo esta sendo iniciado...  =) ");
                tabSudoku.geraTabuleiroAleatorio(numSudoku); 
                valido = true; 
            } 
        }
        jogadas(0);
    }  
    
    private void jogoProprio(){
        tabSudoku.mostraTabuleiro();
        adicionarJogada();
        jogadas(0);
    }
    
    private void jogadas(int jogada){ //Menu principal de todas as jogadas
        valido = true;
        
        while(valido == true && tabSudoku.tabuleiroCheio() == false ) {
            exibirTela.menuJogadas();
            // Tive que usar dessa maneira, pois estava tendo problemas com buffer.
            jogada = Integer.parseInt(teclado.nextLine());
            switch(jogada){
                case 1:
                    adicionarJogada();
                    break;
                case 2:
                    removerJogada();
                    break;
                case 3:
                    dica();
                    break;
                case 4:
                    valido = false;
                    exibirTela.msgFinal();
                    break;
                default:
                    exibirTela.msgInvalida();
            }
        }
    }
   
    private void adicionarJogada(){
        exibirTela.menuAdcionarJogadas();
        while (true) {
            if(tabSudoku.tabuleiroCheio() == true){ //verifica se o tabuleiro está completo
                venceu();
                break;
            }
                
            String entrada = teclado.nextLine();
            // terminar a inserção quando a entrada for "-1,-1,-1"
            if (entrada.equals("(-1,-1,-1)")) {
                System.out.println("Insercao de jogadas encerrada!");
                break;
            }

            // padrão para capturar múltiplas entradas no formato (linha,coluna,valor)
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(entrada);

            valido = false;
            while (matcher.find()) {
                valido = true;

                // extração dos valores da entrada
                int linha = Integer.parseInt(matcher.group(1));
                int coluna = Integer.parseInt(matcher.group(2));
                int valor = Integer.parseInt(matcher.group(3));

                // validação de limites
                if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9 || valor < 1 || valor > 9 || valor < 1 || valor > 9) {
                    System.out.printf("A entrada (%d,%d,%d) e invalida, pois os valores LINHA, COLUNA e VALOR devem estar entre 1 e 9.\n", linha, coluna, valor);
                    break;
                }

                // ajuste de índices
                linha--;
                coluna--;

                // verificar se a posição já está preenchida
                if (tabSudoku.matriz[linha][coluna] != 0) {
                    System.out.printf("A entrada (%d,%d,%d) não foi inserida, pois ja possui um valor atribuido.\n", linha + 1, coluna + 1, valor);
                } else {
                    // verificar se a jogada é válida segundo as regras do Sudoku
                    if (examine.verificaInsercao(tabSudoku.matriz, linha, coluna, valor)) {
                        tabSudoku.matriz[linha][coluna] = valor;
                        tabSudoku.mostraTabuleiro();
                        System.out.printf("A entrada (%d,%d,%d) foi inserida com sucesso.\n", linha + 1, coluna + 1, valor);
                    } else {
                        System.out.printf("A entrada (%d,%d,%d) nao foi inserida, pois viola as regras do Sudoku. \n", linha + 1, coluna + 1, valor);
                        System.out.printf("Esse valor %s ja esta inserido na linha ou na coluna ou na grade 3x3.", valor);
                    }
                }
            }
        if (valido == false){ 
            exibirTela.msgInvalida();
            System.out.printf("A entrada %s e invalida, pois nao segue o formato esperado (linha,coluna,valor).\n", entrada);
        }
        }
    }

    private void removerJogada(){
        exibirTela.menuRemocaoDeJogada();
        
        int remocao = 1;
        while(remocao == 1){
            String entrada = teclado.nextLine();
            
            if (entrada.equals("(-1,-1)")) {
                System.out.println("Encerrando remocao de jogadas.");
                tabSudoku.mostraTabuleiro();
                break;
            }
            
            Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
            Matcher matcher = pattern.matcher(entrada);
            
            if (matcher.find()) {
                int linha = Integer.parseInt(matcher.group(1));
                int coluna = Integer.parseInt(matcher.group(2));

                if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9) {
                    exibirTela.msgInvalida();
                    System.out.printf("A entrada (%d,%d) e invalida, pois os valores devem estar entre 1 e 9.\n", linha, coluna);
                    break;
                } 
                linha--;
                coluna--;

                if(tabSudoku.matriz[linha][coluna] == tabSudoku.matrizCopia[linha][coluna]){
                    if(tabSudoku.matriz[linha][coluna] == 0){
                        exibirTela.msgInvalida();
                        exibirTela.msgRemocaoInvalida();
                        exibirTela.msgValorNulo();
                    }else {
                        tabSudoku.mostraTabuleiro();
                        exibirTela.msgInvalida();
                        exibirTela.msgRemocaoInvalida();
                    }
                } else {
                    tabSudoku.matriz[linha][coluna] = 0;
                    System.out.println("Remocao realizada com sucesso!");
                    tabSudoku.mostraTabuleiro();                    
                }
            } else {
                exibirTela.msgInvalida();
                System.out.printf("A entrada %s e invalida, pois nao segue o formato esperado (linha,coluna).\n", entrada);
            }   
           
            if(remocao == 1)
                exibirTela.menuRemocaoDeJogada();
        }
    }
    
    private void dica() {
        exibirTela.menuDica();
        String entrada = teclado.nextLine();
        
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = pattern.matcher(entrada);

        if (matcher.find()) {
           
            int linha = Integer.parseInt(matcher.group(1));
            int coluna = Integer.parseInt(matcher.group(2));

            if (linha < 1 || linha > 9 || coluna < 1 || coluna > 9) {
                System.out.printf("A entrada (%d,%d) e invalida. Os valores devem estar entre 1 e 9.%n", linha, coluna);
                return; 
            }

            linha--;
            coluna--;

            if (tabSudoku.matriz[linha][coluna] != 0) {
                System.out.println("Escolha uma posicao NAO PREENCHIDA para receber uma dica!");
                return;
            }

            System.out.println("Verificando possiveis valores para a posicao " + "(L" + (linha + 1) + ", C" + (coluna + 1) + ")...");

            for (int num = 1; num <= 9; num++) {
                if (examine.verificaInsercao(tabSudoku.matriz, linha, coluna, num)) {
                    System.out.println("O numero " + num + " pode ser inserido nessa posicao.");
                }
            }
        } else {
            exibirTela.msgInvalida();
            System.out.println("Entrada invalida! Use o formato (linha,coluna).");
        }
    }
    
    
    private void condicao(){
        exibirTela.msgCondicao();
    }
    
    private void venceu(){
        exibirTela.msgVencedor();
        int jogada = Integer.parseInt(teclado.nextLine());
        if(jogada == 1){
            tabSudoku.resetaMatriz();
            escolheTipoDeJogo();
        }else
            exibirTela.msgFinal();
    }
}
