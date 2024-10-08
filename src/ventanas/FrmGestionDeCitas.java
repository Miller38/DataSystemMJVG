
package ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Miller
 */
public class FrmGestionDeCitas extends javax.swing.JFrame {    
   
    // Colores para el tema claro
    private Color fondoClaro = new Color(234, 236, 238); // Blanco atenuado para evitar el deslumbramiento.
    private Color textoClaro = new Color(253, 254, 254 ); // Negro suave para un buen contraste sin ser demasiado fuerte.
    private Color botonClaro = new Color(236, 240, 241 ); // Gris claro para botones que contraste bien con el fondo claro.

    // Colores para el tema oscuro
    private Color fondoOscuro = new Color(28, 40, 51);  // ok
    private Color textoOscuro = new Color(23, 32, 42 ); // Blanco suave para una buena legibilidad en el fondo oscuro.
    private Color botonOscuro = new Color(242, 244, 244); // Gris medio para botones que mantenga el contraste con el fondo oscuro.
    
    
     // Iconos
    private ImageIcon iconoSol = new ImageIcon(getClass().getResource("/images/sol.png"));
    private ImageIcon iconoLuna = new ImageIcon(getClass().getResource("/images/luna_1.png"));

    
    public FrmGestionDeCitas() {
        
         setUndecorated(true);
        
        initComponents();
        
        this.setSize(758, 423); // Establece el tamaño de la ventana
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setResizable(false); // Evita que la ventana se redimensione
        aplicarTemaClaro(); // Aplica el tema claro al iniciar
        
        jToggleButton1.setIcon(iconoLuna); // Establece el ícono inicial del botón como luna
        
         // Obtiene el nombre del usuario logueado desde el formulario de login
        String nombreUsuario = FrmLogin.getNombreUsuarioLogueado();
      // Establece el texto del JLabel con el nombre del usuario logueado
        jLabel_usuario.setText("Usuario " + nombreUsuario);
       // Obtiene el tipo o nivel de usuario desde el formulario de login
        String tipoNivel = FrmLogin.getUsuarioTipoNivel();
        
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

        
          // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Btn_agendarCita = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 40, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, 20));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 680, 10));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de citas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jLabel_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, 20));

        jButton8.setText("x");
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        jButton9.setText("-");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));
        jPanel1.add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 50));

        jButton5.setText("Buscar");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 680, 110));

        jButton6.setText("Imprimir Cita ");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, -1, -1));

        jButton7.setText("Exportar excel");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 330, -1, -1));

        Btn_regresar.setText("Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Todas");

        Btn_agendarCita.setText("Nueva cita");
        Btn_agendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agendarCitaActionPerformed(evt);
            }
        });

        jButton2.setText("Canceladas");

        jButton1.setText("Proximas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addGap(53, 53, 53)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(Btn_agendarCita)
                .addGap(36, 36, 36))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_agendarCita)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 540, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
            aplicarTemaOscuro(); // Aplica el tema oscuro si el botón está seleccionado
            jToggleButton1.setIcon(iconoSol); // Cambia el ícono a sol
        } else {
            aplicarTemaClaro(); // Aplica el tema claro si el botón no está seleccionado
            jToggleButton1.setIcon(iconoLuna); // Cambia el ícono a luna
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void Btn_agendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agendarCitaActionPerformed
       FrmAgendarCita frmAgendarCita = new FrmAgendarCita();
       frmAgendarCita.setVisible(true);
    }//GEN-LAST:event_Btn_agendarCitaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGestionDeCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGestionDeCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGestionDeCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGestionDeCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGestionDeCitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_agendarCita;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables


//----------------------------------------------------------------------------------------------------------------------//
//                                                         Métodos para aplicar tema oscuro / claro
//----------------------------------------------------------------------------------------------------------------------//

private void aplicarTemaClaro() {
        jPanel1.setBackground(fondoClaro); // Establece el color de fondo del panel para el tema claro.
        jToggleButton1.setBackground(botonOscuro); // Establece el color de fondo del botón para el tema claro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema claro.
        jTextField1.setBackground(fondoOscuro); // Establece el color de fondo del campo de texto para el tema claro.
        jTextField1.setForeground(textoClaro); // Establece el color del texto del campo de texto para el tema claro.
        Btn_regresar.setBackground(botonOscuro); // Establece el color de fondo del botón adicional para el tema claro.
        Btn_regresar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema claro.
    }

    /**
     * Aplica el tema oscuro a los componentes de la interfaz.
     */
    private void aplicarTemaOscuro() {
        jPanel1.setBackground(fondoOscuro); // Establece el color de fondo del panel para el tema oscuro.
        jToggleButton1.setBackground(botonClaro); // Establece el color de fondo del botón para el tema oscuro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema oscuro.
        jTextField1.setBackground(fondoClaro); // Establece el color de fondo del campo de texto para el tema oscuro.
        jTextField1.setForeground(textoOscuro); // Establece el color del texto del campo de texto para el tema oscuro.
        Btn_regresar.setBackground(botonClaro); // Establece el color de fondo del botón adicional para el tema oscuro.
        Btn_regresar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema oscuro.
    }
}
