/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Socket;

import Analizador.AnalizadorBase;
import Analizador.AnalizadorEstructura;
import Comparar.comparacion;
import Frontend.NewJFrame;
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
public class Conexion extends Thread {

    private final int port;

    public Conexion(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
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
            Frontend.NewJFrame.jTextArea1.append("ERRORES");
        }

        ArrayList<classObject> poryectTwoFinal = archivo2.getProyect();
        ArrayList<classObject> poryectOneFinal = archivo1.getProyect();

        if (AnalizadorBase.errorCounter == 0) {
        } else {
                      Frontend.NewJFrame.jTextArea1.append("ERROR");

        }

        return returnString;
    }
    @Override
    public void run() {
        try {
            ServerSocket severt = new ServerSocket(this.port);
           Frontend.NewJFrame.jLabel2.setText(String.valueOf(this.port));
            System.out.println("a" + port);
            
            
            
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
                Frontend.NewJFrame.jTextArea1.append("\n" + json);
                socketClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Frontend.NewJFrame.jTextArea1.append("\n" + e.getMessage());

        }
        Frontend.NewJFrame.jTextArea1.append("FIN CADENA");
    }


}
