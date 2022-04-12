/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparar;

import Frontend.NewJFrame;
import Helper.HelperVariable;
import JSON.jsonObject;
import Objects.classObject;
import Objects.metodoObject;
import Objects.Token;
import Objects.VariableObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexis
 */
public class comparacion extends Thread {
    private double score = 0;
    // score general
        // proyectos
    private ArrayList<classObject> Archivo1;
    private ArrayList<classObject> Archivo2;
    
    
    // cantida de objetos
    private int numVariable = 0;
    private int numComments = 0;
    private int numMethods = 0;
    private int numClass = 0;

    

    
    // jsonss
    private jsonObject generarJson = new jsonObject();

    
    //CONSTRUCTOR DE CLASE
    public comparacion(ArrayList<classObject> poryectTwo, ArrayList<classObject> poryectOne) {
        this.Archivo1 = poryectTwo;
        this.Archivo2 = poryectOne;
    }

    
    
    //GENERACION JSON
    public jsonObject comparacionAnalisis() {
        this.start();
        AnalizadorMetodos();
        analizarVariable();
        try {
            do {
                Thread.sleep(500);
            } while (this.isAlive());
        } catch (Exception e) {
            Frontend.NewJFrame.jTextArea1.append("ERROR");
        }
        score = calculoScore(generarJson.getListComments().size(), this.numComments) + calculoScore(generarJson.getListMethods().size(), this.numMethods)
                + calculoScore(generarJson.getListNameClass().size(), this.numClass)+ calculoScore(generarJson.getListVariable().size(), this.numVariable);
        generarJson.setScore(score);
        return generarJson;
    }

    // analizador de metodos
    private void AnalizadorMetodos() {
        for (classObject clase1 : Archivo2) {
            for (classObject classSyntaxComparar : Archivo1) {
                for (metodoObject methodOne : clase1.getListMethods()) {
                    for (metodoObject methodTWO : classSyntaxComparar.getListMethods()) {
                        if (metodosIguales(methodOne, methodTWO)) {
                            generarJson.getListMethods().add(methodOne);
                            methodTWO.setFlag(true);
                        }
                    }
                }
            }
        }
    }

    
    
    //metodos iguales
    private boolean metodosIguales(metodoObject methodOne, metodoObject methodTWO) {
        if (!methodTWO.isFlag()) {
            if (analizarNombreClase(methodOne.getLexema(), methodTWO.getLexema())
                    && ParametrosEquivalentes(methodOne.getListParameters(), methodTWO.getListParameters())) {
                return true;
            }
        }
        return false;
    }

    // n
    private boolean ParametrosEquivalentes(List<VariableObject> listParametersOne, List<VariableObject> listParametersTwo) {
        int i = (listParametersOne.size() > listParametersTwo.size()) ? listParametersTwo.size()
                : listParametersOne.size();
        int conter = 0;
        if (i == 0) {
            return listParametersOne.size() == listParametersTwo.size();
        }
        for (int j = 0; j < i; j++) {
            if (repeticionVariables(listParametersOne.get(j), listParametersTwo.get(j))) {
                conter++;
            }
        }
        return conter == i;
    }

