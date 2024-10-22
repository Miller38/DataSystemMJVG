package ventanas;

import com.mysql.cj.Constants;
import controlador.Ctrl_Cita;
import controlador.Ctrl_Odontologo;
import controlador.Ctrl_Paciente;
import controlador.Ctrl_Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class FrmAdmin extends javax.swing.JFrame {

    private Image background_imagen;

    public FrmAdmin() {

        setUndecorated(true);

        initComponents();

        mostrarCantidadUsuarios();
        actualizarCantidadUsuarios();
        mostrarCantidadOdontologos();
        actualizarCantidadOdontologos();
        mostrarCantidadPacientes();
        actualizarCantidadPacientes();
        // Llamada para mostrar citas confirmadas
        Ctrl_Cita controlCita = new Ctrl_Cita();
        controlCita.mostrarCitasConfirmadas(jLabel_citaConfirmada);
        controlCita.mostrarCitasCanceladas(jLabel_citaCancelada);
        controlCita.mostrarCitasPendientes(jLabel_citaPendiente);
        // Instanciar el controlador de usuario
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();

        //cargarDatosUsuario(1);
        // Obtiene el nombre de usuario que ha iniciado sesión desde el formulario de login
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();

// Obtener la imagen del usuario logueado
        byte[] imagenUsuario = controlUsuario.obtenerImagenUsuario(nombreUsuario);

// Mostrar la imagen en un JLabel
        if (imagenUsuario != null) {
            ImageIcon imageIcon = new ImageIcon(imagenUsuario);
            Image image = imageIcon.getImage().getScaledInstance(jLabelImagen.getWidth(), jLabelImagen.getHeight(), Image.SCALE_SMOOTH);
            jLabelImagen.setIcon(new ImageIcon(image));
        } else {
            jLabelImagen.setIcon(null); // O establecer una imagen por defecto
        }

        // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 10, 10));

// Establece el texto del JLabel para mostrar el nombre de usuario
        jLabel_usuario.setText("Hola  " + nombreUsuario + "  Bienvenid@.");
// Obtiene el tipo de nivel del usuario desde el formulario de login
        String tipoNivel = FrmLogin.getUsuarioTipoNivel();
// Establece el texto del JLabel para mostrar el tipo de nivel del usuario
        jLabel_TipoNivel.setText(tipoNivel);

// Verifica si el tipo de nivel es "Administrador" para mostrar u ocultar el botón de nuevo usuario
        if ("Administrador".equals(tipoNivel)) {
            // Si el tipo de nivel es "Administrador", se muestra el botón de nuevo usuario
            Btn_nuevoUsuario.setVisible(true);
        } else {
            // Si el tipo de nivel no es "Administrador", se oculta el botón de nuevo usuario
            Btn_nuevoUsuario.setVisible(false);
        }

        //  setBackground_Panel("src/images/bg-gradiente.jpg", jPanel1);
        this.setLocationRelativeTo(null);
        this.setSize(900, 512);
        this.setDefaultCloseOperation(FrmAdmin.EXIT_ON_CLOSE);

        /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Colocar imagen de fondo
    * ------------------------------------------------------------------------------------------------------------------------
         */
        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
        // ImageIcon wallpaper = new ImageIcon("src/images/bg-gradiente.jpg");
        // Escala la imagen a las dimensiones actuales del jLabel_Wallpaper
        // Obtiene la imagen del ImageIcon
//        Icon icono = new ImageIcon(
//                wallpaper.getImage().getScaledInstance( // Escala la imagen
//                        jLabel_Wallpaper.getWidth(), // Ancho actual del jLabel_Wallpaper
//                        jLabel_Wallpaper.getHeight(), // Alto actual del jLabel_Wallpaper
//                        Image.SCALE_DEFAULT // Algoritmo de escalado (por defecto)
//                )
//        );
        // Establece el nuevo icono (imagen escalada) en el jLabel_Wallpaper
        //jLabel_Wallpaper.setIcon(icono);
        // Vuelve a pintar el contenedor para asegurarse de que la imagen se renderice correctamente
        //  this.repaint();
        // Inicia el temporizador.
        timer.start();

    }

    //------------------------------------ metodo para mostrar la hora y la fecha ------------------------------------------//
    //Crea una instancia de Timer que se ejecuta cada 1000 milisegundos (1 segundo).
    Timer timer = new Timer(1000, new ActionListener() {
        // Define la acción que se ejecutará cada vez que el temporizador se active.
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtiene la fecha y hora actual del sistema.
            Calendar cal = new GregorianCalendar();
            // Declara variables para almacenar la hora, minutos, segundos, día, mes y año.
            int hh, mm, ss, dia, mes, aa;
            // Obtiene la hora actual.
            hh = cal.get(Calendar.HOUR);
            // Obtiene los segundos actuales.
            ss = cal.get(Calendar.SECOND);
            // Obtiene los minutos actuales.
            mm = cal.get(Calendar.MINUTE);
            // Obtiene el día del mes actual.
            dia = cal.get(Calendar.DAY_OF_MONTH);
            // Obtiene el mes actual (nota: los meses empiezan desde 0 en Calendar, por lo que enero es 0).
            mes = cal.get(Calendar.MONTH) + 1;
            // Obtiene el año actual.
            aa = cal.get(Calendar.YEAR);
            // Actualiza la etiqueta Lb_hora con la hora, minutos y segundos actuales.
            Lb_hora.setText(hh + ":" + mm + ":" + ss);
            // Actualiza la etiqueta Lb_fecha con el día, mes y año actuales.
            Lb_fecha.setText(dia + "/ " + mes + "/ " + aa);
        }
    });

    public void setBackground_Panel(String ruta_imagen, JPanel panel1) {
        panel1.setOpaque(false);
        background_imagen = new ImageIcon(ruta_imagen).getImage();
        panel1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel(){

            @Override
            public void paintComponent(Graphics g){

                int width = this.getSize().width;
                int heigth = this.getSize().height;

                if(background_imagen != null){
                    g.drawImage(background_imagen,0,0,width,heigth,null);
                }

                super.paintComponent(g);
            }

        };
        pnlMenu = new javax.swing.JPanel();
        Btn_cerrar_sesion = new javax.swing.JButton();
        btn_pacientes = new javax.swing.JButton();
        Btn_facturacion = new javax.swing.JButton();
        Btn_citas = new javax.swing.JButton();
        Btn_inventario = new javax.swing.JButton();
        Btn_odontologos = new javax.swing.JButton();
        Btn_nuevoUsuario = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();
        jLabel_TipoNivel = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        Btn_cerrar = new javax.swing.JButton();
        jLabel_titulo = new javax.swing.JLabel();
        Btn_minimizar = new javax.swing.JButton();
        jLabel_usuario = new javax.swing.JLabel();
        Lb_fecha = new javax.swing.JLabel();
        Lb_hora = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_contarUsuarios = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel_contarPacientes = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_contarOdontologos = new javax.swing.JLabel();
        jLabel_citaPendiente = new javax.swing.JLabel();
        jLabel_citaConfirmada = new javax.swing.JLabel();
        jLabel_citaCancelada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        pnlMenu.setBorder(dropShadowBorder1);

        Btn_cerrar_sesion.setBackground(new java.awt.Color(255, 255, 255));
        Btn_cerrar_sesion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        Btn_cerrar_sesion.setText("  Cerrar sesion");
        Btn_cerrar_sesion.setToolTipText("Click para cerrar session");
        Btn_cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_cerrar_sesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_cerrar_sesionMouseExited(evt);
            }
        });
        Btn_cerrar_sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cerrar_sesionActionPerformed(evt);
            }
        });

        btn_pacientes.setBackground(new java.awt.Color(255, 255, 255));
        btn_pacientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_pacientes.setText("Pacientes");
        btn_pacientes.setToolTipText("Click para gestionar pacientes");
        btn_pacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pacientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pacientesMouseExited(evt);
            }
        });
        btn_pacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pacientesActionPerformed(evt);
            }
        });

        Btn_facturacion.setBackground(new java.awt.Color(255, 255, 255));
        Btn_facturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_facturacion.setText("Facturacion");
        Btn_facturacion.setToolTipText("Click para gestionar facturas");
        Btn_facturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_facturacionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_facturacionMouseExited(evt);
            }
        });
        Btn_facturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_facturacionActionPerformed(evt);
            }
        });

        Btn_citas.setBackground(new java.awt.Color(255, 255, 255));
        Btn_citas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_citas.setText("Citas");
        Btn_citas.setToolTipText("Click para gestionar citas");
        Btn_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_citasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_citasMouseExited(evt);
            }
        });
        Btn_citas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_citasActionPerformed(evt);
            }
        });

        Btn_inventario.setBackground(new java.awt.Color(255, 255, 255));
        Btn_inventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_inventario.setText("Inventario");
        Btn_inventario.setToolTipText("Click para gestionar el inventario");
        Btn_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_inventarioMouseExited(evt);
            }
        });

        Btn_odontologos.setBackground(new java.awt.Color(255, 255, 255));
        Btn_odontologos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_odontologos.setText("Odontologos");
        Btn_odontologos.setToolTipText("Click para gestionar odontologos");
        Btn_odontologos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_odontologosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_odontologosMouseExited(evt);
            }
        });
        Btn_odontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_odontologosActionPerformed(evt);
            }
        });

        Btn_nuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        Btn_nuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_nuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        Btn_nuevoUsuario.setText("   Usuarios");
        Btn_nuevoUsuario.setToolTipText("Click para gestionar usuarios");
        Btn_nuevoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_nuevoUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_nuevoUsuarioMouseExited(evt);
            }
        });
        Btn_nuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_nuevoUsuarioActionPerformed(evt);
            }
        });

        jLabel_TipoNivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_TipoNivel.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_TipoNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_citas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_cerrar_sesion)
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Btn_nuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Btn_odontologos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel_TipoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(312, 312, 312))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel_TipoNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_odontologos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btn_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Btn_facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Btn_citas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Btn_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_nuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 200, 530));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menus.png"))); // NOI18N
        btnMenu.setToolTipText("");
        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/images/menus1.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, -1));

        Btn_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_cerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_cerrar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_cerrar.setText("x");
        Btn_cerrar.setToolTipText("Cerrar");
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
        jPanel1.add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 40, 30));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_titulo.setText("Sistema de informacion MJVG");
        jPanel1.add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        Btn_minimizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_minimizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_minimizar.setForeground(new java.awt.Color(0, 0, 0));
        Btn_minimizar.setText("-");
        Btn_minimizar.setToolTipText("minimizar");
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
        jPanel1.add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, 30));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 450, 30));

        Lb_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Lb_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 110, 20));

        Lb_hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(Lb_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 470, 110, 20));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });

        jLabel_contarUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_contarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_contarUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/friend.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_contarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_contarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 140, 100));

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/friend.png"))); // NOI18N

        jLabel_contarPacientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_contarPacientes.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_contarPacientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_contarPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_contarPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 150, 100));

        jPanel3.setBackground(new java.awt.Color(0, 51, 255));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/friend.png"))); // NOI18N

        jLabel_contarOdontologos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_contarOdontologos.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_contarOdontologos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_contarOdontologos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_contarOdontologos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 140, 100));

        jLabel_citaPendiente.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_citaPendiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel_citaPendiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 140, 20));

        jLabel_citaConfirmada.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_citaConfirmada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel_citaConfirmada, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 150, 20));

        jLabel_citaCancelada.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_citaCancelada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel_citaCancelada, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, 160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 886, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed

    }//GEN-LAST:event_btnMenuActionPerformed

    private void Btn_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrar_sesionActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_cerrar_sesionActionPerformed

    private void Btn_nuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_nuevoUsuarioActionPerformed
        //dispose();
        FrmNuevoUsuario frmNuevoUsuario = new FrmNuevoUsuario();
        frmNuevoUsuario.setVisible(true);

    }//GEN-LAST:event_Btn_nuevoUsuarioActionPerformed

    private void Btn_nuevoUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_nuevoUsuarioMouseEntered
        Btn_nuevoUsuario.setBackground(new Color(0, 153, 204));
        Btn_nuevoUsuario.setForeground(Color.white);

    }//GEN-LAST:event_Btn_nuevoUsuarioMouseEntered

    private void Btn_nuevoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_nuevoUsuarioMouseExited
        Btn_nuevoUsuario.setBackground(Color.white);
        Btn_nuevoUsuario.setForeground(Color.BLACK);

    }//GEN-LAST:event_Btn_nuevoUsuarioMouseExited

    private void Btn_cerrar_sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrar_sesionMouseEntered
        Btn_cerrar_sesion.setBackground(new Color(255, 51, 51));
        Btn_cerrar_sesion.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrar_sesionMouseEntered

    private void Btn_cerrar_sesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrar_sesionMouseExited
        Btn_cerrar_sesion.setBackground(Color.white);
        Btn_cerrar_sesion.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrar_sesionMouseExited

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseEntered
        Btn_cerrar.setBackground(new Color(255, 51, 51));
        Btn_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrarMouseEntered

    private void Btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseExited
        Btn_cerrar.setBackground(Color.white);
        Btn_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrarMouseExited

    private void btn_pacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pacientesActionPerformed
        FrmPacientes frmPacientes = new FrmPacientes();
        frmPacientes.setVisible(true);
    }//GEN-LAST:event_btn_pacientesActionPerformed

    private void btn_pacientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pacientesMouseEntered
        btn_pacientes.setBackground(new Color(0, 153, 204));
        btn_pacientes.setForeground(Color.white);
    }//GEN-LAST:event_btn_pacientesMouseEntered

    private void btn_pacientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pacientesMouseExited
        btn_pacientes.setBackground(Color.white);
        btn_pacientes.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_pacientesMouseExited

    private void Btn_facturacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_facturacionMouseEntered
        Btn_facturacion.setBackground(new Color(0, 153, 204));
        Btn_facturacion.setForeground(Color.white);
    }//GEN-LAST:event_Btn_facturacionMouseEntered

    private void Btn_facturacionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_facturacionMouseExited
        Btn_facturacion.setBackground(Color.white);
        Btn_facturacion.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_facturacionMouseExited

    private void Btn_citasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_citasMouseEntered
        Btn_citas.setBackground(new Color(0, 153, 204));
        Btn_citas.setForeground(Color.white);
    }//GEN-LAST:event_Btn_citasMouseEntered

    private void Btn_citasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_citasMouseExited
        Btn_citas.setBackground(Color.white);
        Btn_citas.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_citasMouseExited

    private void Btn_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_inventarioMouseEntered
        Btn_inventario.setBackground(new Color(0, 153, 204));
        Btn_inventario.setForeground(Color.white);
    }//GEN-LAST:event_Btn_inventarioMouseEntered

    private void Btn_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_inventarioMouseExited
        Btn_inventario.setBackground(Color.white);
        Btn_inventario.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_inventarioMouseExited

    private void Btn_odontologosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_odontologosMouseEntered
        Btn_odontologos.setBackground(new Color(0, 153, 204));
        Btn_odontologos.setForeground(Color.white);
    }//GEN-LAST:event_Btn_odontologosMouseEntered

    private void Btn_odontologosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_odontologosMouseExited
        Btn_odontologos.setBackground(Color.white);
        Btn_odontologos.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_odontologosMouseExited

    private void Btn_minimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseEntered
        Btn_minimizar.setBackground(new Color(0, 153, 204));
        Btn_minimizar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_minimizarMouseEntered

    private void Btn_minimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_minimizarMouseExited
        Btn_minimizar.setBackground(Color.white);
        Btn_minimizar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_minimizarMouseExited

    private void Btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_minimizarActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarActionPerformed

    private void Btn_facturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_facturacionActionPerformed
        FrmFactura frmFactura = new FrmFactura();
        frmFactura.setVisible(true);
    }//GEN-LAST:event_Btn_facturacionActionPerformed

    private void Btn_odontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_odontologosActionPerformed
        FrmOdontologo frmOdontologo = new FrmOdontologo();
        frmOdontologo.setVisible(true);
    }//GEN-LAST:event_Btn_odontologosActionPerformed

    private void Btn_citasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_citasActionPerformed
       FrmAgendarCita frmAgendarCita = new FrmAgendarCita();
       frmAgendarCita.setVisible(true);
    }//GEN-LAST:event_Btn_citasActionPerformed

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // Cambia el fondo del panel a blanco
    jPanel2.setBackground(Color.WHITE);
    
    // Cambia el color de los componentes dentro del panel a negro
    for (Component c : jPanel2.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.BLACK); // Cambia el color de las letras
        }
    }
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
      // Restaurar el color de fondo original (azul)
    jPanel2.setBackground(new Color(51, 51, 255));
    
    // Restaurar el color de las letras a blanco
    for (Component c : jPanel2.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.WHITE);  // Letras blancas
        }
    }
    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
             // Cambia el fondo del panel a blanco
    jPanel3.setBackground(Color.WHITE);
    
    // Cambia el color de los componentes dentro del panel a negro
    for (Component c : jPanel3.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.BLACK); // Cambia el color de las letras
        }
    }
    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
         // Restaurar el color de fondo original (azul)
    jPanel3.setBackground(new Color(51, 51, 255));
    
    // Restaurar el color de las letras a blanco
    for (Component c : jPanel3.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.WHITE);  // Letras blancas
        }
    }
    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
            // Cambia el fondo del panel a blanco
    jPanel4.setBackground(Color.WHITE);
    
    // Cambia el color de los componentes dentro del panel a negro
    for (Component c : jPanel4.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.BLACK); // Cambia el color de las letras
        }
    }
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
         // Restaurar el color de fondo original (azul)
    jPanel4.setBackground(new Color(51, 51, 255));
    
    // Restaurar el color de las letras a blanco
    for (Component c : jPanel4.getComponents()) {
        if (c instanceof JLabel) {
            c.setForeground(Color.WHITE);  // Letras blancas
        }
    }
    }//GEN-LAST:event_jPanel4MouseExited

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
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_cerrar_sesion;
    private javax.swing.JButton Btn_citas;
    private javax.swing.JButton Btn_facturacion;
    private javax.swing.JButton Btn_inventario;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_nuevoUsuario;
    private javax.swing.JButton Btn_odontologos;
    private javax.swing.JLabel Lb_fecha;
    private javax.swing.JLabel Lb_hora;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btn_pacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabel_TipoNivel;
    private javax.swing.JLabel jLabel_citaCancelada;
    private javax.swing.JLabel jLabel_citaConfirmada;
    private javax.swing.JLabel jLabel_citaPendiente;
    private javax.swing.JLabel jLabel_contarOdontologos;
    private javax.swing.JLabel jLabel_contarPacientes;
    private javax.swing.JLabel jLabel_contarUsuarios;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables

    /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Metodo para mostrar cantidad de usuarios
    * ------------------------------------------------------------------------------------------------------------------------
     */
    private void mostrarCantidadUsuarios() {
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
        int cantidadUsuarios = controlUsuario.contarUsuarios();

        jLabel_contarUsuarios.setText("cantidad usuarios " + cantidadUsuarios);
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                   Metodo para actualizar la cantidad de usuarios 
    //---------------------------------------------------------------------------------------------------------------------//
    private void actualizarCantidadUsuarios() {
        Ctrl_Usuario controlUsuario = new Ctrl_Usuario(); // Crea una instancia del controlador de usuarios
        int cantidadUsuarios = controlUsuario.contarUsuarios(); // Obtiene la cantidad de usuarios
        jLabel_contarUsuarios.setText("usuarios  " + cantidadUsuarios); // Actualiza el JLabel
    }

    /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Metodo para mostrar cantidad de usuarios
    * ------------------------------------------------------------------------------------------------------------------------
     */
    private void mostrarCantidadOdontologos() {
        Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();
        int cantidadOdontologos = controlOdontologo.contarOdontologo();

        jLabel_contarOdontologos.setText("cantidad odontologos " + cantidadOdontologos);
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                   Metodo para actualizar la cantidad de usuarios 
    //---------------------------------------------------------------------------------------------------------------------//
    private void actualizarCantidadOdontologos() {
        Ctrl_Odontologo controlOdontologo = new Ctrl_Odontologo();
        int cantidadOdontologos = controlOdontologo.contarOdontologo(); // Obtiene la cantidad de usuarios
        jLabel_contarOdontologos.setText("odontologos  " + cantidadOdontologos); // Actualiza el JLabel
    }

    /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                            Metodo para mostrar cantidad de Pacientes
    * ------------------------------------------------------------------------------------------------------------------------
     */
    private void mostrarCantidadPacientes() {
        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        int cantidadPacientes = controlPaciente.contarPacientes();

        jLabel_contarPacientes.setText("cantidad pacientes " + cantidadPacientes);
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                   Metodo para actualizar la cantidad de Pacientes 
    //---------------------------------------------------------------------------------------------------------------------//
    private void actualizarCantidadPacientes() {
        Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
        int cantidadPacientes = controlPaciente.contarPacientes(); // Obtiene la cantidad de usuarios
        jLabel_contarPacientes.setText("pacientes  " + cantidadPacientes); // Actualiza el JLabel
    }

}
