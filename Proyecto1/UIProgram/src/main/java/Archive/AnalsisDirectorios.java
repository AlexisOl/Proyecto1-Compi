/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archive;

import Comparacion.helper;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class AnalsisDirectorios {
    
    private File proyect;
    private ArrayList<String> proyectFinal = new ArrayList<>();

    public AnalsisDirectorios(File proyect) {
        this.proyect = proyect;
    }

    public ArrayList<String> converterProyect() {
        if (proyect != null) {
            String root = proyect.getAbsoluteFile().toString();
            vista(root);
        }
        return proyectFinal;
    }
    
    private void agregar(Path rut) {
        String fileName = getExtension(rut.getFileName().toString());
        if (!fileName.isBlank()) {
            //if extension java
            if (fileName.equals("java")) {
                String direction = rut.getParent() + "/" + rut.getFileName().toString();
               
                (new helper(proyectFinal, new readArchives(new File(direction)))).start();
            }
        } else if (!rut.getFileName().toString().isBlank()) {
            vista(rut.getParent() + "/" + rut.getFileName().toString());
        }
    }
    private void vista(String root) {
        try {
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(root))) {
                for (Path ruta : ds) {
                    String file = ruta.getFileName().toString();
                    agregar(ruta);
                }
            } catch (IOException e) {
                System.err.println("Errd" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getExtension(String fileName) {
        String fe = "";
        if (fileName.contains(".")) {
            //return .extends from file
            fe = java.util.Arrays.stream(fileName.split("\\.")).reduce((a, b) -> b).orElse(null);
        }
        return fe;
    }
}


