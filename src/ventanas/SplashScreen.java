package ventanas;

import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


/**
 *
 * @author Miller
 */
public class SplashScreen extends javax.swing.JFrame {

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {

        setUndecorated(true);

        initComponents();

        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("SplashScreen");
        // Redondear las esquinas del jframe 
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        // ----------------------------------------Colocar imagen de fondo----------------------------------------------// 
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroungImage1 = new javax.swing.JLabel();
        LoadingBar = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackgroungImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/robot-assistant.png"))); // NOI18N
        getContentPane().add(BackgroungImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 340, 500));
        getContentPane().add(LoadingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 394, 500, 30));

        LoadingLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoadingLabel.setText("Loading. . .");
        getContentPane().add(LoadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 230, -1));

        LoadingValue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoadingValue.setText("0 %");
        getContentPane().add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 80, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel1.setText("Milliany Tech");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Milliany Tech");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel_Wallpaper.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
              // Crea una instancia de la pantalla de inicio (splash screen) y la hace visible
SplashScreen sp = new SplashScreen();
sp.setVisible(true);

try {
    // Inicia un bucle que simula el progreso de carga de la aplicación
    for(int i = 0; i <= 100; i++){
        // Pausa la ejecución del hilo actual durante 100 milisegundos
        Thread.sleep(100);
        
        // Actualiza el texto del componente que muestra el porcentaje de carga
        sp.LoadingValue.setText(i + " %");
        
        // Cambia el texto del componente de carga en función del progreso
        if(i == 10){
            sp.LoadingLabel.setText("Turning On Modules . . .");
        }
        if(i == 20){
            sp.LoadingLabel.setText("Loading Modules . . .");
        }
        if(i == 50){
            sp.LoadingLabel.setText("Connecting to Database . . .");
        }
        if(i == 70){
            sp.LoadingLabel.setText("Connecting Successful . . .");
        }
        if(i == 80){
            sp.LoadingLabel.setText("Launching Application . . .");
        }
        
        // Actualiza el valor de la barra de carga con el progreso actual
        sp.LoadingBar.setValue(i);
    }

    // Crea una instancia del formulario de inicio de sesión y lo muestra
    FrmLogin login = new FrmLogin();
   
    login.setVisible(true); // Hace visible el formulario de inicio de sesión
    login.setResizable(false); // Impide que el formulario sea redimensionable
    login.setLocationRelativeTo(null); // Centra el formulario en la pantalla
    sp.setVisible(false); // Oculta la pantalla de inicio después de cargar

} catch (Exception e) {
    // Muestra un mensaje de error en caso de una excepción durante el proceso de carga
    JOptionPane.showMessageDialog(null, e);
}

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroungImage1;
    private javax.swing.JProgressBar LoadingBar;
    private javax.swing.JLabel LoadingLabel;
    private javax.swing.JLabel LoadingValue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
