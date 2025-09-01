package com.mycompany.sudoku;

import java.util.Scanner;

public class Verificador {
    private int num;
    private boolean valido;
    private final Scanner teclado;
    private final Tela exibir;//*netbeans aconselhou que fosse final*
    
    public Verificador() {
        teclado = new Scanner(System.in);
        exibir = new Tela();
    }
    
    //verifica se o número é um inteiro(evita caracteres e strings)
    protected int ehInteiro(){
        valido = true;
        while(valido == true){
            if(teclado.hasNextInt()){ // método de Scanner para verificar se é inteiro
                num = teclado.nextInt();
                valido = false;
            }else {
                exibir.msgInvalida();
                exibir.msgError(); 
                teclado.next();        
            }  
        }
        return num;
    }
   
    protected boolean verificaInsercao(int matriz[][], int posLin, int posCol, int valor) {
        int linhaQuad = posLin - posLin  % 3; //variavel para controlar a linha dos quadrados
        int colunaQuad = posCol - posCol  % 3;

        //verifica se o valor está na linha
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[posLin][i] == valor) {
                return false;
            }
        }
        
        //verifica se o valor está na coluna
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][posCol] == valor) {
                return false;
            }
        }
        
        //verifica se o valor está nos quadrados 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[linhaQuad + i][colunaQuad + j] == valor) {
                    return false;
                }
            }
        }
        return true;
    }
}
