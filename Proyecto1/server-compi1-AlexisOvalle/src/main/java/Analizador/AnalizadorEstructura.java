package Analizador;

import Objects.classObject;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class AnalizadorEstructura extends Thread{
    private ArrayList<String> listClass;
    private ArrayList<classObject> proyect = new ArrayList<>();
    
    public AnalizadorEstructura(ArrayList<String> listClass) {
        this.listClass = listClass;
    }

    public ArrayList<String> getListClass() {
        return listClass;
    }

    public void setListClass(ArrayList<String> listClass) {
        this.listClass = listClass;
    }

    public ArrayList<classObject> getProyect() {
        return proyect;
    }

    public void setProyect(ArrayList<classObject> proyect) {
        this.proyect = proyect;
    }
    
    
    @Override
    public void run() {
        for (String element : listClass) {
            try {
                new Thread(new AnalizadorBase(element, proyect)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }        
    }
 }
