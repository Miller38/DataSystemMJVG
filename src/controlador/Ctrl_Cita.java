package controlador;

import java.sql.*;
import conexion.Conexion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import modelo.Paciente;


public class Ctrl_Cita {
    
      //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para guardar un paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean agendarCita(String paciente, String servicio, String tipoCita, String estadoCita, java.util.Date fecha, String odontologo, String auxiliar) {
         String sql = "INSERT INTO citas (paciente, servicio, tipo_cita, estado_cita, fecha, odontologo, auxiliar) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, paciente);
            pst.setString(2, servicio);
            pst.setString(3, tipoCita);
            pst.setString(4, estadoCita);
           pst.setDate(5, new java.sql.Date(fecha.getTime()));
            pst.setString(6, odontologo);
            pst.setString(7, auxiliar);

           
           int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0; // Retornar true si se insertó al menos una fila

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agendar la cita: " + e.getMessage());
            return false; // Retornar false en caso de error
        }
    
    }
    
    //--------------------------------------------------------------------------------------------------------------------//
   


    
    // --------------------------------------------------------------------------------------------------------------------//

    // Método para mostrar la cantidad de citas confirmadas en un JLabel
    public void mostrarCitasConfirmadas(JLabel jLabel_citaConfirmada) {
        String estadoCita = "Confirmada";
        int cantidadConfirmadas = contarCitas(estadoCita);
        jLabel_citaConfirmada.setText("Citas " + estadoCita + ": " + cantidadConfirmadas);
    }

    // Método para mostrar la cantidad de citas canceladas en un JLabel
    public void mostrarCitasCanceladas(JLabel jLabel_citaCancelada) {
        String estadoCita = "Cancelada";
        int cantidadCanceladas = contarCitas(estadoCita);
        jLabel_citaCancelada.setText("Citas " + estadoCita + ": " + cantidadCanceladas);
    }

    // Método para mostrar la cantidad de citas pendientes en un JLabel
    public void mostrarCitasPendientes(JLabel jLabel_citaPendiente) {
        String estadoCita = "Pendiente";
        int cantidadPendientes = contarCitas(estadoCita);
        jLabel_citaPendiente.setText("Citas " + estadoCita + ": " + cantidadPendientes);
    }

    // Método para contar citas según el estado
    public int contarCitas(String estadoCita) {
        int count = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT COUNT(*) FROM tb_citas WHERE confirmacion_cita = ?";
        
        try {
            // Establecer conexión
            con = Conexion.conectar(); // Usar 'con' para la conexión
            ps = con.prepareStatement(sql);
            ps.setString(1, estadoCita);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
