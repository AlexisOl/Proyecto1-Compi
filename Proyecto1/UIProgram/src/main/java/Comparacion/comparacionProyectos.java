/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparacion;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author alexis
 */
public class comparacionProyectos {
     private int port;
    private ArrayList<String> proyectOne;
    private ArrayList<String> proyectTwo;
    private JButton button;

    public comparacionProyectos(int port, ArrayList<String> proyectOne, ArrayList<String> proyectTwo, JButton button) {
        this.port = port;
        this.proyectOne = proyectOne;
        this.proyectTwo = proyectTwo;
        this.button = button;
    }
    public ArrayList<String> getProyectOne() {
        return proyectOne;
    }

    public void setProyectOne(ArrayList<String> proyectOne) {
        this.proyectOne = proyectOne;
    }

    public ArrayList<String> getProyectTwo() {
        return proyectTwo;
    }

    public void setProyectTwo(ArrayList<String> proyectTwo) {
        this.proyectTwo = proyectTwo;
    }
    
   
}
