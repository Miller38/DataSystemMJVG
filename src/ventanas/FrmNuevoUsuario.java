package ventanas;

import controlador.Ctrl_Usuario;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.SQLException; // Importación de SQLException
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author Miller
 */
public class FrmNuevoUsuario extends javax.swing.JFrame {

      private FileInputStream fis;
    private int longitudBytes;
    
    public FrmNuevoUsuario() {
        
        setUndecorated(true); 
        
        initComponents();
        
        this.setSize(711, 528);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
                 /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Colocar imagen de fondo
    * ------------------------------------------------------------------------------------------------------------------------
         */
        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
        ImageIcon wallpaper = new ImageIcon("src/images/bg-gradiente.jpg");
        // Escala la imagen a las dimensiones actuales del jLabel_Wallpaper
        // Obtiene la imagen del ImageIcon
        Icon icono = new ImageIcon(
                wallpaper.getImage().getScaledInstance( // Escala la imagen
                        jLabel_Wallpaper.getWidth(), // Ancho actual del jLabel_Wallpaper
                        jLabel_Wallpaper.getHeight(), // Alto actual del jLabel_Wallpaper
                        Image.SCALE_DEFAULT // Algoritmo de escalado (por defecto)
                )
        );
        // Establece el nuevo icono (imagen escalada) en el jLabel_Wallpaper
        jLabel_Wallpaper.setIcon(icono);
        // Vuelve a pintar el contenedor para asegurarse de que la imagen se renderice correctamente
        this.repaint();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_registrado_por = new javax.swing.JTextField();
        txt_fecha_creacion = new javax.swing.JTextField();
        txt_ultima_sesion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel_cabecera = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_id_usuario = new javax.swing.JTextField();
        Btn_buscar = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        Btn_guardar = new javax.swing.JButton();
        Btn_actualizar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_ver_usuarios = new javax.swing.JButton();
        Cmb_tipo_nivel = new javax.swing.JComboBox<>();
        Cmb_estatus = new javax.swing.JComboBox<>();
        jLabel_foto = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Email :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Telefono :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Username :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Password :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de Nivel :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Estatus :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Registrado por :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de creacion :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ultima sesion :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nombreMouseExited(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));

        txt_email.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_emailMouseExited(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 190, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseExited(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 170, -1));

        txt_username.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_usernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_usernameMouseExited(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 170, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_passwordMouseExited(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 170, -1));

