package ventanas;

import controlador.Ctrl_Usuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import modelo.Usuario;


/**
 *
 * @author Miller
 */
public class FrmNuevoUsuario extends javax.swing.JFrame {
    
    // Colores para el tema claro
    private Color fondoClaro = new Color(234, 236, 238); // Blanco atenuado para evitar el deslumbramiento.
    private Color textoClaro = new Color(253, 254, 254); // Negro suave para un buen contraste sin ser demasiado fuerte.
    private Color botonClaro = new Color(236, 240, 241); // Gris claro para botones que contraste bien con el fondo claro.

    // Colores para el tema oscuro
    private Color fondoOscuro = new Color(28, 40, 51);  // ok
    private Color textoOscuro = new Color(23, 32, 42); // Blanco suave para una buena legibilidad en el fondo oscuro.
    private Color botonOscuro = new Color(242, 244, 244); // Gris medio para botones que mantenga el contraste con el fondo oscuro.

       // Iconos
    private ImageIcon iconoSol = new ImageIcon(getClass().getResource("/images/sol.png"));
    private ImageIcon iconoLuna = new ImageIcon(getClass().getResource("/images/luna_1.png"));


    private FileInputStream fis;
    private int longitudBytes;

    public FrmNuevoUsuario() {
        
        

        setUndecorated(true);

        initComponents();

         jToggleButton1.setIcon(iconoLuna); // Ícono inicial
        
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
        jLabel_usuario.setText("Usuario: " + nombreUsuario);
        
        

//         String tipoNivel = FrmLogin.getUsuarioTipoNivel();
//         jLabel_TipoNivel.setText("Tipo Nivel :" + tipoNivel);
        this.setSize(711, 528);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Colocar imagen de fondo
    * ------------------------------------------------------------------------------------------------------------------------
         */
//        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
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

        jLabel11 = new javax.swing.JLabel();
        Btn_cerrar = new javax.swing.JButton();
        Btn_minimizar = new javax.swing.JButton();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_TipoNivel = new javax.swing.JLabel();
        jLabel_cabecera = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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
        txt_id_usuario = new javax.swing.JTextField();
        Btn_regresar = new javax.swing.JButton();
        Btn_guardar = new javax.swing.JButton();
        Btn_actualizar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_ver_usuarios = new javax.swing.JButton();
        Cmb_tipo_nivel = new javax.swing.JComboBox<>();
        Cmb_estatus = new javax.swing.JComboBox<>();
        Btn_buscar = new javax.swing.JButton();
        jLabel_foto = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gestionar Usuarios");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

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
        getContentPane().add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 50, -1));

        Btn_minimizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_minimizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_minimizar.setForeground(new java.awt.Color(0, 0, 0));
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
        getContentPane().add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 40, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 20));

        jLabel_TipoNivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_TipoNivel.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_TipoNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 20));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("ID :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 30, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Email :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telefono :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Username :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Password :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de Nivel :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Estatus :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Registrado por :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de creacion :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Ultima sesion :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_nombreMouseExited(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 190, -1));

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_emailMouseExited(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseExited(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 170, -1));

        txt_username.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_username.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_username.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_usernameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_usernameMouseExited(evt);
            }
        });
        jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 170, -1));

        txt_password.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_passwordMouseExited(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 170, -1));

        txt_registrado_por.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_registrado_por.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_registrado_por.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_registrado_por.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_registrado_porMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_registrado_porMouseExited(evt);
            }
        });
        jPanel1.add(txt_registrado_por, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 140, -1));

        txt_fecha_creacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_fecha_creacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha_creacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_fecha_creacion.setEnabled(false);
        jPanel1.add(txt_fecha_creacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 140, -1));

        txt_ultima_sesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_ultima_sesion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ultima_sesion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ultima_sesion.setEnabled(false);
        jPanel1.add(txt_ultima_sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 140, -1));

        txt_id_usuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_id_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_usuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txt_id_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 80, -1));

        Btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_regresar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_regresar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 120, -1));

        Btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_guardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_guardar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 110, -1));

        Btn_actualizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_actualizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_actualizar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 100, -1));

        Btn_eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_eliminar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_eliminar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 110, -1));

        Btn_ver_usuarios.setBackground(new java.awt.Color(255, 255, 255));
        Btn_ver_usuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_ver_usuarios.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_ver_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, 110, -1));

        Cmb_tipo_nivel.setBackground(new java.awt.Color(255, 255, 255));
        Cmb_tipo_nivel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_tipo_nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Administrador", "Auxiliar" }));
        jPanel1.add(Cmb_tipo_nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 170, -1));

        Cmb_estatus.setBackground(new java.awt.Color(255, 255, 255));
        Cmb_estatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_estatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Activo", "Inactivo" }));
        jPanel1.add(Cmb_estatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 170, -1));

        Btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_buscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_buscar.setForeground(new java.awt.Color(51, 51, 51));
        Btn_buscar.setText("Buscar");
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
        jPanel1.add(Btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 100, -1));

        jLabel_foto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_fotoMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 160, 140));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 480));

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

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_ver_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosActionPerformed
        FrmGestionarUsuarios frmGestionarUsuarios = new FrmGestionarUsuarios();
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
        Btn_guardar.setBackground(new Color(102, 255, 102));
        Btn_guardar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_guardar.setBackground(Color.white);
        Btn_guardar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actualizarMouseEntered
        Btn_actualizar.setBackground(new Color(255,255,102));
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

    private void Btn_ver_usuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosMouseEntered
        Btn_ver_usuarios.setBackground(new Color(0, 153, 204));
        Btn_ver_usuarios.setForeground(Color.white);
    }//GEN-LAST:event_Btn_ver_usuariosMouseEntered

    private void Btn_ver_usuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_ver_usuariosMouseExited
        Btn_ver_usuarios.setBackground(Color.white);
        Btn_ver_usuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_ver_usuariosMouseExited

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

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        dispose();
        FrmAdmin frmAdmin = new FrmAdmin();
        frmAdmin.setVisible(true);
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_minimizarActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarActionPerformed

    private void Btn_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseEntered
        Btn_minimizar.setBackground(new Color(0, 153, 204));
        Btn_minimizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_minimizarMouseEntered

    private void Btn_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseExited
        Btn_minimizar.setBackground(Color.white);
        Btn_minimizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_minimizarMouseExited

    private void Btn_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseEntered
        Btn_cerrar.setBackground(new Color(255, 51, 51));
        Btn_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrarMouseEntered

    private void Btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseExited
        Btn_cerrar.setBackground(Color.white);
        Btn_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrarMouseExited

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        buscarUsuarioPorID();

    }//GEN-LAST:event_Btn_buscarActionPerformed

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

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_buscar.setBackground(new Color(0, 153, 204));
        Btn_buscar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_buscar.setBackground(Color.white);
        Btn_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
         if (jToggleButton1.isSelected()) {
          aplicarTemaOscuro();
          //  jToggleButton1.setText("Tema Claro");
            jToggleButton1.setIcon(iconoSol); // Cambia el ícono a sol
        } else {
            aplicarTemaClaro();
           // jToggleButton1.setText("Tema Oscuro");
            jToggleButton1.setIcon(iconoLuna); // Cambia el ícono a luna
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_minimizar;
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
    private javax.swing.JLabel jLabel_TipoNivel;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_foto;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
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
//                                                         Métodos para cambiar de tema
//----------------------------------------------------------------------------------------------------------------------//

    private void aplicarTemaClaro() {
        jPanel1.setBackground(fondoClaro);
         jToggleButton1.setBackground(botonOscuro); // Establece el color de fondo del botón para el tema claro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema claro.
        jLabel1.setForeground(textoOscuro); // Establece el color del texto de la etiqueta para el tema claro.
        jLabel2.setForeground(textoOscuro);
        jLabel3.setForeground(textoOscuro);
        jLabel4.setForeground(textoOscuro);
        jLabel5.setForeground(textoOscuro);
        jLabel6.setForeground(textoOscuro);
        jLabel7.setForeground(textoOscuro);
        jLabel8.setForeground(textoOscuro);
        jLabel9.setForeground(textoOscuro);
        jLabel10.setForeground(textoOscuro);
        jLabel12.setForeground(textoOscuro);
       
        // jTextField1.setBackground(fondoOscuro); // Establece el color de fondo del campo de texto para el tema claro.
        // jTextField1.setForeground(textoClaro); // Establece el color del texto del campo de texto para el tema claro.
        Btn_guardar.setBackground(botonOscuro); // Establece el color de fondo del botón adicional para el tema claro.
        Btn_guardar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema claro.
       
    }

    private void aplicarTemaOscuro() {
        jPanel1.setBackground(fondoOscuro);
         jToggleButton1.setBackground(botonClaro); // Establece el color de fondo del botón para el tema oscuro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema oscuro.
        jLabel1.setForeground(textoClaro); // Establece el color del texto de la etiqueta para el tema oscuro.
        jLabel2.setForeground(textoClaro);
        jLabel3.setForeground(textoClaro);
        jLabel4.setForeground(textoClaro);
        jLabel5.setForeground(textoClaro);
        jLabel6.setForeground(textoClaro);
        jLabel7.setForeground(textoClaro);
        jLabel8.setForeground(textoClaro);
        jLabel9.setForeground(textoClaro);
        jLabel10.setForeground(textoClaro);
        jLabel12.setForeground(textoClaro);
        // jTextField1.setBackground(fondoClaro); // Establece el color de fondo del campo de texto para el tema oscuro.
        // jTextField1.setForeground(textoOscuro); // Establece el color del texto del campo de texto para el tema oscuro.
        Btn_guardar.setBackground(botonClaro); // Establece el color de fondo del botón adicional para el tema oscuro.
        Btn_guardar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema oscuro.
       
    }
    
// ----------------------------------------------------------------------------------------------------------------------//
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
                || txt_registrado_por.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.");
            return false;
        }

        // Validar selección de combobox
        if (Cmb_tipo_nivel.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un nivel.");
            return false;
        }

        // Validar selección de combobox
        if (Cmb_estatus.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un estatus.");
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
        // Validar imagen
        if (fis == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una imagen.");
            return false;
        }

        // Si se está buscando un usuario, permitir que la contraseña esté vacía
        // Esto es útil para el caso de actualización de usuario cuando no se cambia la contraseña
        if (txt_password.getText().trim().isEmpty() && Btn_guardar.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
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
        usuario.setFecha_creacion(new Date());

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
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
        Usuario usuario = new Usuario();

        // Validamos que los campos no estén vacíos y se haya seleccionado todo
        if (!validarCampos()) {
            return;
        }

        // Asignamos lo que el usuario ingresó al usuario
        usuario.setId_usuario(Integer.parseInt(txt_id_usuario.getText().trim())); // Asignar el ID del usuario
        usuario.setNombre_usuario(txt_nombre.getText().trim());
        usuario.setEmail(txt_email.getText().trim());
        usuario.setTelefono(txt_telefono.getText().trim());
        usuario.setUsername(txt_username.getText().trim());
        usuario.setPassword(txt_password.getText().trim());
        usuario.setTipo_nivel((String) Cmb_tipo_nivel.getSelectedItem());
        usuario.setEstatus((String) Cmb_estatus.getSelectedItem());
        usuario.setRegistrado_por(txt_registrado_por.getText().trim());

        // Convertir la imagen a un array de bytes (si hay una nueva imagen seleccionada)
        byte[] imagenBytes = null;
        if (fis != null) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
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
            usuario.setImagen(imagenBytes); // Asignar imagen a Usuario
        }

        // Actualizar el usuario en la base de datos
        if (controlUsuario.actualizarUsuario(usuario)) {
            JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
            limpiarCampos(); // Limpiar los campos después de actualizar
            if (imagenBytes != null) {
                mostrarImagen(imagenBytes); // Mostrar la imagen actualizada en el JLabel
            }
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
        String idUsuarioStr = txt_id_usuario.getText().trim();

        if (idUsuarioStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la identificación del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idUsuario;
        try {
            idUsuario = Integer.parseInt(idUsuarioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La identificación del usuario debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = controlUsuario.obtenerUsuarioPorID(idUsuario);
        if (usuario != null) {
            txt_nombre.setText(usuario.getNombre_usuario());
            txt_email.setText(usuario.getEmail());
            txt_telefono.setText(usuario.getTelefono());
            txt_username.setText(usuario.getUsername());
            txt_password.setText(usuario.getPassword());
            Cmb_tipo_nivel.setSelectedItem(usuario.getTipo_nivel());
            Cmb_estatus.setSelectedItem(usuario.getEstatus());
            txt_registrado_por.setText(usuario.getRegistrado_por());
            // Definir el formato de la fecha
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

// Convertir Date o Timestamp a String
            txt_fecha_creacion.setText(sdf.format(usuario.getFecha_creacion()));
            txt_ultima_sesion.setText(sdf.format(usuario.getUltima_sesion()));

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
