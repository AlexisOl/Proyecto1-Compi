package Objects;

import java.util.List;

/**
 *
 * @author alexis
 */

public class metodoObject extends Token {
    private tipoDatos type;
    private List<VariableObject> listParameters;
    private boolean flag = false;

    public metodoObject( tipoDatos type, List<VariableObject> listParameters, int x, int y, String lexeme) {
        super(x, y, lexeme);
        this.type = type;
        this.listParameters = listParameters;
    }

    public tipoDatos getType() {
        return type;
    }

    public void setType(tipoDatos type) {
        this.type = type;
    }

    public List<VariableObject> getListParameters() {
        return listParameters;
    }

    public void selListParameters(List<VariableObject> listParameters) {
        this.listParameters = listParameters;
    }

    public void setListParameters(List<VariableObject> listParameters) {
        this.listParameters = listParameters;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    

}
