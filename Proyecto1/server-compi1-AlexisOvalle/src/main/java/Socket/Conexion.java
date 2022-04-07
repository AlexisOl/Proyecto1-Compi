/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import Analizador.AnalizadorBase;
import Analizador.AnalizadorEstructura;
import Comparar.comparacion;
import JSON.convertidorJson;
import JSON.jsonObject;
import Objects.classObject;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Conexion extends Thread  {
     private final int port;

    public Conexion(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void run() {
        try {
            ServerSocket severt = new ServerSocket(this.port);
            
           Frontend.ServerGui.jTextArea1.append("\nEl servidor: " + this.port);
           
            while (severt != null) {
                Socket socketClient = severt.accept();
                ObjectInputStream in = new ObjectInputStream(socketClient.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socketClient.getOutputStream());
                ArrayList<ArrayList<String>> list = (ArrayList<ArrayList<String>>) in.readObject();
                
                String json = "";
                
                if (list.size() == 2) {
                    json = "";
                    ArrayList<String> proyectTwo = list.get(0);
                    ArrayList<String> proyectOne = list.get(1);
                    json = comparar(proyectTwo, proyectOne);
                }
                out.writeObject(json);
                Frontend.ServerGui.jTextArea1.append("\n" + json);
                socketClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Frontend.ServerGui.jTextArea1.append("\nERROR " + e.getMessage());
        }
        Frontend.ServerGui.jTextArea1.append("\nFIN");

        //System.exit(0);
    }

    private String comparar(ArrayList<String> lista1, ArrayList<String> lista2) {
        String returnString = "";
        AnalizadorEstructura archivo1 = new AnalizadorEstructura(lista1);
         AnalizadorEstructura archivo2 = new AnalizadorEstructura(lista2);
         // generacion de archivos
        archivo1.start();
        archivo2.start();
        
        
        try {
            do {
                Thread.sleep(1000);
            } while (archivo1.isAlive() || archivo2.isAlive());
        } catch (Exception e) {
            Frontend.ServerGui.jTextArea1.append("ERROR");
        }
        
        ArrayList<classObject> poryectTwoFinal = archivo2.getProyect();
        ArrayList<classObject> poryectOneFinal = archivo1.getProyect();
        
        
        if (AnalizadorBase.errorCounter == 0) {
            comparacion analyzer = new comparacion(poryectOneFinal, poryectTwoFinal);
            jsonObject result = analyzer.comparacionAnalisis();
            returnString = new convertidorJson().converterJson(result);
        } else {
            Frontend.ServerGui.jTextArea1.append("ERRORES");
        }
        
        return returnString;
    }
}
