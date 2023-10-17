
package resto.Vistas;

import packLoginete.Loginetee;
import packLoginete.LogineteeData;





public class FrmLogin extends javax.swing.JFrame {
            Loginetee lg= new Loginetee();
            LogineteeData login= new LogineteeData();
   
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void validar(){
        String user = jtfUsuario.getText();
        String pass = String.valueOf(jtfPass.getText());
        if(!"".equals(user) || !"".equals(pass)){
//            login lg= new login();
//            LogineteData login= new LogineteData(); estos 2 renglones los meti en linea 8 y 9
           // lg = login.log(user, pass);
            if(lg.getUser() !=null && lg.getPassword() != null){
                    
                    
                //Sistema sis=new Sistema();
                //sis.setVisible (true);
                dispose();
                
            }
            
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlIconLogin = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jlPass = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jtfPass = new javax.swing.JPasswordField();
        jbIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));

        jlIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login3 (3).jpg"))); // NOI18N
        jlIconLogin.setText("jLabel2");

        jlUsuario.setText("Usuario");

        jlPass.setText("Contraseña");

        jbIngresar.setText("INGRESAR");
        jbIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jbIngresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jlIconLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlPass)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jlUsuario)
                            .addComponent(jtfPass))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jlIconLogin)
                .addGap(18, 18, 18)
                .addComponent(jlUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jlPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbIngresar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 190, 260));

        jLabel1.setBackground(new java.awt.Color(102, 102, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resto4.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 370, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIngresarActionPerformed
        // TODO add your handling code here:
        
        validar();
    }//GEN-LAST:event_jbIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbIngresar;
    private javax.swing.JLabel jlIconLogin;
    private javax.swing.JLabel jlPass;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JPasswordField jtfPass;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
