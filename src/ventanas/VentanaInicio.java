package ventanas;

import Componentes.Personas.General;
import DataBase.MySQLConnection;
import EntradaSalida.LectorFicheros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Esther Manresa
 */
public class VentanaInicio extends javax.swing.JFrame {

    private final MySQLConnection mysql = MySQLConnection.getInstance();
    
    public VentanaInicio() {
        initComponents();
        this.jButtonCargarGenerales.setVisible(this.mysql.getGenerales().isEmpty());
        //Logica del tamaño y localizacion de la ventana
        
        
        this.LocationRelativeto (null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 470);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonReclutar = new javax.swing.JButton();
        jButtonCargarGenerales = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonReclutar.setBackground(new java.awt.Color(204, 153, 0));
        jButtonReclutar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonReclutar.setText("Reclutar");
        jButtonReclutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReclutarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonReclutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 120, 30));

        jButtonCargarGenerales.setBackground(new java.awt.Color(204, 153, 0));
        jButtonCargarGenerales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonCargarGenerales.setText("Cargar Generales");
        jButtonCargarGenerales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCargarGeneralesActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCargarGenerales, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 180, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Bienvenidos al Mundo en Guerra");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 400, 40));

        jButton1.setBackground(new java.awt.Color(204, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jButton1.setText("Tops");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jLabelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Imagen Inicio.png"))); // NOI18N
        jLabelfondo.setBorder(new javax.swing.border.MatteBorder(null));
        jLabelfondo.setDisabledIcon(null);
        getContentPane().add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReclutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReclutarActionPerformed
        VentanaEjercito1 newframe = new VentanaEjercito1();//Logica que enlaza con la siguiente ventana
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonReclutarActionPerformed

    private void jButtonCargarGeneralesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCargarGeneralesActionPerformed
        JFileChooser fileChooser = new JFileChooser();// Logica que abre archivo Generales
        fileChooser.setDialogTitle("Elija el archivo con los datos de los Generales");
        
        // Filtro para mostrar solo archivos de texto
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);
        
        fileChooser.addActionListener(new FileChosenActionListener(fileChooser, this.jButtonCargarGenerales));

        int seleccion = fileChooser.showOpenDialog(this);

    }//GEN-LAST:event_jButtonCargarGeneralesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaTopScores newframe = new VentanaTopScores();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }
    
    private class FileChosenActionListener implements ActionListener {

        private final JFileChooser fileChooser;
        private final JButton button;

        public FileChosenActionListener(JFileChooser fileChooser, JButton button) {
            this.fileChooser = fileChooser;
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            final String filePath = fileChooser.getSelectedFile().toString();
            
            System.out.println(filePath);
            try {
                LectorFicheros.leerFichero(filePath);
                this.button.setVisible(MySQLConnection.getInstance().getGenerales().isEmpty());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCargarGenerales;
    private javax.swing.JButton jButtonReclutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelfondo;
    // End of variables declaration//GEN-END:variables

    private void LocationRelativeto(Object object) {
        
    }

    private void cargarListadoDesdeArchivo(String listado_generalestxt) {
       
    }

    private static class ventanaEjercito {
        public ventanaEjercito() {} 
    }
  
        }
 

