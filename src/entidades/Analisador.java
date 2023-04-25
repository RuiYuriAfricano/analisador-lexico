package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Rui Malemba
 */
public class Analisador {

    private ArrayList<String> ficheiroLido;
    private String path = "programaC.txt";
    private String textoDaLinha = "";
    private int contarLinhasLidas = 0, indice = 0;
    private String textoLexema = "";
    private String lerChar = "";
    private int estado = 0;
    private int guardarLinha;

    public Analisador() {
        lerFicheiro();
    }

    // Método para ler do ficheiro de texto
    public void lerFicheiro() {
        BufferedReader reader;
        String text = "";
        ficheiroLido = new ArrayList<>();
        try {

            reader = new BufferedReader(new FileReader(path));
            text = reader.readLine();
            while (text != null) {
                ficheiroLido.add(text);
                text = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    // Método analex
    public ArrayList<TipoLex> analex() {
        ArrayList<TipoLex> result = new ArrayList<>();
        TipoLex lex = new TipoLex();
        boolean end = false;
        boolean bb = false;
        do {
            if (contarLinhasLidas < ficheiroLido.size()) {
                textoDaLinha = ficheiroLido.get(contarLinhasLidas);
            }
            switch (estado) {
                // Estado inicial
                case 0: {
                    // Só vai ler um simbolo, como se fosse "char lerChar";
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    // Variavel
                    if (Character.isLowerCase(lerChar.charAt(0)) || lerChar.charAt(0) == '_') {
                        estado = 1;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    // valor númerico
                    if (Character.isDigit(lerChar.charAt(0))) {
                        estado = 3;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    // valor textual(string)
                    if (lerChar.charAt(0) == '"') {
                        estado = 18;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    // valor carater(char)
                    if (lerChar.charAt(0) == '\'') {
                        estado = 20;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    /*
                     * Paranteses, paranteses reto, chavetas, ponto e virgula
                     * virgula, ponto, interrogação, dois pontos, asterisco
                     */
                    if (lerChar.charAt(0) == '(') {
                        estado = 47;

                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == ')') {
                        estado = 48;

                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == '[') {
                        estado = 49;

                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == ']') {
                        estado = 50;

                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == '{') {
                        estado = 51;
                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == '}') {
                        estado = 52;
                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == ';') {
                        estado = 53;

                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == ',') {
                        estado = 54;
                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == '?') {
                        estado = 55;
                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == ':') {
                        estado = 56;
                        textoLexema += lerChar;
                        indice++;

                    }
                    if (lerChar.charAt(0) == '.') {
                        estado = 57;
                        textoLexema += lerChar;
                        indice++;

                    }

                    //Operador *
                    if (lerChar.charAt(0) == '*') {
                        estado = 58;
                        textoLexema += lerChar;
                        indice++;

                    }
                    // comentário e operador /
                    if (lerChar.charAt(0) == '/') {
                        estado = 8;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    // operador aritmético
                    if (lerChar.charAt(0) == '+') {
                        estado = 27;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    if (lerChar.charAt(0) == '-') {
                        estado = 28;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    if (lerChar.charAt(0) == '%') {
                        estado = 29;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    // operador relacional e um de atribuição
                    if (lerChar.charAt(0) == '=' || lerChar.charAt(0) == '!' || lerChar.charAt(0) == '>' || lerChar.charAt(0) == '<') {
                        estado = 32;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    // operador lógico
                    if (lerChar.charAt(0) == '&') {
                        estado = 34;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    if (lerChar.charAt(0) == '|') {
                        estado = 35;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    if (lerChar.charAt(0) == '!') {
                        estado = 36;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }

                    // diretivas
                    if (lerChar.charAt(0) == '#') {
                        estado = 37;

                        if (textoDaLinha.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }

                    }
                    break;
                }
                // Estado 1
                case 1: {
                    boolean erro = false;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length(); i++) {
                        if (Character.isLetter(lerChar.charAt(0)) || lerChar.charAt(0) == '_'
                                || Character.isDigit(lerChar.charAt(0))) {
                            textoLexema += lerChar;
                            indice++;
                        } else if (Character.isWhitespace(lerChar.charAt(0)) || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '-'
                                || lerChar.charAt(0) == '*' || lerChar.charAt(0) == '/' || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '('
                                || lerChar.charAt(0) == '}' || lerChar.charAt(0) == ']' || lerChar.charAt(0) == '%' | lerChar.charAt(0) == '>' || lerChar.charAt(0) == '='
                                || lerChar.charAt(0) == '<' || lerChar.charAt(0) == '!' || lerChar.charAt(0) == '&' || lerChar.charAt(0) == '|' || lerChar.charAt(0) == ':'
                                || lerChar.charAt(0) == '?' || lerChar.charAt(0) == '.' || lerChar.charAt(0) == ',' || lerChar.charAt(0) == ';' || lerChar.charAt(0) == '{'
                                || lerChar.charAt(0) == '[' || lerChar.charAt(0) == ')') {
                            i = textoDaLinha.length();
                            indice++;
                        } else {
                            erro = true;
                            textoLexema += lerChar;
                        }

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }
                    if (erro) {
                        contarLinhasLidas++;
                        System.out.println("Erro na linha: " + contarLinhasLidas + " variavel inválida: " + textoLexema);
                        return null;
                    } else {
                        guardarLinha = contarLinhasLidas;
                        estado = 2;
                    }
                    break;
                }
                // Estado 2
                case 2: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_ID);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 3
                case 3: {
                    boolean aux = false, erro = false;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length(); i++) {
                        if (Character.isDigit(lerChar.charAt(0))) {
                            textoLexema += lerChar;
                            indice++;
                        } else if (lerChar.charAt(0) == '.') {
                            textoLexema += lerChar;
                            indice++;
                            i = textoDaLinha.length();
                            aux = true;// vai para o estado 4
                        } else if (Character.isWhitespace(lerChar.charAt(0)) || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '-'
                                || lerChar.charAt(0) == '*' || lerChar.charAt(0) == '/' || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '(' || lerChar.charAt(0) == ')'
                                || lerChar.charAt(0) == '}' || lerChar.charAt(0) == ']' || lerChar.charAt(0) == '%' | lerChar.charAt(0) == '>' || lerChar.charAt(0) == '='
                                || lerChar.charAt(0) == '<' || lerChar.charAt(0) == '!' || lerChar.charAt(0) == '&' || lerChar.charAt(0) == '|' || lerChar.charAt(0) == ':'
                                || lerChar.charAt(0) == '?' || lerChar.charAt(0) == ',' || lerChar.charAt(0) == ';') {

                            indice++;
                            i = textoDaLinha.length();
                        } else {
                            erro = true;
                            textoLexema += lerChar;
                        }

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }

                    guardarLinha = contarLinhasLidas;
                    if (aux) {
                        estado = 4;

                    } else {
                        estado = 7;
                        if (erro) {
                            contarLinhasLidas++;
                            System.out.println("Erro na linha: " + contarLinhasLidas + " o número inteiro está mal definido " + textoLexema);
                            return null;
                        }
                    }
                    break;
                }

                // Estado 4
                case 4: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    String sbstr = textoDaLinha.substring(indice, textoDaLinha.length());
                    if (Character.isDigit(lerChar.charAt(0))) {

                        if (sbstr.length() > 1) {
                            textoLexema += lerChar;
                            indice++;
                        }
                        estado = 5;
                    }

                    break;
                }
                // Estado 5
                case 5: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    boolean erro = false;
                    for (int i = indice; i < textoDaLinha.length(); i++) {
                        if (Character.isDigit(lerChar.charAt(0))) {
                            textoLexema += lerChar;
                            indice++;
                        } else if (Character.isWhitespace(lerChar.charAt(0)) || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '-'
                                || lerChar.charAt(0) == '*' || lerChar.charAt(0) == '/' || lerChar.charAt(0) == '+' || lerChar.charAt(0) == '(' || lerChar.charAt(0) == ')'
                                || lerChar.charAt(0) == '}' || lerChar.charAt(0) == ']' || lerChar.charAt(0) == '%' | lerChar.charAt(0) == '>' || lerChar.charAt(0) == '='
                                || lerChar.charAt(0) == '<' || lerChar.charAt(0) == '!' || lerChar.charAt(0) == '&' || lerChar.charAt(0) == '|' || lerChar.charAt(0) == ':'
                                || lerChar.charAt(0) == '?' || lerChar.charAt(0) == ',' || lerChar.charAt(0) == ';') {

                            indice++;
                            i = textoDaLinha.length();
                        } else {
                            erro = true;
                            textoLexema += lerChar;
                        }

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }
                    if (erro) {
                        contarLinhasLidas++;
                        System.out.println("Erro na linha: " + contarLinhasLidas + " o número real está mal definido " + textoLexema);
                        return null;
                    } else {
                        guardarLinha = contarLinhasLidas;
                        estado = 6;
                    }
                    break;
                }

                // Estado 6
                case 6: {

                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_NUMREAL);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 7
                case 7: {

                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_NUMINT);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;
                    }

                    break;
                }
                // Estado 8
                case 8: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '/') {//Comentario inline
                        //textoLexema += lerChar;
                        //indice++;
                        estado = 9;
                    } else if (lerChar.charAt(0) == '*') {//Comentario multi line
                        textoLexema += lerChar;
                        indice++;
                        estado = 13;
                    } else if (lerChar.charAt(0) == '=') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 64;
                    } else {//Operador /
                        textoLexema += lerChar;
                        indice++;
                        estado = 66;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 9
                case 9: {

                    lerChar = Character.toString(textoDaLinha.charAt(indice));

                    if (textoDaLinha.length() == 2 && lerChar.charAt(0) == '/') {//final do comentario

                        textoLexema += lerChar;
                        indice++;
                        estado = 12;
                    } else {//texto do comentario
                        textoLexema += lerChar;
                        indice++;
                        estado = 10;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 10
                case 10: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length(); i++) {

                        textoLexema += lerChar;
                        indice++;

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }
                    guardarLinha = contarLinhasLidas;
                    estado = 12;

                    break;
                }

                // Estado 12
                case 12: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_CM);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 13
                case 13: {

                    lerChar = Character.toString(textoDaLinha.charAt(indice));

                    if (lerChar.charAt(0) == '*') {//final do comentario

                        textoLexema += lerChar;
                        indice++;
                        estado = 14;
                    } else {//texto do comentario
                        textoLexema += lerChar;
                        indice++;
                        estado = 16;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 14
                case 14: {

                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    int state = 14;
                    for (int i = indice; i < textoDaLinha.length(); i++) {
                        if (lerChar.charAt(0) == '*') {
                            textoLexema += lerChar;
                            indice++;

                        } else if (lerChar.charAt(0) == '/') {
                            textoLexema += lerChar;
                            indice++;
                            state = 15;
                            i = textoDaLinha.length();
                        } else {
                            textoLexema += lerChar;
                            indice++;
                            state = 16;
                            i = textoDaLinha.length();
                        }

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }

                    estado = state;
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 15
                case 15: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_CM);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 16
                case 16: {
                    boolean sair = true, alterou = false;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    int i = indice;
                    while (i < textoDaLinha.length()) {

                        if (alterou && i == 1) {
                            i = -1;
                        }

                        textoLexema += lerChar;
                        indice++;
                        if (lerChar.charAt(0) == '*') {
                            i = textoDaLinha.length();
                            sair = false;
                        }

                        if (i + 1 >= textoDaLinha.length() && contarLinhasLidas + 1 < ficheiroLido.size() && lerChar.charAt(0) != '*') {
                            indice = 0;
                            contarLinhasLidas++;
                            textoDaLinha = ficheiroLido.get(contarLinhasLidas);
                            i = indice;
                            alterou = true;
                            textoLexema += "\n";
                        }

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                            alterou = false;
                        }

                        i++;
                    }
                    if (!sair) {
                        guardarLinha = contarLinhasLidas;
                        estado = 17;
                    } else {
                        contarLinhasLidas++;
                        System.out.println("Erro na linha: " + contarLinhasLidas + " faltou fechar comentário: " + textoLexema);
                        return null;
                    }
                    break;
                }

                // Estado 17
                case 17: {

                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    int state = 17;
                    for (int i = indice; i < textoDaLinha.length(); i++) {
                        if (lerChar.charAt(0) == '*') {
                            textoLexema += lerChar;
                            indice++;

                            if (i + 1 < textoDaLinha.length()) {
                                lerChar = Character.toString(textoDaLinha.charAt(indice));
                            }

                        } else if (lerChar.charAt(0) == '/') {
                            textoLexema += lerChar;
                            indice++;
                            state = 15;
                            i = textoDaLinha.length();
                        }
                    }

                    estado = state;
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 18
                case 18: {
                    boolean erro = true;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length(); i++) {

                        textoLexema += lerChar;
                        indice++;
                        if (lerChar.charAt(0) == '"') {
                            i = textoDaLinha.length();
                            erro = false;
                        }
                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }
                    if (erro) {
                        contarLinhasLidas++;
                        System.out.println("Erro na linha: " + contarLinhasLidas + " string inválida: " + textoLexema);
                        return null;
                    } else {
                        guardarLinha = contarLinhasLidas;
                        estado = 19;
                    }
                    break;
                }

                // Estado 19
                case 19: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_S);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 20
                case 20: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '\'' && textoDaLinha.length() == 2) {
                        textoLexema += lerChar;
                        indice++;
                        estado = 22;
                    } else if (textoDaLinha.length() > indice && (textoDaLinha.charAt(indice) == '\\'
                            || textoDaLinha.substring(indice).startsWith("\\\"")
                            || textoDaLinha.substring(indice).startsWith("\\'")
                            || textoDaLinha.substring(indice).startsWith("\\n")
                            || textoDaLinha.substring(indice).startsWith("\\r")
                            || textoDaLinha.substring(indice).startsWith("\\t")
                            || textoDaLinha.substring(indice).startsWith("\\b")
                            || textoDaLinha.substring(indice).startsWith("\\f"))) {

                        textoLexema = textoDaLinha.substring(indice + 1, indice + 3);
                        indice += textoLexema.length();
                        estado = 24;

                    } else if (textoDaLinha.length() > 1) {
                        textoLexema += lerChar;
                        indice++;
                        estado = 21;
                    } else if (textoDaLinha.trim().equals("'")) {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " char inválido " + textoLexema);
                        return null;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }
                // Estado 22
                case 22: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_C);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 21
                case 21: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));

                    if (lerChar.charAt(0) == '\'') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 23;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " char inválido " + textoLexema);
                        return null;
                    }

                    guardarLinha = contarLinhasLidas;
                    break;
                }
                // Estado 22
                case 23: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_C);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 24
                case 24: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));

                    if (lerChar.charAt(0) == '\'') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 23;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " char inválido " + textoLexema);
                        return null;
                    }

                    guardarLinha = contarLinhasLidas;
                    break;
                }

                // Estado 27
                case 27: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '+') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 30;
                    } else if (lerChar.charAt(0) == '=') {//Operador /
                        textoLexema += lerChar;
                        indice++;
                        estado = 30;
                    } else {
                        indice++;
                        estado = 30;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }
                // Estado 28
                case 28: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '-') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 30;
                    } else if (lerChar.charAt(0) == '=') {//Operador /
                        textoLexema += lerChar;
                        indice++;
                        estado = 30;
                    } else {
                        indice++;
                        estado = 30;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }
                // Estado 29
                case 29: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '=') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 30;
                    } else {
                        indice++;
                        estado = 30;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 30
                case 30: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_OPA);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 31
                case 31: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_OPATB);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 32
                case 32: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '=') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 33;
                    } else if (textoLexema.equals("=") && lerChar.charAt(0) != '=') {
                        indice++;
                        estado = 31;//Atribuição
                    } else {
                        indice++;
                        estado = 33;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 33
                case 33: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_OPR);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 34
                case 34: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '&') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 36;
                    } else {
                        indice++;
                        estado = 36;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 35
                case 35: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '|') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 36;
                    } else {
                        indice++;
                        estado = 36;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 36
                case 36: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_OPL);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 37
                case 37: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("include")) {
                        textoLexema += "include";
                        indice += 7;
                        estado = 41;
                    } else if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("endif")) {
                        textoLexema += "endif";
                        indice += 5;
                        estado = 38;
                    } else if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("undef")) {
                        textoLexema += "undef";
                        indice += 5;
                        estado = 39;
                    } else if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("define")) {
                        textoLexema += "define";
                        indice += 6;
                        estado = 39;
                    } else if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("ifdef")) {
                        textoLexema += "ifdef";
                        indice += 5;
                        estado = 39;
                    } else if (textoDaLinha.substring(indice, textoDaLinha.length()).startsWith("ifndef")) {
                        textoLexema += "ifndef";
                        indice += 6;
                        estado = 39;
                    } else {
                        indice++;
                        estado = 36;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 38
                case 38: {

                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_DIR);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 39
                case 39: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (Character.isLetter(lerChar.charAt(0)) || Character.isWhitespace(lerChar.charAt(0))) {
                        textoLexema += lerChar;
                        indice++;
                        estado = 40;
                        guardarLinha = contarLinhasLidas;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva está incompleta " + textoLexema);
                        return null;
                    }
                    break;
                }

                // Estado 40
                case 40: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length(); i++) {

                        textoLexema += lerChar;
                        indice++;

                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }

                    guardarLinha = contarLinhasLidas;
                    estado = 38;

                    break;
                }

                // Estado 41
                case 41: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '<') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 42;
                    } else if (lerChar.charAt(0) == '"') {
                        indice++;
                        estado = 44;
                    } else {
                        System.out.println("Erro na linha: " + contarLinhasLidas + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 42
                case 42: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (Character.isLetter(lerChar.charAt(0))) {
                        textoLexema += lerChar;
                        indice++;
                        estado = 43;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 43
                case 43: {
                    boolean erro = true;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length() && erro; i++) {
                        if (Character.isLetter(lerChar.charAt(0)) || lerChar.charAt(0) == '_'
                                || Character.isDigit(lerChar.charAt(0))) {
                            textoLexema += lerChar;
                            indice++;
                        } else if (lerChar.charAt(0) == '.') {
                            erro = false;
                            textoLexema += lerChar;
                            indice++;

                        }
                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }

                    if (!erro) {
                        guardarLinha = contarLinhasLidas;
                        estado = 83;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta falta o simbolo ." + textoLexema);
                        return null;
                    }

                    break;
                }

                // Estado 44
                case 44: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (Character.isLetter(lerChar.charAt(0))) {
                        textoLexema += lerChar;
                        indice++;
                        estado = 45;
                    } else {
                        System.out.println("Erro na linha: " + contarLinhasLidas + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 45
                case 45: {
                    boolean erro = true;
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    for (int i = indice; i < textoDaLinha.length() && erro; i++) {
                        if (Character.isLetter(lerChar.charAt(0)) || lerChar.charAt(0) == '_'
                                || Character.isDigit(lerChar.charAt(0))) {
                            textoLexema += lerChar;
                            indice++;
                        } else if (lerChar.charAt(0) == '.') {
                            erro = false;
                            textoLexema += lerChar;
                            indice++;

                        }
                        if (i + 1 < textoDaLinha.length()) {
                            lerChar = Character.toString(textoDaLinha.charAt(indice));
                        }
                    }

                    if (!erro) {
                        guardarLinha = contarLinhasLidas;
                        estado = 81;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta falta o simbolo ." + textoLexema);
                        return null;
                    }

                    break;
                }

                // Estado 47
                case 47: {

                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_AP);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 48
                case 48: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_FP);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 49
                case 49: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_APR);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 83
                case 83: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == 'c' || lerChar.charAt(0) == 'h') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 80;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }
                // Estado 83
                case 80: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '>') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 38;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 50
                case 50: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_FPR);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 81
                case 81: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == 'c' || lerChar.charAt(0) == 'h') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 82;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }
                // Estado 82
                case 82: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '"') {
                        textoLexema += lerChar;
                        indice++;
                        estado = 38;
                    } else {
                        System.out.println("Erro na linha: " + (contarLinhasLidas + 1) + " diretiva include está incompleta " + textoLexema);
                        return null;
                    }
                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 51
                case 51: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_AC);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 52
                case 52: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_FC);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 53
                case 53: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_PVIRG);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 54
                case 54: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_VIRG);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 55
                case 55: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_PINTER);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }
                // Estado 56
                case 56: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_DPTO);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 57
                case 57: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_PTO);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 58
                case 58: {
                    lerChar = Character.toString(textoDaLinha.charAt(indice));
                    if (lerChar.charAt(0) == '=') {//Operador /=
                        textoLexema += lerChar;
                        indice++;
                        estado = 70;
                    } else if (lerChar.charAt(0) != '*') {//Operador /

                        indice++;
                        estado = 70;
                    }

                    guardarLinha = contarLinhasLidas;

                    break;
                }

                // Estado 70
                case 70: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema);
                        lex.setToken(Token.TK_OPA);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 64
                case 64: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(textoLexema.substring(0, 2));
                        lex.setToken(Token.TK_OPA);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

                // Estado 66
                case 66: {
                    if (end == true) {
                        estado = 0;
                        end = false;
                    } else {
                        lex = new TipoLex();
                        lex.setLexema(Character.toString(textoLexema.charAt(0)));
                        lex.setToken(Token.TK_OPA);
                        lex.setLinha(guardarLinha + 1);
                        result.add(lex);
                        textoLexema = "";
                        end = true;

                    }

                    break;
                }

            }
            guardarLinha = contarLinhasLidas;
            if (indice == textoDaLinha.length()) {
                //só zera se a próxima linha existir
                if (contarLinhasLidas + 1 < ficheiroLido.size()) {
                    indice = 0;
                }

                contarLinhasLidas++;

            }

        } while (contarLinhasLidas <= ficheiroLido.size());

        lex = new TipoLex();
        lex.setToken(Token.TK_FIM);
        lex.setLexema("");
        lex.setLinha(++guardarLinha);
        result.add(lex);
        //System.out.println("SIZE: " + result.size());
        return result;
    }

}
