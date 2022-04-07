/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexionSocketCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author alexis
 */
public class conexionSocket {
    public void socketCliente(String directorio1, String directorio2) {
        String HOST_PORT = "127.0.0.1";
        int PORT= 6000;
        DataInputStream input;
        DataOutputStream output;
        try {
            Socket socketCliente = new Socket(HOST_PORT,PORT);
            input = new DataInputStream(socketCliente.getInputStream());
            output = new DataOutputStream(socketCliente.getOutputStream());
            //Escribe y envia los directorios
            output.writeUTF(HOST_PORT);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
