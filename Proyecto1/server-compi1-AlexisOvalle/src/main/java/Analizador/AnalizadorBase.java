package Analizador;

import Objects.classObject;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import Frontend.*;
import AnalizadoresLex_Sin.Lexico;
import AnalizadoresLex_Sin.*;
import AnalizadoresLex_Sin.sym;
import Frontend.NewJFrame;
/**
 *
 * @author alexis
 */

import java_cup.runtime.Symbol;

public class AnalizadorBase implements Runnable {
    private String text;
    public static int errorCounter = 0;
    private ArrayList<classObject> proyect;

    public AnalizadorBase(String text, ArrayList<classObject> proyect) {
        this.text = text;
        this.proyect = proyect;
    }

    private classObject Analyzer() {
        
        if (!text.isEmpty()) {
            Reader reader = new StringReader(text);
            
            // ingreso analizadores
            Lexico lexema = new Lexico(reader);
            parser sic = new parser(lexema);
            classObject prueva = null;
            try {
                sic.parse();
                prueva = sic.getClassSyntax();
                prueva.setListComments(lexema.getlistComments());
                errorCounter += sic.getcantidadErrores();
            } catch (Exception e) {
                Symbol s = sic.getSymbol();
                errorCounter += sic.getcantidadErrores();
                if (s != null) {
                    NewJFrame.jTextArea1.append("\n"+sic.getcantidadErrores()+
              "  Error en clase: "+sic.getNameClass()+
              " lexema:" +sym.terminalNames[s.sym]);
                }
                e.printStackTrace();
                System.out.println(e.getMessage());
            } finally {
            }
            return prueva;
        } else {
            return null;
        }
    }
    
    
// sobrecarga del inicio
    @Override
    public void run() {
        try {
            classObject analyzer = Analyzer();
            if (analyzer != null) {
                proyect.add(analyzer);
            }
        } catch (Exception e) {
             NewJFrame.jTextArea1.append("Error");
        }
    }

    public int getErrorCounter() {
        return errorCounter;
    }

}
