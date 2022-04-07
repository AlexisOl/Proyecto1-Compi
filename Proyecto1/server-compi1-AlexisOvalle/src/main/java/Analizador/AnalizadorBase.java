package Analizador;

import Objects.classObject;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

import AnalizadoresLex_Sin.Lexico;
import AnalizadoresLex_Sin.Sintactico;
import AnalizadoresLex_Sin.sym;
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
            Sintactico sic = new Sintactico(lexema);
            classObject prueva = null;
            try {
                sic.parse();
                prueva = sic.getClassSyntax();
                prueva.setListComments(lexema.getlistComments());
                errorCounter += sic.getErrorCounter();
            } catch (Exception e) {
                Symbol s = sic.getSymbol();
                errorCounter += sic.getErrorCounter();
                if (s != null) {
                    Frontend.ServerGui.jTextArea1.append("\n" + sic.getErrorCounter() + " - clase-<" + sic.getNameClass() + "en"+ sym.terminalNames[s.sym]);
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
            Frontend.ServerGui.jTextArea1.append("error");
        }
    }

    public int getErrorCounter() {
        return errorCounter;
    }

}
