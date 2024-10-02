package Vista;
import Control.*;
import Modelo.*;
import javax.swing.JOptionPane;
public class Registro extends javax.swing.JFrame {
    public Registro() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Dcentidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Rzsocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Droem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Contacto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbtipo = new javax.swing.JComboBox<>();
        PW = new javax.swing.JPasswordField();
        btregistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 153, 153)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrarse");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 210, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Tipo de Cuenta");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 100, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Ruc/Dni");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 70, 20));

        Dcentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DcentidadActionPerformed(evt);
            }
        });
        jPanel1.add(Dcentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 160, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Nombre");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 70, 20));

        Rzsocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RzsocialActionPerformed(evt);
            }
        });
        jPanel1.add(Rzsocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 160, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Direccion/Email");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 100, 20));

        Droem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DroemActionPerformed(evt);
            }
        });
        jPanel1.add(Droem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 160, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Contacto");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 100, 20));

        Contacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactoActionPerformed(evt);
            }
        });
        jPanel1.add(Contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Contraseña");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 100, 20));

        cbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresarial", "Personal" }));
        cbtipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipoActionPerformed(evt);
            }
        });
        jPanel1.add(cbtipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 160, -1));

        PW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PWActionPerformed(evt);
            }
        });
        jPanel1.add(PW, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 160, -1));

        btregistro.setText("Registrarse");
        btregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btregistroActionPerformed(evt);
            }
        });
        jPanel1.add(btregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RzsocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RzsocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RzsocialActionPerformed

    private void DroemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DroemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DroemActionPerformed

    private void ContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContactoActionPerformed

    private void cbtipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtipoActionPerformed

    private void DcentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DcentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DcentidadActionPerformed

    private void PWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PWActionPerformed

    private void btregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btregistroActionPerformed
        int dcentidad= Integer.parseInt(Dcentidad.getText());
        String rzsocial= Rzsocial.getText();
        String doe=Droem.getText();
        int contacto=Integer.parseInt(Contacto.getText());
        char[] pass=PW.getPassword();
        String tipo=(String) cbtipo.getSelectedItem();
        
        if (rzsocial.isEmpty() || doe.isEmpty() || pass.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(tipo.equals("Empresarial")){
            ControlEmpresa c= new ControlEmpresa();
            c.CrearEmpresa(dcentidad, rzsocial,0, doe, contacto, pass, tipo);
        }
        if(tipo.equals("Personal")){
            ControlPersona c=new ControlPersona();
            c.CrearPersona(dcentidad, rzsocial, 0, doe, contacto, pass, tipo);         
        }
    }//GEN-LAST:event_btregistroActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contacto;
    private javax.swing.JTextField Dcentidad;
    private javax.swing.JTextField Droem;
    private javax.swing.JPasswordField PW;
    private javax.swing.JTextField Rzsocial;
    private javax.swing.JButton btregistro;
    private javax.swing.JComboBox<String> cbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
