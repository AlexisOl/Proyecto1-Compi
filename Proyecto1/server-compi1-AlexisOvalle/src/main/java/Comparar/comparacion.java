/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparar;

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

    

    

    
    //CONSTRUCTOR DE CLASE
    public comparacion(ArrayList<classObject> poryectTwo, ArrayList<classObject> poryectOne) {
        this.Archivo1 = poryectTwo;
        this.Archivo2 = poryectOne;
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
