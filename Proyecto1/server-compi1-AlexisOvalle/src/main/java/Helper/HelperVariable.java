package Helper;

import Objects.VariableObject;

/**
 *
 * @author alexis
 */
public class HelperVariable {
    private VariableObject variable;
    private String original;
    private String who;

    public HelperVariable(VariableObject variable, String original, String who) {
        this.variable = variable;
        this.original = original;
        this.who = who;
    }

    public VariableObject getVariable() {
        return variable;
    }

    public void setVariable(VariableObject variable) {
        this.variable = variable;
    }



    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

        public String getOriginal() {
        return original;
    }

    public void setOriginal(String find) {
        this.original = find;
    }
}
