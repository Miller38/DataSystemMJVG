package ventanas;

import conexion.Conexion;
import controlador.Ctrl_Paciente;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import modelo.Paciente;

/**
 *
 * @author Miller
 */
public class FrmPacientes extends javax.swing.JFrame {

    private FileInputStream fis;
    private int longitudBytes;
    
    public FrmPacientes() {
        
        setUndecorated(true);
        
        initComponents();
        
        // Obtiene el nombre de usuario que ha iniciado sesión desde el formulario de login
         String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();        
         jLabel_usuario.setText("Usuario: " + nombreUsuario);
        
        this.setTitle("Formulario de Paciente");
        this.setSize(752, 586);
        // cierra todos los procesos en segundo plano cuando se cierra lainterfaz
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        this.setLocationRelativeTo(null);
        
          /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Colocar imagen de fondo
    * ------------------------------------------------------------------------------------------------------------------------
         */
        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
//        ImageIcon wallpaper = new ImageIcon("src/images/bg-gradiente.jpg");
//        // Escala la imagen a las dimensiones actuales del jLabel_Wallpaper
//        // Obtiene la imagen del ImageIcon
//        Icon icono = new ImageIcon(
//                wallpaper.getImage().getScaledInstance( // Escala la imagen
//                        jLabel_Wallpaper.getWidth(), // Ancho actual del jLabel_Wallpaper
//                        jLabel_Wallpaper.getHeight(), // Alto actual del jLabel_Wallpaper
//                        Image.SCALE_DEFAULT // Algoritmo de escalado (por defecto)
//                )
//        );
//        // Establece el nuevo icono (imagen escalada) en el jLabel_Wallpaper
//        jLabel_Wallpaper.setIcon(icono);
//        // Vuelve a pintar el contenedor para asegurarse de que la imagen se renderice correctamente
//        this.repaint();

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

        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JTextField();
        txt_pais = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_fechaNacimiento = new javax.swing.JTextField();
        Cmb_genero = new javax.swing.JComboBox<>();
        Btn_guardar = new javax.swing.JButton();
        txt_email = new javax.swing.JTextField();
        txt_identificacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_foto = new javax.swing.JLabel();
        Btn_regresar = new javax.swing.JButton();
        Btn_actualizar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_consultar = new javax.swing.JButton();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Cmb_tipo_identificacion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Cmb_tipoSangre = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Cmb_estadoCivil = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txt_ocupacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 200, -1));

        txt_ciudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ciudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ciudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, -1));

        txt_pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_pais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paisActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 200, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, -1));

        txt_fechaNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_fechaNacimiento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fechaNacimiento.setToolTipText("Formato yyyy-mm-dd");
        txt_fechaNacimiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 180, -1));

        Cmb_genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Genero", "Masculino", "Femenino", "Otro" }));
        getContentPane().add(Cmb_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 180, -1));

        Btn_guardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guardar-el-archivo.png"))); // NOI18N
        Btn_guardar.setText("  Guardar");
        Btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 530, 110, -1));

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 180, -1));

        txt_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_identificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_identificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_identificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_identificacionActionPerformed(evt);
            }
        });
        getContentPane().add(txt_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 180, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Apellido :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Direccion :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ciudad :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Pais :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Telefono :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Identificacion :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Email :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Fecha de Nacimiento :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Genero :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        jLabel_foto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_fotoMouseClicked(evt);
            }
        });
        getContentPane().add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 190, 160));

        Btn_regresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha.png"))); // NOI18N
        Btn_regresar.setText("  Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        Btn_actualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/actualizar-flecha.png"))); // NOI18N
        Btn_actualizar.setText("  Editar");
        Btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_actualizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 530, -1, -1));

        Btn_eliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eliminar.png"))); // NOI18N
        Btn_eliminar.setText("  Eliminar");
        Btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, -1, -1));

        Btn_consultar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_consultar.setText("Buscar");
        Btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_consultarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 180, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Gestionar Pacientes");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 190, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("x");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("-");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 60));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Tipo de identificacion");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        Cmb_tipo_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_tipo_identificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cedula de ciudadania", "Tarjeta de identidad", "Pasaporte" }));
        getContentPane().add(Cmb_tipo_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 180, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Tipo de sangre :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        Cmb_tipoSangre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_tipoSangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RH", "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        getContentPane().add(Cmb_tipoSangre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 80, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Estado civil :");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, -1));

        Cmb_estadoCivil.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_estadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Solter@", "Casad@", "Divorciad@ Viud@", "Otro" }));
        getContentPane().add(Cmb_estadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 660, 100));

        txt_ocupacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ocupacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(txt_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Ocupacion :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        jLabel_Wallpaper.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        guardaPaciente();
    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
       this.dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
        
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void txt_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paisActionPerformed

    private void Btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_actualizarActionPerformed
      actualizaPaciente();
    }//GEN-LAST:event_Btn_actualizarActionPerformed

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
        eliminaPaciente();
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void txt_identificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_identificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_identificacionActionPerformed

    private void Btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_consultarActionPerformed
       consultaPaciente();
    }//GEN-LAST:event_Btn_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_actualizar;
    private javax.swing.JButton Btn_consultar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JComboBox<String> Cmb_estadoCivil;
    private javax.swing.JComboBox<String> Cmb_genero;
    private javax.swing.JComboBox<String> Cmb_tipoSangre;
    private javax.swing.JComboBox<String> Cmb_tipo_identificacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fechaNacimiento;
    private javax.swing.JTextField txt_identificacion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ocupacion;
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
                || txt_fechaNacimiento.getText().trim().isEmpty()                
                || txt_identificacion.getText().trim().isEmpty()
                || txt_ocupacion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.");
            return false;
        }

        // Validar selección de combobox
        if (Cmb_tipo_identificacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de identificacion.");
            return false;
        }        
         if (Cmb_genero.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el genero.");
            return false;
        }         
         if (Cmb_tipoSangre.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el genero.");
            return false;
        }         
         if (Cmb_estadoCivil.getSelectedIndex() == 0) {
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
        txt_fechaNacimiento.setText("");
        txt_identificacion.setText("");
        txt_ocupacion.setText("");
        jLabel_foto.setText("");
        Cmb_tipo_identificacion.setSelectedIndex(0);
        Cmb_genero.setSelectedIndex(0);
        Cmb_tipoSangre.setSelectedIndex(0);
        Cmb_estadoCivil.setSelectedIndex(0);
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para guardar un paciente
//----------------------------------------------------------------------------------------------------------------------//    
    private void guardaPaciente() {

        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        Paciente paciente = new Paciente();
        
        if(!validarCampos()){
            return;
        }

     // ahora asignamos lo que el usuario ingresó al paciente
     paciente.setNombre(txt_nombre.getText().trim());
     paciente.setApellido(txt_apellido.getText().trim());
     paciente.setDireccion(txt_direccion.getText().trim());
     paciente.setCiudad(txt_ciudad.getText().trim());
     paciente.setPais(txt_pais.getText().trim());
     paciente.setTelefono(txt_telefono.getText().trim());
     paciente.setEmail(txt_email.getText().trim());
    
 // Convertir la fecha de nacimiento desde el texto
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
        Date fechaNacimiento = formatter.parse(txt_fechaNacimiento.getText().trim());
        paciente.setFechaNacimiento(fechaNacimiento);
    } catch (ParseException ex) {
        JOptionPane.showMessageDialog(this, "Fecha de nacimiento no válida. Use el formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

   
     paciente.setGenero((String) Cmb_genero.getSelectedItem());
     paciente.setIdentificacion(txt_identificacion.getText().trim());
     paciente.setTipo_identificacion((String) Cmb_tipo_identificacion.getSelectedItem());
     paciente.setTipo_sangre((String) Cmb_tipoSangre.getSelectedItem());
     paciente.setEstado_civil((String) Cmb_estadoCivil.getSelectedItem());
     paciente.setOcupacion(txt_ocupacion.getText().trim());
     
     
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
        paciente.setImagen(imagenBytes); // Asignar imagen a Usuario

        
        // Verificar si el paciente ya está registrado
        if(controlPaciente.existePaciente(paciente.getIdentificacion())){
            JOptionPane.showMessageDialog(this, "El paciente con esta identificación ya está registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
        }
     
     if(controlPaciente.guardarPaciente(paciente)){
         JOptionPane.showMessageDialog(this, "Paciente guardado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de guardar
     } else{
          JOptionPane.showMessageDialog(this, "Error al guardar el Paciente.");
     }
     
    }
    
//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para actualizar el paciente
//----------------------------------------------------------------------------------------------------------------------//    
private void actualizaPaciente() {
        Paciente paciente = new Paciente();
        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();

        if (!validarCampos()) {
            return;
        }

        paciente.setNombre(txt_nombre.getText().trim());
        paciente.setApellido(txt_apellido.getText().trim());
        paciente.setDireccion(txt_direccion.getText().trim());
        paciente.setCiudad(txt_ciudad.getText().trim());
        paciente.setPais(txt_pais.getText().trim());
        paciente.setTelefono(txt_telefono.getText().trim());
        paciente.setEmail(txt_email.getText().trim());

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNacimiento = formatter.parse(txt_fechaNacimiento.getText().trim());
            paciente.setFechaNacimiento(fechaNacimiento);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Fecha de nacimiento no válida. Use el formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        paciente.setGenero((String) Cmb_genero.getSelectedItem());
        paciente.setIdentificacion(txt_identificacion.getText().trim());
        paciente.setTipo_identificacion((String) Cmb_tipo_identificacion.getSelectedItem());
        paciente.setTipo_sangre((String) Cmb_tipoSangre.getSelectedItem());
        paciente.setEstado_civil((String) Cmb_estadoCivil.getSelectedItem());
        paciente.setOcupacion(txt_ocupacion.getText().trim());
       

        if (controlPaciente.actualizarPaciente(paciente)) {
            JOptionPane.showMessageDialog(this, "Paciente actualizado exitosamente.");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el paciente.");
        }
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para eliminar el paciente
//----------------------------------------------------------------------------------------------------------------------//    
private void eliminaPaciente() {
        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        String identificacion = txt_identificacion.getText().trim();

        if (identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la identificación del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (controlPaciente.eliminarPaciente(identificacion)) {
            JOptionPane.showMessageDialog(this, "Paciente eliminado exitosamente.");
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el paciente.");
        }
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para consultar el paciente
//----------------------------------------------------------------------------------------------------------------------//    

private void consultaPaciente() {
    Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        String identificacion = txt_identificacion.getText().trim();

        if (identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la identificación del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Paciente paciente = controlPaciente.obtenerPaciente(identificacion);
        if (paciente != null) {
            txt_nombre.setText(paciente.getNombre());
            txt_apellido.setText(paciente.getApellido());
            txt_direccion.setText(paciente.getDireccion());
            txt_ciudad.setText(paciente.getCiudad());
            txt_pais.setText(paciente.getPais());
            txt_telefono.setText(paciente.getTelefono());
            txt_email.setText(paciente.getEmail());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            txt_fechaNacimiento.setText(formatter.format(paciente.getFechaNacimiento()));

            Cmb_genero.setSelectedItem(paciente.getGenero());
            Cmb_tipo_identificacion.setSelectedItem(paciente.getTipo_identificacion());
            Cmb_tipoSangre.setSelectedItem(paciente.getTipo_sangre());
            Cmb_estadoCivil.setSelectedItem(paciente.getEstado_civil());
            txt_ocupacion.setText(paciente.getOcupacion());
            //txt_alergias.setText(paciente.getAlergias());
            // Aquí puedes manejar la imagen si es necesario

        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
        }
    }


}
