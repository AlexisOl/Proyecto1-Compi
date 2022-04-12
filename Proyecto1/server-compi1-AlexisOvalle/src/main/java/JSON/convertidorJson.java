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
    private final String FUNCION = "Funcion";
    private final String TIPODATO = "Tipo";


    public String converterJson(jsonObject user) {
        String generacionJson = "{";
        int i = 0;
        generacionJson += "";
        generacionJson += "\n\tScore Total:\"" + user.getScore() + "\",";
        // class
        generacionJson += "\n\tClases Encontradas:[";
        for (String element : user.getListNameClass()) {
            generacionJson += "\n\t\t{" + NAME + ":\"" + element
                    + "\""
                    + "}";
            i++;
            generacionJson += (i > 0 & i < user.getListNameClass().size()) ? "," : "";
        }
        generacionJson += "\n\t\t],";
        i = 0;
        //ingreso Metodo
        generacionJson += "\n\tMetodos:[";
        for (metodoObject element : user.getListMethods()) {
            generacionJson += "\n\t\t{";
            generacionJson += NAME + ":" + "\"" + element.getLexema() + "\"" + ",";
            generacionJson += TIPODATO + ":" + "\"" + element.getType() + "\"" + ",";
            generacionJson += "Parametros" + ":" + element.getListParameters().size();
            generacionJson += "}";
            i++;
            generacionJson += (i > 0 & i < user.getListMethods().size()) ? "," : "";
        }
        generacionJson += "\n\t\t],";
        i = 0;
        generacionJson += "\n\tVariables:[";
        for (HelperVariable element : user.getListVariable()) {
            generacionJson += "\n\t\t{";
            generacionJson += NAME + ":" + "\"" + element.getVariable().getLexema() + "\",";
            generacionJson += TIPODATO + ":" + "\"" + element.getVariable().getType() + "\",";
            generacionJson += FUNCION + ":" + "\"" + element.getOriginal() + "," + element.getFunction()
                    + "\"";
            generacionJson += "}";
            i++;
            generacionJson += (i > 0 & i < user.getListVariable().size()) ? "," : "";
        }
        generacionJson += "\n\t\t],";
        i = 0;
        generacionJson += "\n\tComentarios:[";
        for (Token element : user.getListComments()) {
            generacionJson += "\n\t\t{";
            generacionJson += TEXT +":"+ "\"" + element.getLexema() + "\""+"}";
            i++;
            generacionJson += (i > 0 & i < user.getListComments().size()) ? "," : "";
        }
        generacionJson += "\n\t\t ]";
        generacionJson += "\n}";
        return generacionJson;
    }
}
