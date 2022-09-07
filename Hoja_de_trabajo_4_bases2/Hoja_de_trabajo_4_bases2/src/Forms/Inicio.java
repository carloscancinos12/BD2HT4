package Forms;

import Logica.Datos;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inicio extends javax.swing.JFrame {

  
    public Inicio() {
        initComponents();
        CP = new Datos();
    }

    private final Datos CP;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        NoComprometida = new javax.swing.JButton();
        Comprometida = new javax.swing.JButton();
        Serializable = new javax.swing.JButton();
        Repetible = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("INICIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        NoComprometida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NoComprometida.setText("NO COMPROMETIDA");
        NoComprometida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoComprometidaActionPerformed(evt);
            }
        });

        Comprometida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Comprometida.setText("COMPROMETIDA");
        Comprometida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComprometidaActionPerformed(evt);
            }
        });

        Serializable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Serializable.setText("SERIALIZABLE");
        Serializable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SerializableActionPerformed(evt);
            }
        });

        Repetible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Repetible.setText("REPETIBLE");
        Repetible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepetibleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Repetible)
                        .addGap(98, 98, 98)
                        .addComponent(Serializable))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NoComprometida)
                        .addGap(18, 18, 18)
                        .addComponent(Comprometida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoComprometida)
                    .addComponent(Comprometida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Repetible)
                    .addComponent(Serializable))
                .addGap(0, 49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoComprometidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoComprometidaActionPerformed
        // TODO add your handling code here:
        new Transaccion1(1).setVisible(true);
        new Transaccion2(1).setVisible(true);
        dispose();
    }//GEN-LAST:event_NoComprometidaActionPerformed

    private void ComprometidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComprometidaActionPerformed
        // TODO add your handling code here:
        new Transaccion1(2).setVisible(true);
        new Transaccion2(2).setVisible(true);
        dispose();
    }//GEN-LAST:event_ComprometidaActionPerformed

    private void SerializableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SerializableActionPerformed
        new Transaccion1(4).setVisible(true);
        new Transaccion2(4).setVisible(true);
        dispose();
    }//GEN-LAST:event_SerializableActionPerformed

    private void RepetibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepetibleActionPerformed
        new Transaccion1(3).setVisible(true);
        new Transaccion2(3).setVisible(true);
        dispose();
    }//GEN-LAST:event_RepetibleActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comprometida;
    private javax.swing.JButton NoComprometida;
    private javax.swing.JButton Repetible;
    private javax.swing.JButton Serializable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
