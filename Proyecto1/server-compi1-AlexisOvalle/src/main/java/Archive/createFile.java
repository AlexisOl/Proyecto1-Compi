/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author alexis
 */
public class createFile {
      
    private FileInputStream archivoIntento;

    

    public createFile() {
    }

    public String cargaArchivoDirectorio(File file) {
        String extract = "";
        try {
            archivoIntento = new FileInputStream(file);
            int valor;
            while ((valor = archivoIntento.read()) != -1) {
                char caracter = (char) valor;
                extract += caracter;
            }
            archivoIntento.close();
        } catch (FileNotFoundException ex) {
            System.out.println( "ERROR");
        } catch (IOException ex) {
            System.out.println("ERROR");
        }
        return extract;
    }

    public File directorioExistente(File check) {
        if (check.exists()) {
            return check;
        } else {
            if (check.mkdirs()) {
                System.out.println("se genero " + check.getName());
                return check;
            } else {
                System.out.println("ERROR " + check.getName());
            }
        }
        return null;
    }
}
