package Objects;

/**
 *
 * @author alexis
 */

public class VariableObject extends Token {

    private tipoDatos type;
    private boolean bandera = false;

    public VariableObject(tipoDatos type, int x, int y, String lexeme) {
        super(x, y, lexeme);
        this.type = type;
    }

    public tipoDatos getType() {
        return type;
    }

    public void setType(tipoDatos type) {
        this.type = type;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    

}
