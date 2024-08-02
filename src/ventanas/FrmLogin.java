
package ventanas;

import servicios.TextPrompt;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import controlador.Ctrl_Usuario;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Miller
 */
public class FrmLogin extends javax.swing.JFrame {

   
    public FrmLogin() {
        initComponents();
        this.setSize(400,550);
        this.setResizable(false);
        this.setTitle("Acceso al sistema");
        this.setLocationRelativeTo(null);
        
        TextPrompt usuaPrompt = new TextPrompt("   Ingrese su nombre de usuario." ,txt_username);
        TextPrompt  passwPrompt= new TextPrompt("         Ingrese su contraseña." ,txt_password);
        
          // Hace visible el campo de texto para la contraseña oculta
        txt_password.setVisible(true);
        // Hace invisible el campo de texto para la contraseña visible
        txt_password_visible.setVisible(false);
        
        
    
       // cambiar fondo Jframe 
        ImageIcon  wallpaper = new ImageIcon("src/images/bg-gradiente.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(jLabel_Wallpaper.getWidth(),
                        jLabel_Wallpaper.getHeight(),Image.SCALE_DEFAULT));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        // imagen logo
        ImageIcon wallpaper_logo = new ImageIcon("src/images/logoUser.png");
        Icon icono_logo = new ImageIcon(wallpaper_logo.getImage().getScaledInstance(jLabel_Logo.getWidth(),
                        jLabel_Logo.getHeight(), Image.SCALE_DEFAULT));
        jLabel_Logo.setIcon(icono_logo);
        this.repaint();
    }
    
    // cambiar icono del jframe
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/favicon.png"));
        return retValue;
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel_Logo = new javax.swing.JLabel();
        Btn_acceder = new javax.swing.JButton();
        jLabel_footer = new javax.swing.JLabel();
        check_ver_clave = new javax.swing.JCheckBox();
        txt_password_visible = new javax.swing.JTextField();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 250, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 250, -1));
        getContentPane().add(jLabel_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 190, 210));

        Btn_acceder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Btn_acceder.setText("Acceder");
        Btn_acceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_accederActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_acceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 250, -1));

        jLabel_footer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel_footer.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_footer.setText("Creado por Miller ");
        getContentPane().add(jLabel_footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 110, -1));

        check_ver_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_ver_claveActionPerformed(evt);
            }
        });
        getContentPane().add(check_ver_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 20, -1));

        txt_password_visible.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_password_visible.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_password_visible, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 250, -1));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_accederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_accederActionPerformed
      this.login();
    }//GEN-LAST:event_Btn_accederActionPerformed

    private void check_ver_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_ver_claveActionPerformed
           // Verifica si el checkbox para mostrar la contraseña está seleccionado
           if(check_ver_clave.isSelected()){
                 // Si el checkbox está seleccionado, se debe mostrar la contraseña en formato de texto
        // Obtiene la contraseña ingresada en el campo de contraseña (oculto) como un arreglo de caracteres
        String pass = new String(txt_password.getPassword());
        // Establece la contraseña obtenida en el campo de texto visible para mostrarla
        txt_password_visible.setText(pass);
         // Oculta el campo de contraseña (oculto) ya que ahora se mostrará el campo de texto visible
         txt_password.setVisible(false);
         // Muestra el campo de texto visible que contiene la contraseña en formato de texto
         txt_password_visible.setVisible(true);
           } else {
                // Si el checkbox no está seleccionado, se debe ocultar la contraseña en formato de texto
        // Obtiene la contraseña ingresada en el campo de texto visible (que es la contraseña en formato de texto)
        String passwordIngresado = txt_password_visible.getText().trim();
         // Establece la contraseña obtenida en el campo de contraseña (oculto) para que se oculte nuevamente
         txt_password.setText(passwordIngresado);
          // Muestra el campo de contraseña (oculto) para que la contraseña sea visible solo en formato oculto
          txt_password.setVisible(true);
           // Oculta el campo de texto visible que contiene la contraseña en formato de texto
           txt_password_visible.setVisible(false);
           }
    }//GEN-LAST:event_check_ver_claveActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_acceder;
    private javax.swing.JCheckBox check_ver_clave;
    private javax.swing.JLabel jLabel_Logo;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_footer;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_password_visible;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

  /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Metodo para loguearse
    * ------------------------------------------------------------------------------------------------------------------------
     */
 private void login() { // Método para manejar el inicio de sesión
    if (!txt_username.getText().isEmpty() && !txt_password.getText().isEmpty()) { // Verifica que los campos de usuario y contraseña no estén vacíos
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario(); // Crea una instancia de Ctrl_Usuario para manejar la autenticación
        Usuario usuario = new Usuario(); // Crea una instancia de Usuario para almacenar los datos ingresados

        usuario.setUsername(txt_username.getText().trim()); // Asigna el nombre de usuario ingresado al objeto Usuario, eliminando espacios en blanco al principio y al final
        usuario.setPassword(txt_password.getText().trim()); // Asigna la contraseña ingresada al objeto Usuario, eliminando espacios en blanco al principio y al final

        // Obtén el usuario autenticado
        Usuario usuarioAutenticado = controlUsuario.loginUser(usuario); // Llama al método loginUser() para autenticar al usuario y obtener el usuario autenticado

        if (usuarioAutenticado != null && "Activo".equalsIgnoreCase(usuarioAutenticado.getEstatus())) { // Verifica si el usuario autenticado no es nulo y si su estatus es "Activo"
            // Abre la ventana correspondiente según el tipo de usuario
            switch (usuarioAutenticado.getTipo_nivel()) { // Dependiendo del tipo de usuario, abre la ventana correspondiente
                case "Administrador": // Si el tipo de usuario es "Administrador"
                    FrmAdmin admin = new FrmAdmin(); // Crea una instancia de la ventana Administrador
                    admin.setVisible(true); // Hace visible la ventana de Administrador
                    admin.setResizable(false); // Desactiva la opción de redimensionar la ventana
                    admin.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                    break;
                case "Auxiliar": // Si el tipo de usuario es "Capturista"
                    FrmMenu frmMenu = new FrmMenu(); // Crea una instancia de la ventana Capturista
                    frmMenu.setVisible(true); // Hace visible la ventana de Capturista
                    frmMenu.setResizable(false); // Desactiva la opción de redimensionar la ventana
                    frmMenu.setLocationRelativeTo(null); // Centra la ventana en la pantalla
                    break;
//              
                default: // Si el tipo de usuario es desconocido
                    JOptionPane.showMessageDialog(this, "Tipo de usuario desconocido.", "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error
                    break;
            }
            this.setVisible(false); // Oculta la ventana actual
            dispose(); // Cierra la ventana actual
        } else {
            JOptionPane.showMessageDialog(this, "Datos de acceso incorrectos o cuenta inactiva.", "Error", JOptionPane.ERROR_MESSAGE); // Muestra un mensaje de error si la autenticación falla o la cuenta está inactiva
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debes completar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE); // Muestra un mensaje de advertencia si los campos están vacíos
    }
}
 
 
}
