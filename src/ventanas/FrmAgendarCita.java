package ventanas;

import conexion.Conexion;
import controlador.Ctrl_Cita;
import controlador.Ctrl_Paciente;
import java.awt.Color;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;
import java.sql.SQLException;

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
        
        // cargar odontologos en combo
        this.cargarOdontologos();
        // cargar auxiliares en combo
        this.cargarAuxiliares();
        
         CargarTablaCitas(); 

        this.setSize(886, 535); // Establece el tamaño de la ventana
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
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel_cabecera = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        Btn_buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_paciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        Cmb_auxiliar = new javax.swing.JComboBox<>();
        Cmb_odontologo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Btn_agendar = new javax.swing.JButton();
        Btn_regresar = new javax.swing.JButton();
        Btn_cerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_servicio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_tipoCita = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_estadoCita = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_citas = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agendar Cita");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 240, -1));

        jLabel_usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel_usuario.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 180, 20));

        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 50, -1));

        jButton2.setText("-");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 40, -1));

        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 50, 30));
        jPanel1.add(jLabel_cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 900, 60));

        txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 70, -1));

        Btn_buscar.setText("Buscar");
        Btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, -1, -1));

        jLabel3.setText("Paciente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 50, -1));

        txt_paciente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txt_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 280, -1));

        jLabel4.setText("Fecha");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 190, -1));

        jLabel5.setText("Servicio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        Cmb_auxiliar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Cmb_auxiliar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 220, -1));

        Cmb_odontologo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(Cmb_odontologo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 220, -1));

        jLabel6.setText("Odontologo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        Btn_agendar.setText("Agendar");
        Btn_agendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_agendarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_agendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 100, -1));

        Btn_regresar.setText("Regresar");
        Btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 100, -1));

        Btn_cerrar.setText("Cerrar");
        jPanel1.add(Btn_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 90, -1));

        jLabel2.setText("Auxiliar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));
        jPanel1.add(txt_servicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 220, -1));

        jLabel7.setText("Tipo cita :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));
        jPanel1.add(txt_tipoCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 190, -1));

        jLabel8.setText("Estado cita : ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));
        jPanel1.add(txt_estadoCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 180, -1));

        Tabla_citas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabla_citas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 780, 120));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if (jToggleButton1.isSelected()) {
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

    private void Btn_agendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_agendarActionPerformed
        // Obtener los datos del formulario
        String paciente = txt_paciente.getText();
        String servicio = txt_servicio.getText();
        String tipoCita = txt_tipoCita.getText();
        String estadoCita = txt_estadoCita.getText();
// Obtener la fecha
        java.util.Date fecha = jDateChooser1.getDate();
// Obtener el odontólogo y auxiliar seleccionados
        String odontologo = (String) Cmb_odontologo.getSelectedItem();
        String auxiliar = (String) Cmb_auxiliar.getSelectedItem();

// Validar datos
        if (paciente.isEmpty() || servicio.isEmpty() || tipoCita.isEmpty() || estadoCita.isEmpty() || fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.");
            return;
        }

// Llamar al controlador para agendar la cita
        Ctrl_Cita controlCita = new Ctrl_Cita();
        boolean resultado = controlCita.agendarCita(paciente, servicio, tipoCita, estadoCita, fecha, odontologo, auxiliar); // Usar la instancia

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Cita agendada con éxito.");
            // Limpiar campos después de agendar la cita
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agendar la cita. Intente nuevamente.");
        }

    }//GEN-LAST:event_Btn_agendarActionPerformed

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        buscarPacientePorId();
    }//GEN-LAST:event_Btn_buscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       CargarTablaCitas();
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JButton Btn_agendar;
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JButton Btn_cerrar;
    private javax.swing.JButton Btn_regresar;
    private javax.swing.JComboBox<String> Cmb_auxiliar;
    private javax.swing.JComboBox<String> Cmb_odontologo;
    private javax.swing.JTable Tabla_citas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_cabecera;
    private javax.swing.JLabel jLabel_usuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_estadoCita;
    private javax.swing.JTextField txt_paciente;
    private javax.swing.JTextField txt_servicio;
    private javax.swing.JTextField txt_tipoCita;
    // End of variables declaration//GEN-END:variables

