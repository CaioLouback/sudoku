package com.mycompany.sudoku;

import java.util.Random;

public class Tabuleiro {
    private final int linha;
    private final int coluna;
    protected int[][] matriz;
    protected int[][] matrizCopia;
    private final Verificador examine;  //*netbeans aconselhou que fosse final*
    
    public Tabuleiro() {
        linha = 9;
        coluna = 9;
        this.matriz = new int[linha][coluna];
        this.matrizCopia = new int[linha][coluna];
        examine = new Verificador();
    }
    
    private int numeroAleatorio(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(9)+1;
    }
    
    private void insereValoresNaMatriz(int matriz [][],int matrizCopia [][], int posLin, int posCol, int valor){
        matriz[posLin][posCol] = valor;
        matrizCopia[posLin][posCol] = valor;
    }
    
    protected void geraTabuleiroAleatorio(int numSorteados){
        int contador = 0;
        while(contador != numSorteados){
            int numero = numeroAleatorio();
            int posLin = numeroAleatorio() - 1;
            int posCol = numeroAleatorio() - 1;
            
            if (numero != 0 && examine.verificaInsercao(matriz, posLin, posCol, numero) != false) { //verifica as condicoes de insercao de um valor
                insereValoresNaMatriz(matriz,matrizCopia, posLin, posCol, numero);
                contador++;
            }
        }
        mostraTabuleiro();
    }
  
    protected boolean tabuleiroCheio(){
        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                if(matriz[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
    
    protected void resetaMatriz(){
        for(int i = 0; i < linha; i++){
            for(int j = 0; j < coluna; j++){
                matriz[i][j] = 0;
                matrizCopia[i][j] = 0;
            }
        }
    }  
    
    public void mostraTabuleiro(){
        System.out.print("  ");
        for(int i = 0; i < 9; i++)
            System.out.print(" C" + (i+1));
        System.out.println();
        
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) 
                System.out.println("   ------------------------");
            
            System.out.print("L" + (i+1)+ " ");
            for (int j = 0; j < 9; j++) {
                
                if (j % 3 == 0) 
                    System.out.print(" | ");

                if (matriz[i][j] == 0) 
                    System.out.print("* ");
                else{
                    
                    System.out.print(matriz[i][j] + " ");
                }     
            }
            System.out.println("|");
        }
        System.out.println(" -------------------------"); 
    }
}
