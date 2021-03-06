/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frontend;

import Archive.AnalsisDirectorios;
import Comparacion.comparacionProyectos;
import Main.NewMain;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alexis
 */
public class ProyectosComparaciones extends javax.swing.JFrame {

    

    private String fileProyectOne = "";
    private String fileProyectTwo = "";
    /**
     * Creates new form ProyectosComparaciones
     */
    public ProyectosComparaciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton2 = new javax.swing.JButton();
        botonComparar = new javax.swing.JButton();
        jButtonViewResults = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Proyecto 1: ");

        boton1.setText("Agregar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Proyecto 2: ");

        boton2.setText("Agregar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        botonComparar.setText("Comparar");
        botonComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompararActionPerformed(evt);
            }
        });

        jButtonViewResults.setText("Ver");
        jButtonViewResults.setEnabled(false);
        jButtonViewResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewResultsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonViewResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(botonComparar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(botonComparar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonViewResults)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
         this.fileProyectOne = cargaArchivo("Selecione la carpeta " );

    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
             this.fileProyectTwo = cargaArchivo("ingreso");

    }//GEN-LAST:event_boton2ActionPerformed

    private void botonCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompararActionPerformed
     if (this.fileProyectOne.isBlank()) {
            JOptionPane.showMessageDialog(null, "Seleccione" );
        } else if (this.fileProyectTwo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Seleccione");
        } else if (JOptionPane.showConfirmDialog(null, "analizr","analizar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            ArrayList<String> proyectOne = (new AnalsisDirectorios(new File(this.fileProyectOne))).converterProyect();
            ArrayList<String> proyectTwo = (new AnalsisDirectorios(new File(this.fileProyectTwo))).converterProyect();
        }
    }//GEN-LAST:event_botonCompararActionPerformed

    private void jButtonViewResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewResultsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonViewResultsActionPerformed

    
    
    
    
    private String cargaArchivo(String menssage) {
        JFileChooser seleccionarArchivo = new JFileChooser();
        seleccionarArchivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleccionarArchivo.setAcceptAllFileFilterUsed(false);
        if (seleccionarArchivo.showOpenDialog(null) == JFileChooser.APPROVE_OPTION || seleccionarArchivo.getCurrentDirectory() != null) {
            return seleccionarArchivo.getSelectedFile().getAbsoluteFile().toString();
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1;
    private javax.swing.JButton boton2;
    private javax.swing.JButton botonComparar;
    private javax.swing.JButton jButtonViewResults;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
