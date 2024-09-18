
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
import pdf.GeneradorPDFOdontologos;


/**
 *
 * @author Miller
 */
public class FrmGestionarOdontologos extends javax.swing.JFrame {

    
    public FrmGestionarOdontologos() {
        
        setUndecorated(true);
        
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
         String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
        jLabel_usuario.setText("Usuario: " + nombreUsuario);
        
         // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0,0,getWidth(), getHeight(), 20,20));
        
          // -------------------------------------Colocar imagen de fondo cabecera----------------------------------------// 
        // Crea un objeto ImageIcon con la imagen ubicada en el directorio especificado
        ImageIcon wallpaper_cabecera = new ImageIcon("src/images/fondo3.jpg");
        // Escala la imagen a las dimensiones actuales del jLabel_Wallpaper
       // Obtiene la imagen del ImageIcon
       Icon icono_ = new ImageIcon(
                    wallpaper_cabecera.getImage().getScaledInstance( // Escala la imagen
                            jLabel_cabecera.getWidth(),  // Ancho actual del jLabel_Wallpaper
                            jLabel_cabecera.getHeight(),  // Alto actual del jLabel_Wallpaper
                            Image.SCALE_DEFAULT   // Algoritmo de escalado (por defecto)
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
        Btn_reportePDF = new javax.swing.JButton();
        Btn_listarOdontologos = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_odontologos = new javax.swing.JTable();
        Btn_cerrar = new javax.swing.JButton();
        Btn_minimizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jLabel_cabecera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Btn_reportePDF.setBackground(new java.awt.Color(255, 255, 255));
        Btn_reportePDF.setText("Reporte PDF");
        Btn_reportePDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_reportePDFActionPerformed(evt);
            }
        });

        Btn_listarOdontologos.setBackground(new java.awt.Color(255, 255, 255));
        Btn_listarOdontologos.setText("Listar Odontologos");
        Btn_listarOdontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_listarOdontologosActionPerformed(evt);
            }
        });

        Btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha.png"))); // NOI18N
        Btn_regresar.setText("  Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });

        jTable_odontologos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Direccion", "Ciudad", "Telefono", "Email", "Identificacion", "Genero"
            }
        ));
        jScrollPane2.setViewportView(jTable_odontologos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(Btn_regresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Btn_reportePDF)
                .addGap(18, 18, 18)
                .addComponent(Btn_listarOdontologos)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_listarOdontologos)
                            .addComponent(Btn_reportePDF)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(Btn_regresar)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 770, 310));

        Btn_cerrar.setText("X");
        Btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_cerrarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        Btn_minimizar.setText("-");
        Btn_minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_minimizarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listar Odontologos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 220, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 200, 20));
        getContentPane().add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_listarOdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_listarOdontologosActionPerformed
        CargarTablaOdontologos();
    }//GEN-LAST:event_Btn_listarOdontologosActionPerformed

    private void Btn_reportePDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_reportePDFActionPerformed
        GeneradorPDFOdontologos generadorPDFOdontologos = new GeneradorPDFOdontologos();
        generadorPDFOdontologos.generarReporteOdontologos();
    }//GEN-LAST:event_Btn_reportePDFActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_cerrarActionPerformed
      this.dispose();
    }//GEN-LAST:event_Btn_cerrarActionPerformed

    private void Btn_minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_minimizarActionPerformed
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_Btn_minimizarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGestionarOdontologos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarOdontologos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarOdontologos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionarOdontologos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionarOdontologos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_listarOdontologos;
    private javax.swing.JButton Btn_minimizar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton Btn_reportePDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_odontologos;
    // End of variables declaration//GEN-END:variables

// -------------------------------- Metodo para mostrar todos los usuarios -----------------------------------------// 
    /**
     * Método para cargar la tabla de usuarios
     */
    private void CargarTablaOdontologos(){
         // Establece la conexión a la base de datos
         Connection con = Conexion.conectar();
         // Crea un modelo de tabla por defecto
         DefaultTableModel model = new DefaultTableModel();
          // Consulta SQL para obtener todos los usuarios
        String sql = "SELECT nombre_odontologo, apellido, direccion, ciudad, telefono, email, identificacion, genero FROM tb_odontologos";
        Statement st;
        
        try{
             // Crea una declaración para ejecutar la consulta SQL
             st = con.createStatement();
              // Ejecuta la consulta SQL y obtiene los resultados
              ResultSet rs = st.executeQuery(sql);
              // Inicializa la tabla de usuarios con el modelo creado
              jTable_odontologos = new JTable(model);
                // Asocia la tabla al panel de desplazamiento
                jScrollPane2.setViewportView(jTable_odontologos);
                
                 // Agrega columnas al modelo de la 
                 model.addColumn("nombre");
                 model.addColumn("apellido");
                 model.addColumn("direccion");
                 model.addColumn("ciudad");
                 model.addColumn("telefono");
                 model.addColumn("email");
                 model.addColumn("identificacion");
                 model.addColumn("genero");
                 
                 // Recorre los resultados de la consulta
                 while(rs.next()){
                      // Crea un array de objetos para almacenar una fila
                      Object fila[] = new Object[8]; // Cambiado a 8 para coincidir con el número de columnas
                      // Asigna los valores de cada columna a la fila
                      for(int i = 0; i  < 8; i ++){
                          fila[i] = rs.getObject(i + 1);
                      }
                      // Agrega la fila al modelo de la tabla
                      model.addRow(fila);
                 }
                   // Cierra la conexión a la base de datos
                   con.close();
        } catch (SQLException e){
             // Maneja cualquier error que ocurra durante la consulta y muestra un mensaje de error
            System.out.println("Error al llenar la tabla usuarios " + e.getMessage());
        }              
    }
}