        txt_registrado_por.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_registrado_por.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registrado_por.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_registrado_porMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_registrado_porMouseExited(evt);
            }
        });
        getContentPane().add(txt_registrado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 140, -1));

        txt_fecha_creacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_fecha_creacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha_creacion.setEnabled(false);
        getContentPane().add(txt_fecha_creacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 140, -1));

        txt_ultima_sesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_ultima_sesion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultima_sesion.setEnabled(false);
        getContentPane().add(txt_ultima_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gestionar Usuarios");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("ID :");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 30, 20));

        txt_id_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_id_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_id_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 80, -1));

        Btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/papel.png"))); // NOI18N
        Btn_buscar.setText("  Buscar");
        Btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_buscarMouseExited(evt);
            }
        });
        Btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, -1));

        Btn_regresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha.png"))); // NOI18N
        Btn_regresar.setText("  Regresar");
        Btn_regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_regresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_regresarMouseExited(evt);
            }
        });
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 120, -1));

        Btn_guardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-el-archivo.png"))); // NOI18N
        Btn_guardar.setText("  Guardar");
        Btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_guardarMouseExited(evt);
            }
        });
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 110, -1));

        Btn_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar-flecha.png"))); // NOI18N
        Btn_actualizar.setText("  Editar");
        Btn_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_actualizarMouseExited(evt);
            }
        });
        Btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 100, -1));

        Btn_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        Btn_eliminar.setText("  Eliminar");
        Btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_eliminarMouseExited(evt);
            }
        });
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 110, -1));

        Btn_ver_usuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_ver_usuarios.setText("Ver usuarios");
        Btn_ver_usuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_ver_usuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_ver_usuariosMouseExited(evt);
            }
        });
        Btn_ver_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ver_usuariosActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_ver_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 110, -1));

        Cmb_tipo_nivel.setBackground(new java.awt.Color(255, 255, 255));
        Cmb_tipo_nivel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cmb_tipo_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccion", "Administrador", "Auxiliar" }));
        getContentPane().add(Cmb_tipo_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 170, -1));

        Cmb_estatus.setBackground(new java.awt.Color(255, 255, 255));
        Cmb_estatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estatus", "Activo", "Inactivo" }));
        getContentPane().add(Cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 170, -1));

        jLabel_foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_fotoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 170, 140));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        guardarUsuario();
    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_actualizarActionPerformed
        actualizarUsuario();
    }//GEN-LAST:event_Btn_actualizarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
        eliminarUsuario();
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        buscarUsuarioPorID();
    }//GEN-LAST:event_Btn_buscarActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_ver_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosActionPerformed
       FrmGestionarUsuarios frmGestionarUsuarios =  new FrmGestionarUsuarios();
       frmGestionarUsuarios.setVisible(true);
    }//GEN-LAST:event_Btn_ver_usuariosActionPerformed

    private void txt_nombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseEntered
         txt_nombre.setBackground(Color.black);
        txt_nombre.setForeground(Color.white);
    }//GEN-LAST:event_txt_nombreMouseEntered

    private void txt_nombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseExited
       txt_nombre.setBackground(Color.white);
        txt_nombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_nombreMouseExited

    private void Btn_regresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_regresarMouseEntered
        Btn_regresar.setBackground(new Color(0, 153, 204));
       Btn_regresar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_regresarMouseEntered

    private void Btn_regresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_regresarMouseExited
        Btn_regresar.setBackground(Color.white);
        Btn_regresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_regresarMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_guardar.setBackground(new Color(0, 153, 204));
       Btn_guardar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
          Btn_guardar.setBackground(Color.white);
        Btn_guardar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actualizarMouseEntered
       Btn_actualizar.setBackground(new Color(0, 153, 204));
       Btn_actualizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_actualizarMouseEntered

    private void Btn_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actualizarMouseExited
          Btn_actualizar.setBackground(Color.white);
        Btn_actualizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_actualizarMouseExited

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_eliminar.setBackground(new Color(0, 153, 204));
       Btn_eliminar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
          Btn_eliminar.setBackground(Color.white);
        Btn_eliminar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_ver_usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosMouseEntered
        Btn_ver_usuarios.setBackground(new Color(0, 153, 204));
       Btn_ver_usuarios.setForeground(Color.white);
    }//GEN-LAST:event_Btn_ver_usuariosMouseEntered

    private void Btn_ver_usuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosMouseExited
          Btn_ver_usuarios.setBackground(Color.white);
        Btn_ver_usuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_ver_usuariosMouseExited

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_buscar.setBackground(new Color(0, 153, 204));
       Btn_buscar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
          Btn_buscar.setBackground(Color.white);
        Btn_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void txt_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseEntered
         txt_email.setBackground(Color.black);
        txt_email.setForeground(Color.white);
    }//GEN-LAST:event_txt_emailMouseEntered

    private void txt_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseExited
        txt_email.setBackground(Color.white);
        txt_email.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_emailMouseExited

    private void txt_telefonoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseEntered
         txt_telefono.setBackground(Color.black);
        txt_telefono.setForeground(Color.white);
    }//GEN-LAST:event_txt_telefonoMouseEntered

    private void txt_telefonoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseExited
        txt_telefono.setBackground(Color.white);
        txt_telefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_telefonoMouseExited

    private void txt_usernameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseEntered
        txt_username.setBackground(Color.black);
        txt_username.setForeground(Color.white);
    }//GEN-LAST:event_txt_usernameMouseEntered

    private void txt_usernameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usernameMouseExited
        txt_username.setBackground(Color.white);
        txt_username.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_usernameMouseExited

    private void txt_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseEntered
         txt_password.setBackground(Color.black);
        txt_password.setForeground(Color.white);
    }//GEN-LAST:event_txt_passwordMouseEntered

    private void txt_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseExited
        txt_password.setBackground(Color.white);
        txt_password.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_passwordMouseExited

    private void txt_registrado_porMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_registrado_porMouseEntered
         txt_registrado_por.setBackground(new Color(52, 52, 52));
        txt_registrado_por.setForeground(Color.white);
    }//GEN-LAST:event_txt_registrado_porMouseEntered

    private void txt_registrado_porMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_registrado_porMouseExited
        txt_registrado_por.setBackground(Color.white);
        txt_registrado_por.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_registrado_porMouseExited

    private void jLabel_fotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_fotoMouseClicked
        /// Crea un objeto JFileChooser para abrir un diálogo de selección de archivos
    JFileChooser archivo = new JFileChooser();
    // Configura el JFileChooser para permitir solo la selección de archivos (no directorios)
    archivo.setFileSelectionMode(JFileChooser.FILES_ONLY);
    // Muestra el cuadro de diálogo de apertura de archivos y almacena el resultado (aceptar o cancelar)
    int estado = archivo.showOpenDialog(null);
    // Verifica si el usuario seleccionó un archivo (presionó "Aceptar")
    if (estado == JFileChooser.APPROVE_OPTION) {
        try {
            // Obtiene el archivo seleccionado
            File file = archivo.getSelectedFile();
            // Crea un FileInputStream para leer el archivo seleccionado
            fis = new FileInputStream(file);
            // Almacena la longitud del archivo seleccionado en bytes
            this.longitudBytes = (int) file.length();
            // Lee la imagen del archivo seleccionado
            Image icono = ImageIO.read(file);
            // Escala la imagen a las dimensiones del jLabel_foto
            Image scaledIcono = icono.getScaledInstance(jLabel_foto.getWidth(), jLabel_foto.getHeight(), Image.SCALE_SMOOTH);
            // Establece la imagen escalada como el ícono del jLabel_foto
            jLabel_foto.setIcon(new ImageIcon(scaledIcono));
            // Asigna la ruta del archivo a txt_ruta para referencia futura
           
        } catch (FileNotFoundException e) {
            // Maneja la excepción si el archivo no se encuentra
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            // Maneja la excepción si ocurre un error de entrada/salida al leer el archivo
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jLabel_fotoMouseClicked

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
            java.util.logging.Logger.getLogger(FrmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevoUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_actualizar;
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton Btn_ver_usuarios;
    private javax.swing.JComboBox<String> Cmb_estatus;
    private javax.swing.JComboBox<String> Cmb_tipo_nivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_foto;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fecha_creacion;
    private javax.swing.JTextField txt_id_usuario;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_registrado_por;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ultima_sesion;
    private javax.swing.JTextField txt_username;
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
                || txt_email.getText().trim().isEmpty()
                || txt_telefono.getText().trim().isEmpty()
                || txt_username.getText().trim().isEmpty()
                || txt_password.getText().trim().isEmpty()
                || txt_registrado_por.getText().trim().isEmpty()
                || Cmb_tipo_nivel.getSelectedItem() == null || Cmb_tipo_nivel.getSelectedItem().toString().equals("Seleccione el nivel")
                || Cmb_estatus.getSelectedItem() == null || Cmb_estatus.getSelectedItem().toString().equals("Seleccione el estatus")) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.");
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
        return true;
    }

// Método para limpiar campos
    private void limpiarCampos() {
        txt_id_usuario.setText("");
        txt_nombre.setText("");
        txt_email.setText("");
        txt_telefono.setText("");
        txt_username.setText("");
        txt_password.setText("");
        txt_registrado_por.setText("");
        Cmb_tipo_nivel.setSelectedIndex(0);
        Cmb_estatus.setSelectedIndex(0);
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para guardar un usuario
//----------------------------------------------------------------------------------------------------------------------//    
    private void guardarUsuario() {
    // llamamos al controlador usuario
    Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
    // llamamos la clase Usuario
    Usuario usuario = new Usuario();

    // validamos que los campos no estén vacíos y se haya seleccionado todo
    if (!validarCampos()) {
        return;
    }

    // verificar si el usuario ya existe en la base de datos
    String username = txt_username.getText().trim();
    if (usuarioExiste(username)) {
        JOptionPane.showMessageDialog(this, "El nombre de usuario ya existe. Por favor, elija otro.");
        return; // Salir del método si el usuario ya existe
    }

    // ahora asignamos lo que el usuario ingresó al usuario
    usuario.setNombre_usuario(txt_nombre.getText().trim());
    usuario.setEmail(txt_email.getText().trim());
    usuario.setTelefono(txt_telefono.getText().trim());
    usuario.setUsername(username);
    usuario.setPassword(txt_password.getText().trim());
    usuario.setTipo_nivel((String) Cmb_tipo_nivel.getSelectedItem());
    usuario.setEstatus((String) Cmb_estatus.getSelectedItem());
    usuario.setRegistrado_por(txt_registrado_por.getText().trim());
    
    // Convertir la imagen a un array de bytes
    byte[] imagenBytes = null;
    if (fis != null) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            imagenBytes = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
    usuario.setImagen(imagenBytes); // Asignar imagen a Usuario


    if (controlUsuario.guardarUsuario(usuario)) {
        JOptionPane.showMessageDialog(this, "Usuario guardado exitosamente.");
        limpiarCampos(); // Limpiar los campos después de guardar
    } else {
        JOptionPane.showMessageDialog(this, "Error al guardar el usuario.");
    }
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para actualizar un usuario
//----------------------------------------------------------------------------------------------------------------------//
    private void actualizarUsuario() {
        // llamamos al controlador usuario
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
        // llamamos la clase Usuario
        Usuario usuario = new Usuario();

        // validamos que los campos no estén vacíos y se haya seleccionado todo
        if (!validarCampos()) {
            return;
        }

        // ahora asignamos lo que el usuario ingresó al usuario
        usuario.setId_usuario(Integer.parseInt(txt_id_usuario.getText().trim())); // Asignar el ID del usuario
        usuario.setNombre_usuario(txt_nombre.getText().trim());
        usuario.setEmail(txt_email.getText().trim());
        usuario.setTelefono(txt_telefono.getText().trim());
        usuario.setUsername(txt_username.getText().trim());
        usuario.setPassword(txt_password.getText().trim());
        usuario.setTipo_nivel((String) Cmb_tipo_nivel.getSelectedItem());
        usuario.setEstatus((String) Cmb_estatus.getSelectedItem());
        usuario.setRegistrado_por(txt_registrado_por.getText().trim());
        

        if (controlUsuario.actualizarUsuario(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de actualizar
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario.");
        }
    }

 //----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para eliminar un usuario
//----------------------------------------------------------------------------------------------------------------------//
private void eliminarUsuario() {
    // llamamos al controlador usuario
    Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
    int idUsuario = Integer.parseInt(txt_id_usuario.getText().trim());

    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        if (controlUsuario.eliminarUsuario(idUsuario)) {
            JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de eliminar
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.");
        }
    }
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para buscar un usuario por ID
//----------------------------------------------------------------------------------------------------------------------//
private void buscarUsuarioPorID() {
    // llamamos al controlador usuario
    Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
    int idUsuario = Integer.parseInt(txt_id_usuario.getText().trim());

    Usuario usuario = controlUsuario.obtenerUsuarioPorID(idUsuario);
    if (usuario != null) {
        txt_nombre.setText(usuario.getNombre_usuario());
        txt_email.setText(usuario.getEmail());
        txt_telefono.setText(usuario.getTelefono());
        txt_username.setText(usuario.getUsername());
        txt_password.setText(usuario.getPassword()); // Nota: generalmente no se muestra la contraseña en un campo de texto
        Cmb_tipo_nivel.setSelectedItem(usuario.getTipo_nivel());
        Cmb_estatus.setSelectedItem(usuario.getEstatus());
        txt_registrado_por.setText(usuario.getRegistrado_por());
        
        // Mostrar la imagen en jLabel_foto
        mostrarImagen(usuario.getImagen());
        
    } else {
        JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
    }
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                    Método para comparar si el usuario existe
//----------------------------------------------------------------------------------------------------------------------//
private boolean usuarioExiste(String username) {
    Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
    return controlUsuario.existeUsuario(username);
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                    Método para mostrar laimagen del usuario
//----------------------------------------------------------------------------------------------------------------------//


private void mostrarImagen(byte[] imagenBytes) {
    if (imagenBytes != null) {
        try {
            // Convertir el array de bytes a un objeto Image
            ByteArrayInputStream bais = new ByteArrayInputStream(imagenBytes);
            Image imagen = ImageIO.read(bais);

            // Escalar la imagen a las dimensiones del jLabel_foto
            Image scaledImagen = imagen.getScaledInstance(jLabel_foto.getWidth(), jLabel_foto.getHeight(), Image.SCALE_SMOOTH);

            // Establecer la imagen escalada como el ícono del jLabel_foto
            jLabel_foto.setIcon(new ImageIcon(scaledImagen));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        jLabel_foto.setIcon(null); // Si no hay imagen, eliminar el ícono
    }
}

}