//----------------------------------------------------------------------------------------------------------------------//
//                                                         Métodos para aplicar tema oscuro / claro
//----------------------------------------------------------------------------------------------------------------------//
    private void aplicarTemaClaro() {
        jPanel1.setBackground(fondoClaro); // Establece el color de fondo del panel para el tema claro.
        jToggleButton1.setBackground(botonOscuro); // Establece el color de fondo del botón para el tema claro.
        jToggleButton1.setForeground(textoOscuro); // Establece el color del texto del botón para el tema claro.
        txt_buscar.setBackground(fondoOscuro); // Establece el color de fondo del campo de texto para el tema claro.
        txt_buscar.setForeground(textoClaro); // Establece el color del texto del campo de texto para el tema claro.
        Btn_regresar.setBackground(botonOscuro); // Establece el color de fondo del botón adicional para el tema claro.
        Btn_regresar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema claro.

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
        txt_buscar.setBackground(fondoClaro); // Establece el color de fondo del campo de texto para el tema oscuro.
        txt_buscar.setForeground(textoOscuro); // Establece el color del texto del campo de texto para el tema oscuro.
        Btn_regresar.setBackground(botonClaro); // Establece el color de fondo del botón adicional para el tema oscuro.
        Btn_regresar.setForeground(textoOscuro); // Establece el color del texto del botón adicional para el tema oscuro.
        jLabel1.setForeground(textoOscuro); // Establece el color del texto de la etiqueta para el tema claro
        jLabel1.setForeground(textoClaro); // Establece el color del texto de la etiqueta para el tema oscuro.

        jLabel3.setForeground(textoClaro);
        jLabel4.setForeground(textoClaro);
        jLabel5.setForeground(textoClaro);
        jLabel6.setForeground(textoClaro);

    }

    private void limpiarCampos() {
        txt_paciente.setText("");
        txt_servicio.setText("");
        txt_tipoCita.setText("");
        txt_estadoCita.setText("");
        jDateChooser1.setDate(null);
        Cmb_odontologo.setSelectedIndex(0);
        Cmb_auxiliar.setSelectedIndex(0);
    }

    // Método para buscar y mostrar el paciente en los campos de texto
    public void buscarPacientePorId() {
        // Obtener el ID del paciente desde el campo de texto (ajusta según tu implementación)
        String idText = txt_buscar.getText(); // Suponiendo que tienes un campo de texto para ingresar el ID
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
            return;
        }

        try {
            int id = Integer.parseInt(idText); // Convertir el texto a un entero

            // Crear una instancia del controlador
            Ctrl_Cita controlCita = new Ctrl_Cita();

            // Obtener el paciente por ID
            Ctrl_Paciente controlPaciente = new Ctrl_Paciente();
            Paciente paciente = controlPaciente.obtenerPacientePorId(id);

            // Verificar si el paciente fue encontrado
            if (paciente != null) {
                // Mostrar el nombre y el apellido en el mismo JLabel
            String nombreCompleto = paciente.getNombre() + " " + paciente.getApellido();
            txt_paciente.setText(nombreCompleto); // Mostrar en el JLabel

                // Aquí puedes manejar la imagen si es necesario
                // byte[] imagen = paciente.getImagen();
                // Mostrar la imagen en un JLabel o algún otro componente
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Asegúrese de ingresar un número.");
        }
    }
    
    
     //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para cargar los odontologos en combobox
    //---------------------------------------------------------------------------------------------------------------------//
   
   private  void cargarOdontologos(){
       
       String sql = "SELECT * FROM tb_odontologos";
       
       try {
           Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Cmb_odontologo.removeAllItems();
            Cmb_odontologo.addItem("Seleccione el odontologo");
            
            while(rs.next()){
                 Cmb_odontologo.addItem(rs.getString("nombre_odontologo") + " " + rs.getString("apellido"));
            }
            con.close();
       } catch (Exception e) {
           System.out.println("error al cargar los odontologos." + e);
       }
       }
       
    //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para cargar los auxiliares en combobox
    //---------------------------------------------------------------------------------------------------------------------//
   
   private  void cargarAuxiliares(){
       
       String sql = "SELECT * FROM tb_auxiliar";
       
       try {
           Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            Cmb_auxiliar.removeAllItems();
            Cmb_auxiliar.addItem("Seleccione el auxiliar");
            
            while(rs.next()){
                 Cmb_auxiliar.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            con.close();
       } catch (Exception e) {
           System.out.println("error al cargar el auxiliar." + e);
       }
       }
   
   
 // Método para cargar la tabla de citas
public void CargarTablaCitas() {
    // Establece la conexión a la base de datos
    Connection con = Conexion.conectar();
    // Crea un modelo de tabla por defecto
    DefaultTableModel model = new DefaultTableModel();

    // Consulta SQL para obtener los datos de las citas
    String sql = "SELECT o.nombre_odontologo AS odontologo, " +
             "p.nombre AS paciente, " +
             "c.fecha_hora_cita AS fecha, " +
             "c.tipo_cita AS tipo_cita, " +
             "c.confirmacion_cita AS estado " +
             "FROM tb_citas c " +
             "INNER JOIN tb_odontologos o ON c.odontologo_id = o.id " +
             "INNER JOIN tb_pacientes p ON c.paciente_id = p.id ";
        


    PreparedStatement pst = null; // Declaramos el Statement

    try {
        // Prepara la declaración para ejecutar la consulta SQL
        pst = con.prepareStatement(sql);
        // Ejecuta la consulta SQL y obtiene los resultados
        ResultSet rs = pst.executeQuery(); // Usa el PreparedStatement para ejecutar la consulta

        // Agrega columnas al modelo de la tabla
        model.addColumn("Odontólogo");
        model.addColumn("Paciente");
        model.addColumn("Fecha");
        model.addColumn("Tipo de Cita");
        model.addColumn("Estado");

        // Recorre los resultados de la consulta
        while (rs.next()) {
            // Crea un array de objetos para almacenar una fila
            Object fila[] = new Object[5]; // 7 columnas a mostrar en la tabla
            // Asigna los valores de cada columna a la fila
            fila[0] = rs.getString("odontologo");
            fila[1] = rs.getString("paciente");
            fila[2] = rs.getDate("fecha");
            fila[3] = rs.getString("tipo_cita");
            fila[4] = rs.getString("estado");

            // Agrega la fila al modelo de la tabla
            model.addRow(fila);
        }

        // Asigna el modelo a la tabla existente
        Tabla_citas.setModel(model);
        // Asocia la tabla al panel de desplazamiento
        jScrollPane1.setViewportView(Tabla_citas);

    } catch (SQLException e) {
        // Maneja cualquier error que ocurra durante la consulta y muestra un mensaje de error
        System.out.println("Error al llenar la tabla citas: " + e.getMessage());
    } finally {
        // Asegúrate de cerrar la conexión y el statement en el bloque finally
        try {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}




       
}
