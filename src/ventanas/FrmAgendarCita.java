package ventanas;

import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class FrmAgendarCita extends javax.swing.JFrame {

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

    public FrmAgendarCita() {

        setUndecorated(true);

        initComponents();

        this.setSize(471, 490); // Establece el tamaño de la ventana
        this.setResizable(false); // Evita que la ventana se redimensione
        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        aplicarTemaClaro(); // Aplica el tema claro al iniciar

        jToggleButton1.setIcon(iconoLuna);  // Establece el ícono inicial del botón como luna

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
                   wallpaper_cabecera.getImage().getScaledInstance(
                           jLabel_cabecera.getWidth(),
                           jLabel_cabecera.getHeight(),
                           Image.SCALE_DEFAULT
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
        jLabel1 = new javax.swing.JLabel();
        jLabel_usuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel_cabecera = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Agendar Cita");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 20));

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 20, 50, -1));

        jButton2.setText("-");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 20, 40, -1));
        jPanel1.add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 80));

        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 50, 30));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, -1));

        jButton3.setText("Buscar");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel3.setText("Paciente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 50, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 280, -1));

        jLabel4.setText("Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 170, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 110, -1));

        jLabel5.setText("Servicio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 160, -1));

        jLabel6.setText("Quien atendera");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jButton4.setText("Agendar");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 100, -1));

        Btn_regresar.setText("Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 100, -1));

        jButton6.setText("Cerrar");
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 90, -1));

        jLabel2.setText("Hora cita");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected()){
            aplicarTemaOscuro();  // Aplica el tema oscuro si el botón está seleccionado
            jToggleButton1.setIcon(iconoSol); // Cambia el ícono a sol
        } else {
            aplicarTemaClaro(); // Aplica el tema claro si el botón no está seleccionado
            jToggleButton1.setIcon(iconoLuna);  // Cambia el ícono a luna
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void Btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_regresarActionPerformed
       this.dispose();
    }//GEN-LAST:event_Btn_regresarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgendarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Métodos para aplicar tema oscuro / claro
//----------------------------------------------------------------------------------------------------------------------//

    private void aplicarTemaClaro(){
         jPanel1.setBackground(fondoClaro); // Establece el color de fondo del panel para el tema claro.
        jToggleButton1.setBackground(botonOscuro); // Establece el color de fondo del botón para el tema claro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema claro.
        jTextField1.setBackground(fondoOscuro); // Establece el color de fondo del campo de texto para el tema claro.
        jTextField1.setForeground(textoClaro); // Establece el color del texto del campo de texto para el tema claro.
        Btn_regresar.setBackground(botonOscuro); // Establece el color de fondo del botón adicional para el tema claro.
        Btn_regresar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema claro.
         jLabel2.setForeground(textoOscuro);
        jLabel3.setForeground(textoOscuro);
        jLabel4.setForeground(textoOscuro);
        jLabel5.setForeground(textoOscuro);
        jLabel6.setForeground(textoOscuro);
       
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
        jLabel1.setForeground(textoOscuro); // Establece el color del texto de la etiqueta para el tema claro
         jLabel1.setForeground(textoClaro); // Establece el color del texto de la etiqueta para el tema oscuro.
        jLabel2.setForeground(textoClaro);
        jLabel3.setForeground(textoClaro);
        jLabel4.setForeground(textoClaro);
        jLabel5.setForeground(textoClaro);
        jLabel6.setForeground(textoClaro);
      
    }
}
