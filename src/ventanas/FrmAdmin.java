package ventanas;


import com.mysql.cj.Constants;
import controlador.Ctrl_Usuario;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class FrmAdmin extends javax.swing.JFrame {

    private Image background_imagen;

    public FrmAdmin() {
        
        setUndecorated(true);
        
        initComponents();
        
         // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0,0,getWidth(), getHeight(), 10,10));
        
        //cargarDatosUsuario(1);

        // Obtiene el nombre de usuario que ha iniciado sesión desde el formulario de login
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();

// Establece el texto del JLabel para mostrar el nombre de usuario
        jLabel_usuario.setText("Hola  " + nombreUsuario + "  Bienvenido.");
// Obtiene el tipo de nivel del usuario desde el formulario de login
        String tipoNivel = FrmLogin.getUsuarioTipoNivel();
// Establece el texto del JLabel para mostrar el tipo de nivel del usuario
        jLabel_TipoNivel.setText("Tipo Nivel : " + tipoNivel);
        
        
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

        // Btn_nuevoUsuario.setVisible(false);
        jLabel_Wallpaper.setVisible(false);
        jLabel_usuarios.setVisible(false);
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

    }

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
        jLabel1 = new javax.swing.JLabel();
        Btn_nuevoUsuario = new javax.swing.JButton();
        jLabel_foto = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        jLabel_usuarios = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();
        Btn_cerrar = new javax.swing.JButton();
        jLabel_titulo = new javax.swing.JLabel();
        Btn_minimizar = new javax.swing.JButton();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_TipoNivel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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
        Btn_citas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_citasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_citasMouseExited(evt);
            }
        });

        Btn_inventario.setBackground(new java.awt.Color(255, 255, 255));
        Btn_inventario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_inventario.setText("Inventario");
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/perfil-del-usuario.png"))); // NOI18N

        Btn_nuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        Btn_nuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_nuevoUsuario.setText("Usuarios");
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

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Btn_odontologos, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(btn_pacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(jLabel_foto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1))
                    .addComponent(Btn_facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_citas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_cerrar_sesion)
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Btn_nuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btn_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(Btn_odontologos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btn_pacientes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(Btn_facturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Btn_citas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(Btn_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_nuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(Btn_cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

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
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 40, -1));

        jLabel_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/letra-x.png"))); // NOI18N
        jPanel1.add(jLabel_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, 30));
        jPanel1.add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 214, 240, 180));

        Btn_cerrar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_cerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
        jPanel1.add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 40, 30));

        jLabel_titulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_titulo.setForeground(new java.awt.Color(51, 51, 51));
        jLabel_titulo.setText("Sistema de informacion MJVG");
        jPanel1.add(jLabel_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

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
        jPanel1.add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, 30));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 450, 30));

        jLabel_TipoNivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_TipoNivel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel_TipoNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 470, 260, 30));

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
        int posicion = btnMenu.getX();
        if (posicion > 5) {
            Animacion.Animacion.mover_izquierda(211, 5, 2, 2, btnMenu);
            Animacion.Animacion.mover_izquierda(5, -200, 2, 2, pnlMenu);
        } else {
            Animacion.Animacion.mover_derecha(5, 210, 2, 2, btnMenu);
            Animacion.Animacion.mover_derecha(-200, 5, 2, 2, pnlMenu);
        }
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
        jLabel_Wallpaper.setVisible(true);
        jLabel_usuarios.setVisible(true);
    }//GEN-LAST:event_Btn_nuevoUsuarioMouseEntered

    private void Btn_nuevoUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_nuevoUsuarioMouseExited
        Btn_nuevoUsuario.setBackground(Color.white);
        Btn_nuevoUsuario.setForeground(Color.BLACK);
        jLabel_Wallpaper.setVisible(false);
        jLabel_usuarios.setVisible(false);
    }//GEN-LAST:event_Btn_nuevoUsuarioMouseExited

    private void Btn_cerrar_sesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrar_sesionMouseEntered
        Btn_cerrar_sesion.setBackground(new Color(255,51,51));
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
        Btn_cerrar.setBackground(new Color(255,51,51));
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
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btn_pacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_TipoNivel;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_foto;
    private javax.swing.JLabel jLabel_titulo;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JLabel jLabel_usuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables

    
    // Método para mostrar la imagen en jLabel_foto
//    private void mostrarImagen(byte[] imagenBytes) {
//        if (imagenBytes != null) {
//            try {
//                // Convertir el array de bytes a un objeto Image
//                ByteArrayInputStream bais = new ByteArrayInputStream(imagenBytes);
//                Image imagen = ImageIO.read(bais);
//
//                // Escalar la imagen a las dimensiones del jLabel_foto
//                Image scaledImagen = imagen.getScaledInstance(jLabel_foto.getWidth(), jLabel_foto.getHeight(), Image.SCALE_SMOOTH);
//
//                // Establecer la imagen escalada como el ícono del jLabel_foto
//                jLabel_foto.setIcon(new ImageIcon(scaledImagen));
//            } catch (IOException e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            jLabel_foto.setIcon(null); // Si no hay imagen, eliminar el ícono
//        }
//    }

    // Método para cargar datos de un usuario, incluida la imagen
//    private void cargarDatosUsuario(int id_usuario) {
//        System.out.println("Cargando datos para el usuario con ID: " + id_usuario); // Mensaje de depuración
//
//        Ctrl_Usuario controlUsuario = new Ctrl_Usuario();
//        byte[] imagenBytes = controlUsuario.obtenerImagenUsuarioPorId(id_usuario);
//        mostrarImagen(imagenBytes);
//    }

}
