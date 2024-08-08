
package controlador;

import java.sql.*;
import conexion.Conexion;
import modelo.Odontologo;

/**
 *
 * @author Miller
 */
public class Ctrl_Odontologo {
    
     //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para guardar un paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean guardarOdontologo(Odontologo odontologo){
        boolean respuesta = false;
        String sql = "INSERT INTO tb_odontologos (nombre_odontologo, apellido, direccion, ciudad, pais, especialidad,"
                + "telefono, email, fecha_nacimiento, genero, numero_licencia, identificacion, tipo_identificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, odontologo.getNombre_odontologo());
            pst.setString(2,odontologo.getApellido());
            pst.setString(3,odontologo.getDireccion());
            pst.setString(4,odontologo.getCiudad());
            pst.setString(5,odontologo.getPais());
            pst.setString(6,odontologo.getEspecialidad());
            pst.setString(7,odontologo.getTelefono());
            pst.setString(8,odontologo.getEmail());
            
            
              pst.setDate(9, new java.sql.Date(odontologo.getFecha_nacimiento().getTime()));

              pst.setString(10,odontologo.getGenero());
               pst.setString(11,odontologo.getNumero_licencia());
            pst.setString(12, odontologo.getIdentificacion());
            pst.setString(13,odontologo.getTipo_identificacion());
            
           
            
            if(pst.executeUpdate() > 0 ){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e){
             System.out.println("Error al guardar el odontologo: " + e);
        }
        return respuesta;
    }
    
     //----------------------------------------------------------------------------------------------------------------------//
    //                                            Método para verificar si el paciente ya existe bd
    //----------------------------------------------------------------------------------------------------------------------//    
    public boolean existeOdontologo(String identificacion) {
        String sql = "SELECT  COUNT(*) FROM tb_odontologos WHERE identificacion = ?";
        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, identificacion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;     // Retorna true si el paciente ya está registrado
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del paciente." + e);
        }
        return false;
    }

    
}
