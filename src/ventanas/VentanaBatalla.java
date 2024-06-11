package ventanas;

import Batallas.Batalla;
import Batallas.Ronda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Esther
 */
public class VentanaBatalla extends javax.swing.JFrame {
    private Batalla batalla = Batalla.getInstance();
   
    public VentanaBatalla() {
        
        this.batalla = Batalla.getInstance();
        
        initComponents();
        this.ejercito1Label.setText("Ejercito 1: " + this.batalla.getEjercito1().getNombre());
        this.ejercito2Label.setText("Ejercito 2: " + this.batalla.getEjercito2().getNombre());
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        
        setSize(775, 435);
        setLocationRelativeTo(null);
        this.updateComponentState();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBatalla = new javax.swing.JLabel();
        jLabelGanador = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButtonSalir = new javax.swing.JButton();
        jButtonLuchar = new javax.swing.JButton();
        ejercito1Label = new javax.swing.JLabel();
        ejercito2Label = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBatalla.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabelBatalla.setForeground(new java.awt.Color(153, 0, 0));
        jLabelBatalla.setText("Batalla");
        getContentPane().add(jLabelBatalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 140, 50));

        jLabelGanador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelGanador.setForeground(new java.awt.Color(153, 0, 0));
        jLabelGanador.setText("Ganador");
        getContentPane().add(jLabelGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 210, -1));

        jTable2.setBackground(new java.awt.Color(255, 204, 51));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ronda", "Ataque", "Defensa", "Resultado"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 140));

        jButtonSalir.setBackground(new java.awt.Color(204, 153, 0));
        jButtonSalir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonSalir.setText("Guardar");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 90, -1));

        jButtonLuchar.setBackground(new java.awt.Color(204, 153, 0));
        jButtonLuchar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonLuchar.setText("Luchar");
        jButtonLuchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLucharActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLuchar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 193, 90, 30));

        ejercito1Label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ejercito1Label.setForeground(new java.awt.Color(153, 0, 0));
        ejercito1Label.setText("Ejército 1:");
        getContentPane().add(ejercito1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 170, 30));

        ejercito2Label.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ejercito2Label.setForeground(new java.awt.Color(153, 0, 0));
        ejercito2Label.setText("Ejército 2:");
        getContentPane().add(ejercito2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 180, 20));

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Captura de pantalla 2024-03-18 211549.png"))); // NOI18N
        imageLabel.setText("jLabel1");
        getContentPane().add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        VentanaTopScores newframe = new VentanaTopScores();
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonLucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLucharActionPerformed
        this.batalla.luchar();
        this.updateComponentState();
       
    }//GEN-LAST:event_jButtonLucharActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaBatalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaBatalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ejercito1Label;
    private javax.swing.JLabel ejercito2Label;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButtonLuchar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelBatalla;
    private javax.swing.JLabel jLabelGanador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void updateComponentState(){
        this.jButtonLuchar.setEnabled(this.batalla.getGanador() == null);
        List<String[]> listArray = new ArrayList<>();
        for(Ronda r : this.batalla.getRondas()){
            listArray.add(r.toStringArray());
        }
        
        //System.out.println(this.batalla.getEjercito2().getComponentes().size() + " Unidades");
        
        String[][] tableDataModel = listArray.stream().toArray(String[][]::new);
        
        //System.out.println(tableDataModel);
        
        this.jTable2.setModel(new DefaultTableModel(
                tableDataModel,
                new String [] {"Ronda", "Atacante", "Defensor", "Resultado"}
        ));
        
        if(this.batalla.getGanador() != null) this.jLabelGanador.setText("Ganador: " + this.batalla.getGanador().getNombre());
        
        pack();
    }

}
