package ventanas;

import conexion.Conexion;
import controlador.Ctrl_Paciente;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
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
import javax.swing.JFrame;
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

        Btn_guardar.setVisible(true);
        Btn_actualizar.setVisible(true);

        // Obtiene el nombre de usuario que ha iniciado sesión desde el formulario de login
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
        jLabel_usuario.setText("Usuario: " + nombreUsuario);

        String tipoNivel = FrmLogin.getUsuarioTipoNivel();

        this.setTitle("Formulario de Paciente");
        this.setSize(752, 586);
        // cierra todos los procesos en segundo plano cuando se cierra lainterfaz
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));


        // Verifica si el tipo de nivel es "Administrador" para mostrar u ocultar el botón de nuevo usuario
        if ("Administrador".equals(tipoNivel)) {
            // Si el tipo de nivel es "Administrador", se muestra el botón de nuevo usuario
            Btn_eliminar.setVisible(true);
        } else {
            // Si el tipo de nivel no es "Administrador", se oculta el botón de nuevo usuario
            Btn_eliminar.setVisible(false);
        }
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
        Btn_cerrar = new javax.swing.JButton();
        Btn_minimizar = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Cmb_tipo_identificacion = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        Cmb_tipoSangre = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        Cmb_estadoCivil = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_pacientes = new javax.swing.JTable();
        txt_ocupacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nombreMouseExited(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 200, -1));

        txt_apellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_apellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_apellidoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_apellidoMouseExited(evt);
            }
        });
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 200, -1));

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_direccionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_direccionMouseExited(evt);
            }
        });
        getContentPane().add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 200, -1));

        txt_ciudad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ciudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ciudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ciudadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ciudadMouseExited(evt);
            }
        });
        getContentPane().add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, -1));

        txt_pais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_pais.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pais.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_paisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_paisMouseExited(evt);
            }
        });
        txt_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paisActionPerformed(evt);
            }
        });
        getContentPane().add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 200, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseExited(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, -1));

        Cmb_genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Genero", "Masculino", "Femenino", "Otro" }));
        getContentPane().add(Cmb_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 180, -1));

        Btn_guardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        getContentPane().add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 110, -1));

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_emailMouseExited(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 180, -1));

        txt_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_identificacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_identificacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_identificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_identificacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_identificacionMouseExited(evt);
            }
        });
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
        getContentPane().add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 160, 140));

        Btn_regresar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        getContentPane().add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, -1, -1));

        Btn_actualizar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        getContentPane().add(Btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 530, -1, -1));

        Btn_eliminar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
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
        getContentPane().add(Btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

        Btn_consultar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Btn_consultar.setText("Buscar");
        Btn_consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_consultarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_consultarMouseExited(evt);
            }
        });
        Btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_consultarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, 180, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, 20));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Gestionar Pacientes");
        getContentPane().add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 190, 20));

        Btn_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_cerrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_cerrar.setForeground(new java.awt.Color(0, 0, 0));
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
        getContentPane().add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, -1));

        Btn_minimizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_minimizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_minimizar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_minimizar.setText("-");
        Btn_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btn_minimizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_minimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_minimizarMouseExited(evt);
            }
        });
        getContentPane().add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));
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

        jTable_pacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_pacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_pacientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_pacientes);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 660, 100));

        txt_ocupacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_ocupacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ocupacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ocupacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_ocupacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_ocupacionMouseExited(evt);
            }
        });
        getContentPane().add(txt_ocupacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 180, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Ocupacion :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, -1, -1));

        txt_fecha_nacimiento.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(txt_fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 160, -1));

        jLabel_Wallpaper.setBackground(new java.awt.Color(51, 51, 51));
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
        Btn_guardar.setVisible(false);
        Btn_actualizar.setVisible(true);


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

    private void jTable_pacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_pacientesMouseClicked

    }//GEN-LAST:event_jTable_pacientesMouseClicked

    private void txt_nombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseEntered
        txt_nombre.setBackground(Color.black);
        txt_nombre.setForeground(Color.white);
    }//GEN-LAST:event_txt_nombreMouseEntered

    private void txt_nombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseExited
        txt_nombre.setBackground(Color.white);
        txt_nombre.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_nombreMouseExited

    private void txt_apellidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_apellidoMouseEntered
        txt_apellido.setBackground(Color.black);
        txt_apellido.setForeground(Color.white);
    }//GEN-LAST:event_txt_apellidoMouseEntered

    private void txt_apellidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_apellidoMouseExited
        txt_apellido.setBackground(Color.white);
        txt_apellido.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_apellidoMouseExited

    private void txt_direccionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_direccionMouseEntered
        txt_direccion.setBackground(Color.black);
        txt_direccion.setForeground(Color.white);
    }//GEN-LAST:event_txt_direccionMouseEntered

    private void txt_direccionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_direccionMouseExited
        txt_direccion.setBackground(Color.white);
        txt_direccion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_direccionMouseExited

    private void txt_ciudadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ciudadMouseEntered
        txt_ciudad.setBackground(Color.black);
        txt_ciudad.setForeground(Color.white);
    }//GEN-LAST:event_txt_ciudadMouseEntered

    private void txt_ciudadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ciudadMouseExited
        txt_ciudad.setBackground(Color.white);
        txt_ciudad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_ciudadMouseExited

    private void txt_paisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paisMouseEntered
        txt_pais.setBackground(Color.black);
        txt_pais.setForeground(Color.white);
    }//GEN-LAST:event_txt_paisMouseEntered

    private void txt_paisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_paisMouseExited
        txt_pais.setBackground(Color.white);
        txt_pais.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_paisMouseExited

    private void txt_telefonoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseEntered
        txt_telefono.setBackground(Color.black);
        txt_telefono.setForeground(Color.white);
    }//GEN-LAST:event_txt_telefonoMouseEntered

    private void txt_telefonoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseExited
        txt_telefono.setBackground(Color.white);
        txt_telefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_telefonoMouseExited

    private void txt_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseEntered
        txt_email.setBackground(Color.black);
        txt_email.setForeground(Color.white);
    }//GEN-LAST:event_txt_emailMouseEntered

    private void txt_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseExited
        txt_email.setBackground(Color.white);
        txt_email.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_emailMouseExited

    private void txt_ocupacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ocupacionMouseEntered
        txt_ocupacion.setBackground(Color.black);
        txt_ocupacion.setForeground(Color.white);
    }//GEN-LAST:event_txt_ocupacionMouseEntered

    private void txt_ocupacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ocupacionMouseExited
        txt_ocupacion.setBackground(Color.white);
        txt_ocupacion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_ocupacionMouseExited

    private void txt_identificacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_identificacionMouseEntered
        txt_identificacion.setBackground(Color.black);
        txt_identificacion.setForeground(Color.white);
    }//GEN-LAST:event_txt_identificacionMouseEntered

    private void txt_identificacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_identificacionMouseExited
        txt_identificacion.setBackground(Color.white);
        txt_identificacion.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_identificacionMouseExited

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
        Btn_eliminar.setBackground(new Color(255,51,51));
        Btn_eliminar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_eliminar.setBackground(Color.white);
        Btn_eliminar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_consultarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_consultarMouseEntered
        Btn_consultar.setBackground(new Color(0, 153, 204));
        Btn_consultar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_consultarMouseEntered

    private void Btn_consultarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_consultarMouseExited
        Btn_consultar.setBackground(Color.white);
        Btn_consultar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_consultarMouseExited

    private void Btn_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarMouseClicked

    private void Btn_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseEntered
        Btn_minimizar.setBackground(new Color(0, 153, 204));
        Btn_minimizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_minimizarMouseEntered

    private void Btn_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseExited
        Btn_minimizar.setBackground(Color.white);
        Btn_minimizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_minimizarMouseExited

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseEntered
        Btn_cerrar.setBackground(new Color(255,51,51));
        Btn_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrarMouseEntered

    private void Btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseExited
        Btn_cerrar.setBackground(Color.white);
        Btn_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrarMouseExited

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
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_consultar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JComboBox<String> Cmb_estadoCivil;
    private javax.swing.JComboBox<String> Cmb_genero;
    private javax.swing.JComboBox<String> Cmb_tipoSangre;
    private javax.swing.JComboBox<String> Cmb_tipo_identificacion;
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
    private javax.swing.JTable jTable_pacientes;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private com.toedter.calendar.JDateChooser txt_fecha_nacimiento;
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

        // Validar fecha de nacimiento
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        if (fecha_nacimiento == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fecha de nacimiento válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar imagen
        if (fis == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen.");
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
        // Limpiar el JDateChooser
        txt_fecha_nacimiento.setDate(null);
        txt_identificacion.setText("");
        txt_ocupacion.setText("");
        jLabel_foto.setText("");
        Cmb_tipo_identificacion.setSelectedIndex(0);
        Cmb_genero.setSelectedIndex(0);
        Cmb_tipoSangre.setSelectedIndex(0);
        Cmb_estadoCivil.setSelectedIndex(0);
        fis = null; // Resetear FileInputStream
    }

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para guardar un paciente
//----------------------------------------------------------------------------------------------------------------------//    
    private void guardaPaciente() {

        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        Paciente paciente = new Paciente();

        if (!validarCampos()) {
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
        // Obtener la fecha de nacimiento directamente desde el JDateChooser
        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        paciente.setFechaNacimiento(fecha_nacimiento);

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
        if (controlPaciente.existePaciente(paciente.getIdentificacion())) {
            JOptionPane.showMessageDialog(this, "El paciente con esta identificación ya está registrado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (controlPaciente.guardarPaciente(paciente)) {
            JOptionPane.showMessageDialog(this, "Paciente guardado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de guardar
        } else {
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

        // Convertir la fecha de nacimiento desde el texto
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // Obtener la fecha de nacimiento directamente desde el JDateChooser
        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        paciente.setFechaNacimiento(fecha_nacimiento);

        paciente.setGenero((String) Cmb_genero.getSelectedItem());
        paciente.setIdentificacion(txt_identificacion.getText().trim());
        paciente.setTipo_identificacion((String) Cmb_tipo_identificacion.getSelectedItem());
        paciente.setTipo_sangre((String) Cmb_tipoSangre.getSelectedItem());
        paciente.setEstado_civil((String) Cmb_estadoCivil.getSelectedItem());
        paciente.setOcupacion(txt_ocupacion.getText().trim());

        // Convertir la imagen a un array de bytes (si hay una nueva imagen seleccionada)
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
        paciente.setImagen(imagenBytes); // Asignar imagen a Paciente

        if (controlPaciente.actualizarPaciente(paciente)) {
            JOptionPane.showMessageDialog(this, "Actualizado exitosamente.");
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
            Date fechaNacimiento = paciente.getFechaNacimiento();
            txt_fecha_nacimiento.setDate(fechaNacimiento);

            Cmb_genero.setSelectedItem(paciente.getGenero());
            Cmb_tipo_identificacion.setSelectedItem(paciente.getTipo_identificacion());
            Cmb_tipoSangre.setSelectedItem(paciente.getTipo_sangre());
            Cmb_estadoCivil.setSelectedItem(paciente.getEstado_civil());
            txt_ocupacion.setText(paciente.getOcupacion());
            //txt_alergias.setText(paciente.getAlergias());
            // Aquí puedes manejar la imagen si es necesario
            // Manejo de la imagen
            byte[] imgBytes = paciente.getImagen();
            if (imgBytes != null) {
                ImageIcon icon = new ImageIcon(imgBytes);
                jLabel_foto.setIcon(icon); // Asumiendo que tienes un JLabel llamado lblImagen
            } else {
                jLabel_foto.setIcon(null); // Puedes establecer una imagen por defecto si no hay imagen
            }

        } else {
            JOptionPane.showMessageDialog(this, "Paciente no encontrado.");
        }
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                      Metodo para obtener todos los pacientes en la tabla
    //---------------------------------------------------------------------------------------------------------------------//
}
