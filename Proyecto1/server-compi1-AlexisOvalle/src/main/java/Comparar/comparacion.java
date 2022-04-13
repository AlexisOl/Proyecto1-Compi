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

    

    private void analizarVariable() {
        for (classObject classSyntax : Archivo2) {
            for (classObject classSyntaxComparar : Archivo1) {
                for (VariableObject variable : classSyntax.getListVariable()) {
                    for (VariableObject variableTWO : classSyntaxComparar.getListVariable()) {
                    }
                   
             
                }
            
            }
        }
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
