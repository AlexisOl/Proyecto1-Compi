/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Frontend.ProyectosComparaciones;

/**
 *
 * @author alexis
 */
public class NewMain {

 public static final int PORT = 10300;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProyectosComparaciones windos = new ProyectosComparaciones();
                windos.setVisible(true);
                windos.setLocationRelativeTo(null);
            }
        });
    }
    
}
