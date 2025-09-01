package mainpackage;

import com.mycompany.sudoku.Jogo;
import com.mycompany.sudoku.Tela;

public class Main {

    public static void main(String[] args){
        Tela exibir = new Tela();
        exibir.menuBoasVindas();
        Jogo game = new Jogo();
        game.escolheTipoDeJogo(); 
    }
}
