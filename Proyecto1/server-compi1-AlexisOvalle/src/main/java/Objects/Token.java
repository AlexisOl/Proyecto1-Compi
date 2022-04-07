package Objects;

/**
 *
 * @author alexis
 */
public class Token {
    private int fila;
    private int columna;
    private String lexema;

    public Token(int fila, int columna, String lexema) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int x) {
        this.fila = x;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int y) {
        this.columna = y;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

}
