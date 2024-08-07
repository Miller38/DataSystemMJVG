package ventanas;

import conexion.Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pdf.GeneradorPDF;

/**
 *
 * @author Miller
 */
public class FrmGestionarUsuarios extends javax.swing.JFrame {

    public FrmGestionarUsuarios() {

        setUndecorated(true);

        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
         // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0,0,getWidth(), getHeight(), 20,20));

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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_usuarios = new javax.swing.JTable();
        Btn_listarUsuarios = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        Btn_reporte_pdf = new javax.swing.JButton();
        Btn_minimizar = new javax.swing.JButton();
        Btn_cerrar = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Lista de usuarios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_usuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTable_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nombre", "email", "telefono", "username", "tipo nivel", "estatus", "registrado por"
            }
        ));
        jScrollPane1.setViewportView(jTable_usuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 760, 230));

        Btn_listarUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        Btn_listarUsuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_listarUsuarios.setText("Listar usuarios");
        Btn_listarUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_listarUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_listarUsuariosMouseExited(evt);
            }
        });
        Btn_listarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listarUsuariosActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_listarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, -1, -1));

        Btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        Btn_reporte_pdf.setBackground(new java.awt.Color(255, 255, 255));
        Btn_reporte_pdf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Btn_reporte_pdf.setText("Reporte PDF");
        Btn_reporte_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reporte_pdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reporte_pdfMouseExited(evt);
            }
        });
        Btn_reporte_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_reporte_pdfActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_reporte_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 780, 310));

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
        getContentPane().add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

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
        getContentPane().add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, -1));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_listarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listarUsuariosActionPerformed
        CargarTablaUsuarios();
    }//GEN-LAST:event_Btn_listarUsuariosActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        dispose();
        FrmNuevoUsuario frmNuevoUsuario = new FrmNuevoUsuario();
        frmNuevoUsuario.setVisible(true);
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_reporte_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_reporte_pdfActionPerformed
        GeneradorPDF generadorPdf = new GeneradorPDF();
        generadorPdf.generarReporteUsuarios();
    }//GEN-LAST:event_Btn_reporte_pdfActionPerformed

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
        dispose();
        FrmNuevoUsuario frmNuevoUsuario = new FrmNuevoUsuario();
        frmNuevoUsuario.setVisible(true);
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
        Btn_cerrar.setBackground(new Color(0, 153, 204));
        Btn_cerrar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_cerrarMouseEntered

    private void Btn_cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_cerrarMouseExited
        Btn_cerrar.setBackground(Color.white);
        Btn_cerrar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_cerrarMouseExited

    private void Btn_listarUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_listarUsuariosMouseEntered
         Btn_listarUsuarios.setBackground(new Color(0, 153, 204));
        Btn_listarUsuarios.setForeground(Color.white);
    }//GEN-LAST:event_Btn_listarUsuariosMouseEntered

    private void Btn_listarUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_listarUsuariosMouseExited
        Btn_listarUsuarios.setBackground(Color.white);
        Btn_listarUsuarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_listarUsuariosMouseExited

    private void Btn_reporte_pdfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporte_pdfMouseEntered
         Btn_reporte_pdf.setBackground(new Color(0, 153, 204));
        Btn_reporte_pdf.setForeground(Color.white);
    }//GEN-LAST:event_Btn_reporte_pdfMouseEntered

    private void Btn_reporte_pdfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reporte_pdfMouseExited
        Btn_reporte_pdf.setBackground(Color.white);
        Btn_reporte_pdf.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_reporte_pdfMouseExited

    private void Btn_regresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_regresarMouseEntered
          Btn_regresar.setBackground(new Color(0, 153, 204));
        Btn_regresar.setForeground(Color.white);
    }//GEN-LAST:event_Btn_regresarMouseEntered

    private void Btn_regresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_regresarMouseExited
         Btn_regresar.setBackground(Color.white);
        Btn_regresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_Btn_regresarMouseExited

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
            java.util.logging.Logger.getLogger(FrmGestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_listarUsuarios;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton Btn_reporte_pdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_usuarios;
    // End of variables declaration//GEN-END:variables

// -------------------------------- Metodo para mostrar todos los usuarios -----------------------------------------// 
    /**
     * Método para cargar la tabla de usuarios
     */
    private void CargarTablaUsuarios() {
        // Establece la conexión a la base de datos
        Connection con = Conexion.conectar();
        // Crea un modelo de tabla por defecto
        DefaultTableModel model = new DefaultTableModel();
        // Consulta SQL para obtener todos los usuarios
        String sql = "SELECT id_usuario, nombre_usuario, email, telefono, username, tipo_nivel, estatus, registrado_por FROM tb_usuarios";
        Statement st;

        try {
            // Crea una declaración para ejecutar la consulta SQL
            st = con.createStatement();
            // Ejecuta la consulta SQL y obtiene los resultados
            ResultSet rs = st.executeQuery(sql);
            // Inicializa la tabla de usuarios con el modelo creado
            jTable_usuarios = new JTable(model);
            // Asocia la tabla al panel de desplazamiento
            jScrollPane1.setViewportView(jTable_usuarios);

            // Agrega columnas al modelo de la tabla
            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("email");
            model.addColumn("telefono");
            model.addColumn("username");
            model.addColumn("tipo nivel");
            model.addColumn("estatus");
            model.addColumn("registrado_por");

            // Recorre los resultados de la consulta
            while (rs.next()) {
                // Crea un array de objetos para almacenar una fila
                Object fila[] = new Object[8]; // Cambiado a 8 para coincidir con el número de columnas
                // Asigna los valores de cada columna a la fila
                for (int i = 0; i < 8; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                // Agrega la fila al modelo de la tabla
                model.addRow(fila);
            }
            // Cierra la conexión a la base de datos
            con.close();
        } catch (SQLException e) {
            // Maneja cualquier error que ocurra durante la consulta y muestra un mensaje de error
            System.out.println("Error al llenar la tabla usuarios " + e.getMessage());
        }
    }
}
