package view;

import entidades.Analisador;
import entidades.TipoLex;
import entidades.Token;
import java.util.ArrayList;

/**
 *
 * @author Rui Malemba
 */
public class index {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Analisador analiserLexico = new Analisador();
        ArrayList<TipoLex> res = analiserLexico.analex();

        if (res == null) {
            return;
        }
        System.out.println(String.format("%-50s | %-50s | %-50s |", "", "", ""));
        System.out.println(String.format("%-50s | %-50s | %-50s |", "TOKEN", "LEXEMA", "LINHA"));
        System.out.println(String.format("%-50s | %-50s | %-50s |", "", "", ""));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (TipoLex lex : res) {
            System.out.println(String.format("%-50s | %-50s | %-50s |", lex.getToken(), lex.getLexema(), lex.getLinha()));

            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

    }

}
