/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Frontend.ServerGui;
import Socket.Conexion;

/**
 *
 * @author alexis
 */
public class NewMain {

public static final int PORT = (((10300)));
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new ServerGui().setVisible(true);
                Conexion server = new Conexion(PORT);
                server.start();
            }
        });
    }
    
}
