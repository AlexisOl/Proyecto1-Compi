package Objects;

/**
 *
 * @author alexis
 */

public class VariableObject extends Token {

    private String type;
    private boolean bandera = false;

    public VariableObject(String type, int x, int y, String lexeme) {
        super(x, y, lexeme);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    

}
