package ventanas;

import controlador.Ctrl_Odontologo;
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
import modelo.Odontologo;

/**
 *
 * @author Miller
 */
public class FrmOdontologo extends javax.swing.JFrame {

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Variables para definir los colores del modo dark
//----------------------------------------------------------------------------------------------------------------------//
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

    public FrmOdontologo() {

        setUndecorated(true);

        initComponents();

        this.setSize(722, 501);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        jToggleButton1.setIcon(iconoLuna); // Establece el ícono inicial del botón como luna

        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
        jLabel_usuario.setText("Usuario: " + nombreUsuario);

        String tipoNivel = FrmLogin.getUsuarioTipoNivel();

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

        jPanel1 = new javax.swing.JPanel();
        Btn_verOdontologos = new javax.swing.JButton();
        Btn_actualizar = new javax.swing.JButton();
        Btn_eliminar = new javax.swing.JButton();
        Btn_guardar = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        Cmb_tipo_identificacion = new javax.swing.JComboBox<>();
        Btn_buscar = new javax.swing.JButton();
        txt_pais = new javax.swing.JTextField();
        txt_identificacion = new javax.swing.JTextField();
        Cmb_genero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_numero_licencia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_ciudad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel_foto = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        txt_apellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_especialidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_titulo = new javax.swing.JLabel();
        Btn_minimizar = new javax.swing.JButton();
        Btn_cerrar = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_verOdontologos.setBackground(new java.awt.Color(255, 255, 255));
        Btn_verOdontologos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_verOdontologos.setForeground(new java.awt.Color(51, 51, 51));
        Btn_verOdontologos.setText("Ver odontologos");
        Btn_verOdontologos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_verOdontologosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_verOdontologosMouseExited(evt);
            }
        });
        Btn_verOdontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_verOdontologosActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_verOdontologos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 130, -1));

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
        jPanel1.add(Btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

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
        jPanel1.add(Btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, -1, -1));

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
        jPanel1.add(Btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

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
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        Cmb_tipo_identificacion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_tipo_identificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tipo documento", "Cedula", "Tarjeta", "pasaporte" }));
        Cmb_tipo_identificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmb_tipo_identificacionActionPerformed(evt);
            }
        });
        jPanel1.add(Cmb_tipo_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 140, -1));

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
        jPanel1.add(Btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 130, -1));

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
        jPanel1.add(txt_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 170, -1));

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
        jPanel1.add(txt_identificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 130, -1));

        Cmb_genero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Cmb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Genero", "Masculino", "Femenino", "Otro" }));
        jPanel1.add(Cmb_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Pais :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Identificacion :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_telefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_telefono.setToolTipText("ingrese el telefono");
        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseExited(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 130, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Telefono");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        txt_numero_licencia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_numero_licencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_numero_licencia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_numero_licencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_numero_licenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_numero_licenciaMouseExited(evt);
            }
        });
        jPanel1.add(txt_numero_licencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Numero de licencia :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

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
        jPanel1.add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Ciudad :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        txt_fecha_nacimiento.setDateFormatString("yyyy-MM-dd");
        txt_fecha_nacimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_fecha_nacimientoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_fecha_nacimientoMouseExited(evt);
            }
        });
        jPanel1.add(txt_fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 140, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de nacimiento :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

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
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Direccion :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel_foto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel_foto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_fotoMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 130, 110));

        jToggleButton1.setBackground(new java.awt.Color(255, 255, 255));
        jToggleButton1.setForeground(new java.awt.Color(51, 51, 51));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 40, 30));

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
        jPanel1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 170, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Apellido :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 170, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

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
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 140, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Email :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        txt_especialidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_especialidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_especialidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_especialidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_especialidadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_especialidadMouseExited(evt);
            }
        });
        jPanel1.add(txt_especialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 140, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Especialidad :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 20));

        jLabel_titulo.setBackground(new java.awt.Color(51, 51, 51));
        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_titulo.setText("Gestionar Odontologos");
        jPanel1.add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        Btn_minimizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_minimizar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, -1, -1));

        Btn_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_cerrar.setForeground(new java.awt.Color(51, 51, 51));
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
        jPanel1.add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));
        jPanel1.add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_guardarActionPerformed
        guardarOdontologo();
    }//GEN-LAST:event_Btn_guardarActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        this.dispose();
       
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_minimizarActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarActionPerformed

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        this.dispose();
        
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

    private void txt_nombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreMouseEntered
        txt_nombre.setBackground(new Color(158, 158, 158));
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

    private void txt_especialidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_especialidadMouseEntered
        txt_especialidad.setBackground(Color.black);
        txt_especialidad.setForeground(Color.white);
    }//GEN-LAST:event_txt_especialidadMouseEntered

    private void txt_especialidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_especialidadMouseExited
        txt_especialidad.setBackground(Color.white);
        txt_especialidad.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_especialidadMouseExited

    private void txt_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseEntered
        txt_email.setBackground(Color.black);
        txt_email.setForeground(Color.white);
    }//GEN-LAST:event_txt_emailMouseEntered

    private void txt_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseExited
        txt_email.setBackground(Color.white);
        txt_email.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_emailMouseExited

    private void txt_fecha_nacimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fecha_nacimientoMouseEntered
        txt_fecha_nacimiento.setBackground(Color.black);
        txt_fecha_nacimiento.setForeground(Color.white);
    }//GEN-LAST:event_txt_fecha_nacimientoMouseEntered

    private void txt_fecha_nacimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fecha_nacimientoMouseExited
        txt_fecha_nacimiento.setBackground(Color.white);
        txt_fecha_nacimiento.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_fecha_nacimientoMouseExited

    private void txt_numero_licenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_numero_licenciaMouseEntered
        txt_numero_licencia.setBackground(Color.black);
        txt_numero_licencia.setForeground(Color.white);
    }//GEN-LAST:event_txt_numero_licenciaMouseEntered

    private void txt_numero_licenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_numero_licenciaMouseExited
        txt_numero_licencia.setBackground(Color.white);
        txt_numero_licencia.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_numero_licenciaMouseExited

    private void txt_telefonoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseEntered
        txt_telefono.setBackground(Color.black);
        txt_telefono.setForeground(Color.white);
    }//GEN-LAST:event_txt_telefonoMouseEntered

    private void txt_telefonoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_telefonoMouseExited
        txt_telefono.setBackground(Color.white);
        txt_telefono.setForeground(Color.BLACK);
    }//GEN-LAST:event_txt_telefonoMouseExited

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
        //Btn_regresar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_regresarMouseEntered

    private void Btn_regresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_regresarMouseExited
        Btn_regresar.setBackground(Color.white);
        //Btn_regresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_regresarMouseExited

    private void Btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseEntered
        Btn_guardar.setBackground(new Color(102, 255, 102));
        // Btn_guardar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_guardarMouseEntered

    private void Btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_guardarMouseExited
        Btn_guardar.setBackground(Color.white);
        //Btn_guardar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_guardarMouseExited

    private void Btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_actualizarActionPerformed
        actualizarOdontologo();
    }//GEN-LAST:event_Btn_actualizarActionPerformed

    private void Btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actualizarMouseEntered
        Btn_actualizar.setBackground(new Color(255, 255, 102));
        // Btn_actualizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_actualizarMouseEntered

    private void Btn_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actualizarMouseExited
        Btn_actualizar.setBackground(Color.white);
        //Btn_actualizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_actualizarMouseExited

    private void Btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_eliminarActionPerformed
       eliminarOdontologo();
    }//GEN-LAST:event_Btn_eliminarActionPerformed

    private void Btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseEntered
        Btn_eliminar.setBackground(new Color(255, 51, 51));
        //Btn_eliminar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_eliminarMouseEntered

    private void Btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_eliminarMouseExited
        Btn_eliminar.setBackground(Color.white);
        //Btn_eliminar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_eliminarMouseExited

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        consultarOdontologo();
    }//GEN-LAST:event_Btn_buscarActionPerformed

    private void Btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseEntered
        Btn_buscar.setBackground(new Color(0, 153, 204));
        //Btn_buscar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_buscarMouseEntered

    private void Btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_buscarMouseExited
        Btn_buscar.setBackground(Color.white);
        //Btn_buscar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_buscarMouseExited

    private void Btn_verOdontologosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_verOdontologosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_verOdontologosMouseEntered

    private void Btn_verOdontologosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_verOdontologosMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_verOdontologosMouseExited

    private void Btn_verOdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_verOdontologosActionPerformed
        FrmGestionarOdontologos frmGestionarOdontologos = new FrmGestionarOdontologos();
        frmGestionarOdontologos.setVisible(true);
    }//GEN-LAST:event_Btn_verOdontologosActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            aplicarTemaOscuro();
            jToggleButton1.setIcon(iconoSol);
        } else {
            aplicarTemaClaro();
            jToggleButton1.setIcon(iconoLuna);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void Cmb_tipo_identificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmb_tipo_identificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cmb_tipo_identificacionActionPerformed

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
    private javax.swing.JButton Btn_actualizar;
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_eliminar;
    private javax.swing.JButton Btn_guardar;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton Btn_verOdontologos;
    private javax.swing.JComboBox<String> Cmb_genero;
    private javax.swing.JComboBox<String> Cmb_tipo_identificacion;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
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
//                                                         Métodos para aplicar tema oscuro / claro
//----------------------------------------------------------------------------------------------------------------------//
    private void aplicarTemaClaro() {
        jPanel1.setBackground(fondoClaro); // Establece el color de fondo del panel para el tema claro.
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
        Btn_guardar.setBackground(botonOscuro); // Establece el color de fondo del botón adicional para el tema claro.
        Btn_guardar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema claro.
    }

    private void aplicarTemaOscuro() {
        jPanel1.setBackground(fondoOscuro); // Establece el color de fondo del panel para el tema oscuro.
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
        Btn_guardar.setBackground(botonClaro); // Establece el color de fondo del botón adicional para el tema oscuro.
        Btn_guardar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema oscuro.
    }

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
        odontologo.setImagen(imagenBytes); // Asignar imagen a Usuario
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

    //----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para actualizar el odontologo
//----------------------------------------------------------------------------------------------------------------------//
    private void actualizarOdontologo() {
        // Crear una nueva instancia de la clase Odontologo
        Odontologo odontologo = new Odontologo();
        // Crear una nueva instancia de la clase Ctrl_Odontologo que manejará la lógica de actualización
        Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();

        // Validar que todos los campos requeridos estén completos
        if (!validarCampos()) {
            return; // Si la validación falla, salir del método
        }

        // Asignar los valores de los campos de texto a los atributos del objeto Odontologo
        odontologo.setNombre_odontologo(txt_nombre.getText().trim());
        odontologo.setApellido(txt_apellido.getText().trim());
        odontologo.setDireccion(txt_direccion.getText().trim());
        odontologo.setCiudad(txt_ciudad.getText().trim());
        odontologo.setPais(txt_pais.getText().trim());
        odontologo.setEspecialidad(txt_especialidad.getText().trim());
        odontologo.setTelefono(txt_telefono.getText().trim());
        odontologo.setEmail(txt_email.getText().trim());
        odontologo.setTipo_identificacion((String) Cmb_tipo_identificacion.getSelectedItem());
        odontologo.setIdentificacion(txt_identificacion.getText().trim());

        // Convertir la imagen a un array de bytes (si hay una nueva imagen seleccionada)
        if (fis != null) {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
                odontologo.setImagen(baos.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al leer el archivo de imagen.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            // No hacer nada, la imagen existente se mantendrá en la base de datos.
            odontologo.setImagen(null);
        }

        Date fecha_nacimiento = txt_fecha_nacimiento.getDate();
        odontologo.setFecha_nacimiento(fecha_nacimiento);
        odontologo.setGenero((String) Cmb_genero.getSelectedItem());

        odontologo.setNumero_licencia(txt_numero_licencia.getText().trim());

        // Intentar actualizar el odontólogo usando el método en la clase de control
        if (controlOdontologo.actualizarOdontologo(odontologo)) {
            // Mostrar un mensaje de éxito si la actualización fue exitosa
            JOptionPane.showMessageDialog(null, "actualizado exitosamente.");
            // Limpiar los campos del formulario después de la actualización
            limpiarCampos();
        } else {
            // Mostrar un mensaje de error si la actualización falla
            JOptionPane.showMessageDialog(null, "Error al actualizar.");
        }
    }
    
 //----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para eliminar un odontologo
//----------------------------------------------------------------------------------------------------------------------//
private void eliminarOdontologo(){
    // llamamos al controlador 
    Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();
    String identificacion = txt_identificacion.getText().trim();
    
    if(identificacion.isEmpty()){
         JOptionPane.showMessageDialog(this, "Ingrese la identificación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
    }
    
    if(controlOdontologo.eliminarOdontologo(identificacion)){
        JOptionPane.showMessageDialog(this, "Eliminado exitosamente.");
            limpiarCampos();
    } else {
         JOptionPane.showMessageDialog(this, "Error al eliminar.");
    }
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Método para consultar el odontologo
//----------------------------------------------------------------------------------------------------------------------//  
    private void consultarOdontologo() {
        Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();
        String identificacion = txt_identificacion.getText().trim();

        if (identificacion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la identificación del paciente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Odontologo odontologo = controlOdontologo.obtenerOdontologo(identificacion);
        if (odontologo != null) {
            txt_nombre.setText(odontologo.getNombre_odontologo());
            txt_apellido.setText(odontologo.getApellido());
            txt_direccion.setText(odontologo.getDireccion());
            txt_ciudad.setText(odontologo.getCiudad());
            txt_pais.setText(odontologo.getPais());
            txt_especialidad.setText(odontologo.getEspecialidad());
            txt_telefono.setText(odontologo.getTelefono());
            txt_email.setText(odontologo.getEmail());
            Cmb_tipo_identificacion.setSelectedItem(odontologo.getTipo_identificacion());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_nacimiento = odontologo.getFecha_nacimiento();
            txt_fecha_nacimiento.setDate(fecha_nacimiento);

            Cmb_genero.setSelectedItem(odontologo.getGenero());
            txt_numero_licencia.setText(odontologo.getNumero_licencia());
            
             // Mostrar la imagen si existe
        byte[] imagenBytes = odontologo.getImagen();
        if (imagenBytes != null) {
            ImageIcon imageIcon = new ImageIcon(imagenBytes);
            Image image = imageIcon.getImage().getScaledInstance(jLabel_foto.getWidth(), jLabel_foto.getHeight(), Image.SCALE_SMOOTH);
            jLabel_foto.setIcon(new ImageIcon(image));
        } else {
            jLabel_foto.setIcon(null); // O puedes establecer una imagen por defecto
        }
            
        } else {
            JOptionPane.showMessageDialog(this, "No encontrado.");
        }
    }

}
