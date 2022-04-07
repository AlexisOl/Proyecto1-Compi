/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archive;

import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class lineText {
    // CLASE PARA DETERMINAR LAS LINEAS
    public void contarLineas(JTextArea textarea, JTextArea textActual){     
    textActual.setText("");
    textarea.setCaretPosition(0);
      int cantidad_columnas = textarea.getLineCount();
        for (int i = 0; i <cantidad_columnas; i++) {
                textActual.append(Integer.toString(i+1) + " \n");
        }
        textActual.setCaretPosition(0);
        textActual.setAutoscrolls(false);
    }
    
}
