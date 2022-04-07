package Helper;

import Objects.VariableObject;

/**
 *
 * @author alexis
 */
public class HelperVariable {
    private VariableObject variable;
    private String original;
    private String function;

    public HelperVariable(VariableObject variable, String original, String function) {
        this.variable = variable;
        this.original = original;
        this.function = function;
    }

    public VariableObject getVariable() {
        return variable;
    }

    public void setVariable(VariableObject variable) {
        this.variable = variable;
    }



    public String getFunction() {
        return function;
    }

    public void setFunction(String who) {
        this.function = who;
    }

        public String getOriginal() {
        return original;
    }

    public void setOriginal(String find) {
        this.original = find;
    }
}
