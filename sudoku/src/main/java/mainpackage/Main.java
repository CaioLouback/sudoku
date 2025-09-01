package mainpackage;

import com.mycompany.sudoku.Jogo;
import com.mycompany.sudoku.Tela;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Tela exibir = new Tela();
        exibir.menuBoasVindas();
        
        Jogo game = new Jogo();
        game.escolheTipoDeJogo(); 
    }
}
