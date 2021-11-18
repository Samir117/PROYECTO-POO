/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames;

import Clases.ControlDatos;
import javax.swing.JOptionPane;

/**
 *
 * @author Samir Rojas
 */
public class RegistroEstudiantes extends javax.swing.JFrame {

    /**
     * Creates new form RegistroEstudiantes
     */
    public RegistroEstudiantes() {
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

        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnregresar = new javax.swing.JButton();
        txtNumeroDocumento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Candara", 1, 36)); // NOI18N
        jLabel12.setText("REGISTRO ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        txtNumeroDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroDocumentoActionPerformed(evt);
            }
        });
        jPanel2.add(txtNumeroDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 100, 30));

        jLabel3.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel3.setText("Numero Documento");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 100, 30));

        jLabel5.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel5.setText("Apellido");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 100, 30));

        jLabel9.setFont(new java.awt.Font("Candara", 0, 18)); // NOI18N
        jLabel9.setText("Nombre");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        // TODO add your handling code here:
        ControlDatos cd = new ControlDatos();
        String NOMBRE = txtNombre.getText();
        String APELLIDO = txtApellido.getText();
        String NUMERO_DOCUMENTO = txtNumeroDocumento.getText();
        cd.InsertEstudiantes(NOMBRE, APELLIDO, NUMERO_DOCUMENTO);
        JOptionPane.showMessageDialog(null, "Registro Exitoso.");
        

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        // TODO add your handling code here:

        new Administrador().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void txtNumeroDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroDocumentoActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEstudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEstudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnregresar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNumeroDocumento;
    // End of variables declaration//GEN-END:variables
}
