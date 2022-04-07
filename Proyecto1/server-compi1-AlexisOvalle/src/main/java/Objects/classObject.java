package Objects;

import java.util.List;

/**
 *
 * @author alexis
 */

public class classObject {
    private String name;
    private List<metodoObject> ListMethods;
    private List<VariableObject> ListVariable;
    private List<Token> ListComments;

    public classObject(String name, List<metodoObject> listMethods, List<VariableObject> listVariable, List<Token> listComments) {
        this.name = name;
        ListMethods = listMethods;
        ListVariable = listVariable;
        ListComments = listComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<metodoObject> getListMethods() {
        return ListMethods;
    }

    public void setListMethods(List<metodoObject> listMethods) {
        ListMethods = listMethods;
    }

    public List<VariableObject> getListVariable() {
        return ListVariable;
    }

    public void setListVariable(List<VariableObject> listVariable) {
        ListVariable = listVariable;
    }

    public List<Token> getListComments() {
        return ListComments;
    }

    public void setListComments(List<Token> listComments) {
        ListComments = listComments;
    }

}
