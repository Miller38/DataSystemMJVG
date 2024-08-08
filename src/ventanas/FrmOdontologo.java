package ventanas;

import controlador.Ctrl_Odontologo;
import java.awt.Color;
import java.awt.Image;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Odontologo;

/**
 *
 * @author Miller
 */
public class FrmOdontologo extends javax.swing.JFrame {

    // private FileInputStream fis;
    //private int longitudBytes;
    public FrmOdontologo() {
        
         setUndecorated(true);
        
        initComponents();
        
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
        jLabel_usuario.setText("Usuario: " + nombreUsuario);

        this.setSize(722, 501);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
          // -------------------------------------Colocar imagen de fondo cabecera----------------------------------------// 
        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
        ImageIcon wallpaper_cabecera = new ImageIcon("src/images/fondo3.jpg");
// Escala la imagen a las dimensiones actuales del jLabel_Wallpaper
// Obtiene la imagen del ImageIcon
        Icon icono_ = new ImageIcon(
                wallpaper_cabecera.getImage().getScaledInstance( // Escala la imagen
                        jLabel_cabecera.getWidth(), // Ancho actual del jLabel_Wallpaper
                        jLabel_cabecera.getHeight(), // Alto actual del jLabel_Wallpaper
                        Image.SCALE_DEFAULT // Algoritmo de escalado (por defecto)
                )
        );
// Establece el nuevo icono (imagen escalada) en el jLabel_Wallpaper
        jLabel_cabecera.setIcon(icono_);
// Vuelve a pintar el contenedor para asegurarse de que la imagen se renderice correctamente
        this.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ciudad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_pais = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_especialidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_numero_licencia = new javax.swing.JTextField();
        Cmb_genero = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel_foto = new javax.swing.JLabel();
        Btn_guardar = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_identificacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Cmb_tipo_identificacion = new javax.swing.JComboBox<>();
        jLabel_titulo = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        Btn_cerrar = new javax.swing.JButton();
        Btn_minimizar = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        txt_fecha_nacimiento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Apellido :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Direccion :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ciudad :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        txt_ciudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ciudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ciudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 160, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Pais :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        txt_pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_pais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Especialidad :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        txt_especialidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_especialidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_especialidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 140, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de nacimiento :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Numero de licencia :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        txt_numero_licencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_numero_licencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_licencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_numero_licencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 140, -1));

        Cmb_genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Masculino", "Femenino", "Otro" }));
        getContentPane().add(Cmb_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Telefono");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 130, -1));

        jLabel_foto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 130, 110));

        Btn_guardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_guardar.setText("Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, -1, -1));

        Btn_regresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_regresar.setText("Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("editar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setText("Eliminar");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setText("Ver odontologos");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Identificacion :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        txt_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_identificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_identificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 130, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Buscar");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 130, -1));

        Cmb_tipo_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_tipo_identificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula", "Tarjeta", "pasaporte" }));
        getContentPane().add(Cmb_tipo_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 140, -1));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Gestionar Odontologos");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));
        getContentPane().add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 160, 20));

        Btn_cerrar.setText("x");
        Btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cerrarMouseExited(evt);
            }
        });
        Btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        Btn_minimizar.setText("-");
        Btn_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_minimizarMouseExited(evt);
            }
        });
        Btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_minimizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 50));

        txt_fecha_nacimiento.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txt_fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        guardarOdontologo();
    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        this.dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_minimizarActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarActionPerformed

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        this.dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseEntered
        Btn_cerrar.setBackground(new Color(255, 51, 51));
        Btn_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrarMouseEntered

    private void Btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseExited
        Btn_cerrar.setBackground(Color.white);
        Btn_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrarMouseExited

    private void Btn_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseEntered
         Btn_minimizar.setBackground(new Color(0, 153, 204));
        Btn_minimizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_minimizarMouseEntered

    private void Btn_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseExited
        Btn_minimizar.setBackground(Color.white);
        Btn_minimizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_minimizarMouseExited

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
            java.util.logging.Logger.getLogger(FrmOdontologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOdontologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOdontologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOdontologo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmOdontologo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JComboBox<String> Cmb_genero;
    private javax.swing.JComboBox<String> Cmb_tipo_identificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_foto;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_especialidad;
    private com.toedter.calendar.JDateChooser txt_fecha_nacimiento;
    private javax.swing.JTextField txt_identificacion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_numero_licencia;
    private javax.swing.JTextField txt_pais;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Métodos de validación 
//----------------------------------------------------------------------------------------------------------------------//
// Método para validar el teléfono
    private boolean validarTelefono(String telefono) {
        // Ejemplo: validación simple para números de 10 dígitos
        return telefono.matches("\\d{10}");
    }

    // Método para validar el correo electrónico
    private boolean validarCorreo(String email) {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Método para validar todos los campos
    private boolean validarCampos() {
        if (txt_nombre.getText().trim().isEmpty()
                || txt_apellido.getText().trim().isEmpty()
                || txt_telefono.getText().trim().isEmpty()
                || txt_direccion.getText().trim().isEmpty()
                || txt_ciudad.getText().trim().isEmpty()
                || txt_pais.getText().trim().isEmpty()
                || txt_email.getText().trim().isEmpty()
                || txt_identificacion.getText().trim().isEmpty()
                || txt_especialidad.getText().trim().isEmpty()
                || txt_numero_licencia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.");
            return false;
        }

        if (Cmb_genero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el genero.");
            return false;
        }

        if (Cmb_tipo_identificacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el genero.");
            return false;
        }

        // Validar teléfono
        String telefono = txt_telefono.getText().trim();
        if (!validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener 10 dígitos.");
            return false;
        }

        // Validar correo electrónico
        String correo = txt_email.getText().trim();
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(this, "El correo electrónico no tiene un formato válido.");
            return false;
        }

        // Validar fecha de nacimiento
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        if (fecha_nacimiento == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de nacimiento válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar imagen
//        if (fis == null) {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen.");
//            return false;
//        }
        return true;
    }

    // Método para limpiar campos
    private void limpiarCampos() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_direccion.setText("");
        txt_ciudad.setText("");
        txt_pais.setText("");
        txt_telefono.setText("");
        txt_email.setText("");
        txt_especialidad.setText("");
        txt_numero_licencia.setText("");

        // Limpiar el JDateChooser
        txt_fecha_nacimiento.setDate(null);
        // jLabel_foto.setText("");

        Cmb_genero.setSelectedIndex(0);

        //fis = null; // Resetear FileInputStream
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para guardar un odontologo
//----------------------------------------------------------------------------------------------------------------------//  
    private void guardarOdontologo() {
        Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();
        Odontologo odontologo = new Odontologo();

        if (!validarCampos()) {
            return;
        }

        odontologo.setNombre_odontologo(txt_nombre.getText().trim());
        odontologo.setApellido(txt_apellido.getText().trim());
        odontologo.setDireccion(txt_direccion.getText().trim());
        odontologo.setCiudad(txt_ciudad.getText().trim());
        odontologo.setPais(txt_pais.getText().trim());
        odontologo.setEspecialidad(txt_especialidad.getText().trim());
        odontologo.setTelefono(txt_telefono.getText().trim());
        odontologo.setEmail(txt_email.getText().trim());
        odontologo.setIdentificacion(txt_identificacion.getText().trim());

        // Convertir la fecha de nacimiento desde el texto
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Obtener la fecha de nacimiento directamente desde el JDateChooser
        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        odontologo.setFecha_nacimiento(fecha_nacimiento);

        odontologo.setTipo_identificacion((String) Cmb_genero.getSelectedItem());
        odontologo.setGenero((String) Cmb_genero.getSelectedItem());
        odontologo.setNumero_licencia(txt_numero_licencia.getText().trim());

        // Verificar si el odontologo ya está registrado
        // guardamos el odontologo
        if (controlOdontologo.guardarOdontologo(odontologo)) {
            JOptionPane.showMessageDialog(this, "guardado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de guardar
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
    }
}
