/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import Helper.HelperVariable;
import Objects.metodoObject;
import Objects.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexis
 */
public class jsonObject {
    private double score = 0;
    private List<String> ListNameClass = new ArrayList<>();
    private List<metodoObject> ListMethods = new ArrayList<>();
    private List<HelperVariable> ListVariable = new ArrayList<>();
    private List<Token> ListComments = new ArrayList<>();

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public List<String> getListNameClass() {
        return ListNameClass;
    }

    public void setListNameClass(List<String> listNameClass) {
        ListNameClass = listNameClass;
    }

    public List<metodoObject> getListMethods() {
        return ListMethods;
    }

    public void setListMethods(List<metodoObject> listMethods) {
        ListMethods = listMethods;
    }

    public List<Token> getListComments() {
        return ListComments;
    }

    public void setListComments(List<Token> listComments) {
        ListComments = listComments;
    }

    public List<HelperVariable> getListVariable() {
        return ListVariable;
    }

    public void setListVariable(List<HelperVariable> listVariable) {
        ListVariable = listVariable;
    }
}