    private void analizarVariable() {
        for (classObject classSyntax : Archivo2) {
            for (classObject classSyntaxComparar : Archivo1) {
                for (VariableObject variable : classSyntax.getListVariable()) {


// variables de clase
                    for (VariableObject variableTWO : classSyntaxComparar.getListVariable()) {
                        if (repeticionVariables(variable, variableTWO)) {
                            generarJson.getListVariable().add(new HelperVariable(variable, classSyntax.getName(),
                                    classSyntaxComparar.getName()));
                            variableTWO.setBandera(true);
                        }
                    }
                    // parametros de clase dos
                    for (metodoObject method : classSyntaxComparar.getListMethods()) {
                        for (VariableObject variableTWO : method.getListParameters()) {
                            if (repeticionVariables(variable, variableTWO)) {
                                generarJson.getListVariable().add(new HelperVariable(variable, classSyntax.getName(), method.getLexema()));
                                variableTWO.setBandera(true);
                            }
                        }
                    }
                }
                for (metodoObject methodClassOne : classSyntax.getListMethods()) {
                    //parametros de clases
                    
                    
                    for (VariableObject variable : methodClassOne.getListParameters()) {
                        for (VariableObject variableTWO : classSyntaxComparar.getListVariable()) {
                            if (repeticionVariables(variable, variableTWO)) {
                                generarJson.getListVariable()
                                        .add(new HelperVariable(variable, methodClassOne.getLexema(),
                                                classSyntaxComparar.getName()));
                                variableTWO.setBandera(true);
                            }
                        }

                        for (metodoObject method : classSyntaxComparar.getListMethods()) {
                            for (VariableObject variableTWO : method.getListParameters()) {
                                if (repeticionVariables(variable, variableTWO)) {
                                    generarJson.getListVariable().add(new HelperVariable(variable, method.getLexema(),
                                                    classSyntaxComparar.getName()));
                                    variableTWO.setBandera(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void AnalizarClase(classObject classSyntax, classObject classSyntaxComparar) {
        // if name class ==
        if (analizarNombreClase(classSyntax.getName(), classSyntaxComparar.getName())
                & analyzerMetodo_Clase(classSyntax.getListMethods(), classSyntaxComparar.getListMethods())) {
            generarJson.getListNameClass().add(classSyntaxComparar.getName());
        }
    }

    private boolean analyzerMetodo_Clase(List<metodoObject> classOne, List<metodoObject> classTwo) {
        int i = (classOne.size() > classTwo.size()) ? classTwo.size() : classOne.size();
        int conter = 0;
        if (i == 0) {
            return classOne.size() == classTwo.size();
        }
        for (int j = 0; j < i; j++) {
// mismo nombre
            if (analizarNombreClase(classOne.get(j).getLexema(), classTwo.get(j).getLexema())) {
                conter++;
            }
        }
        return conter == i;
    }

    private boolean analizarNombreClase(String classSyntax, String classSyntaxComparar) {
        return classSyntax.equals(classSyntaxComparar);
    }

    // ANALYZE COMMENTS AND NAME CLASS//n3
    private void comentarioClaseAnalisis() {
        for (classObject classSyntax : Archivo2) {// n
            for (classObject classSyntaxComparar : Archivo1) {// n2
                // analyzer class
                AnalizarClase(classSyntax, classSyntaxComparar);// n3
                for (Token tokenONE : classSyntax.getListComments()) {// n3
                    for (Token tokenTWO : classSyntaxComparar.getListComments()) {
                        if (comentariosIguales(tokenONE, tokenTWO)) {
                            generarJson.getListComments().add(tokenTWO);
                        }
                    }
                }
            }
        }
    }

    private boolean repeticionVariables(VariableObject variable, VariableObject variableTWO) {
        if (!variableTWO.isBandera()) {
            return (variable.getLexema().equals(variableTWO.getLexema()))
                    && (variable.getType() == variableTWO.getType());
        } else {
            return false;
        }
    }

    private boolean comentariosIguales(Token tokenONE, Token tokenTWO) {
        return tokenONE.getLexema().equals(tokenTWO.getLexema());
    }

// calculos
    private double calculoScore(double repetido, double suma) {
        if (suma > 0) {
            return (repetido / suma) * 0.25;
        }
        return 0;
    }

    
    // ingreso run
    @Override
    public void run() {
        try {
            sumar();
            comentarioClaseAnalisis();
        } catch (Exception e) {
        }
    }

    private void sumar() {
        this.numClass = Archivo1.size() + Archivo2.size();
        Operacion(this.Archivo1);
        Operacion(this.Archivo2);
    }
    
    
    private void Operacion(ArrayList<classObject> user) {
        for (classObject userClass : user) {
            this.numVariable += userClass.getListVariable().size();
            this.numComments += userClass.getListComments().size();
            this.numMethods += userClass.getListMethods().size();
            
            // con todos los metodos y numeros
            for (metodoObject element : userClass.getListMethods()) {
                List<VariableObject> ListVariableListMethods = element.getListParameters();
                this.numVariable += ListVariableListMethods.size();
            }
        }
    }
    
}
