/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JSON;

import Helper.HelperVariable;
import Objects.metodoObject;
import Objects.Token;

/**
 *
 * @author alexis
 */
public class convertidorJson {
    private final String NAME = "Nombre";
    private final String TEXT = "Texto";
    private final String FUNCTION = "Funcion";
    private final String SCORE = "Score";
    private final String TIPODATO = "Tipo";


    public String converterJson(jsonObject user) {
        String text = "{";
        int i = 0;
        text += "";
        text += "\n\t" + SCORE + ":" + "\"" + user.getScore() + "\"" + ",";
        // class
        text += "\n\tClases:[";
        for (String element : user.getListNameClass()) {
            text += "\n\t\t{" + NAME + ":" + "\"" + element
                    + "\""
                    + "}";
            i++;
            text += (i > 0 & i < user.getListNameClass().size()) ? "," : "";
        }
        text += "\n\t\t],";
        i = 0;
        // variable
        text += "\n\tVariables:[";
        for (HelperVariable element : user.getListVariable()) {
            text += "\n\t\t{";
            text += NAME + ":" + "\"" + element.getVariable().getLexema() + "\"" + ",";
            text += TIPODATO + ":" + "\"" + element.getVariable().getType() + "\"" + ",";
            text += FUNCTION + ":" + "\"" + element.getOriginal() + "," + element.getWho()
                    + "\"";
            text += "}";
            i++;
            text += (i > 0 & i < user.getListVariable().size()) ? "," : "";
        }
        text += "\n\t\t],";
        i = 0;
        
            
        text += "\n\tMetodos:[";
        for (metodoObject element : user.getListMethods()) {
            text += "\n\t\t{";
            text += NAME + ":" + "\"" + element.getLexema() + "\"" + ",";
            text += TIPODATO + ":" + "\"" + element.getType() + "\"" + ",";
            text += "Parametros" + ":" + element.getListParameters().size();
            text += "}";
            i++;
            text += (i > 0 & i < user.getListMethods().size()) ? "," : "";
        }
        text += "\n\t\t],";
        i = 0;
        // COMMENT
        text += "\n\tComentarios:[";
        for (Token element : user.getListComments()) {
            text += "\n\t\t{";
            text += TEXT +":"+ "\"" + element.getLexema() + "\""+"}";
            i++;
            text += (i > 0 & i < user.getListComments().size()) ? "," : "";
        }
        text += "\n\t\t ]";
        text += "\n}";
        return text;
    }
}
