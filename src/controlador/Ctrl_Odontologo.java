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
    public boolean guardarOdontologo(Odontologo odontologo) {
        boolean respuesta = false;
        String sql = "INSERT INTO tb_odontologos (nombre_odontologo, apellido, direccion, ciudad, pais, especialidad,"
                + "telefono, email, fecha_nacimiento, genero, numero_licencia, identificacion, imagen,"
                + " tipo_identificacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, odontologo.getNombre_odontologo());
            pst.setString(2, odontologo.getApellido());
            pst.setString(3, odontologo.getDireccion());
            pst.setString(4, odontologo.getCiudad());
            pst.setString(5, odontologo.getPais());
            pst.setString(6, odontologo.getEspecialidad());
            pst.setString(7, odontologo.getTelefono());
            pst.setString(8, odontologo.getEmail());

            pst.setDate(9, new java.sql.Date(odontologo.getFecha_nacimiento().getTime()));

            pst.setString(10, odontologo.getGenero());
            pst.setString(11, odontologo.getNumero_licencia());
            pst.setString(12, odontologo.getIdentificacion());
            
            byte[] imagen = odontologo.getImagen();
            if (imagen != null) {
                pst.setBytes(13, imagen);
            } else {
                pst.setNull(13, java.sql.Types.BLOB);
            }
            
            pst.setString(14, odontologo.getTipo_identificacion());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
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
                return count > 0;     // Retorna true si el odontologo ya está registrado
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al verificar la existencia del paciente." + e);
        }
        return false;
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para actualizar el odontologo
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean actualizarOdontologo(Odontologo odontologo) {
        // Variable para almacenar la respuesta del método
        boolean respuesta = false;
         // SQL para actualizar los datos del odontólogo en la base de datos
        String sql = "UPDATE tb_odontologos Set nombre_odontologo = ?, apellido = ?, direccion = ?, ciudad = ?, "
                + "pais = ?, especialidad = ?, telefono = ?, email = ?, tipo_identificacion = ?, imagen = ?, "
                + "fecha_nacimiento = ?, genero = ?, numero_licencia = ? WHERE identificacion = ?";

        try {
             // Establece la conexión con la base de datos
            Connection cn = Conexion.conectar();
            // Prepara la sentencia SQL con los parámetros correspondientes
            PreparedStatement pst = cn.prepareStatement(sql);
            
             // Asigna los valores del objeto odontólogo a los parámetros de la sentencia SQL
            pst.setString(1, odontologo.getNombre_odontologo());
            pst.setString(2, odontologo.getApellido());
            pst.setString(3, odontologo.getDireccion());
            pst.setString(4, odontologo.getCiudad());
            pst.setString(5, odontologo.getPais());
            pst.setString(6, odontologo.getEspecialidad());
            pst.setString(7, odontologo.getTelefono());
            pst.setString(8, odontologo.getEmail());
            pst.setString(9, odontologo.getTipo_identificacion());
            
            byte[] imagen = odontologo.getImagen();
            if (imagen != null) {
                pst.setBytes(10, imagen);
            } else {
                pst.setNull(10, java.sql.Types.BLOB);
            }
            
            pst.setDate(11, new java.sql.Date(odontologo.getFecha_nacimiento().getTime()));
            pst.setString(12, odontologo.getGenero());
            pst.setString(13, odontologo.getNumero_licencia());
            pst.setString(14, odontologo.getIdentificacion());

            // Ejecuta la actualización y verifica si se afectó alguna fila
            if(pst.executeUpdate() > 0){
                respuesta = true; // Si se actualizó, cambia la respuesta a true
            }
            cn.close(); // Cierra la conexión            
        } catch (SQLException e) {
            // Captura y muestra cualquier excepción SQL
             System.out.println("Error al actualizar." + e);
        }
        return respuesta;  // Devuelve la respuesta, indicando si la actualización fue exitosa o no
    }
    
     //---------------------------------------------------------------------------------------------------------------------//
    //                                                      Metodo para obtener un  odontologo
    //---------------------------------------------------------------------------------------------------------------------//
    public Odontologo obtenerOdontologo(String identificacion){
        Odontologo odontologo = null;
         String sql = "SELECT * FROM tb_odontologos WHERE identificacion = ?";
         
         try{
             Connection cn = Conexion.conectar();
             PreparedStatement pst = cn.prepareStatement(sql);
             pst.setString(1,identificacion);
             ResultSet rs = pst.executeQuery();
             
             if(rs.next()){
                 odontologo = new Odontologo();
                 odontologo.setNombre_odontologo(rs.getString("nombre_odontologo"));
                 odontologo.setApellido(rs.getString("apellido"));
                 odontologo.setDireccion(rs.getString("direccion"));
                 odontologo.setCiudad(rs.getString("ciudad"));
                 odontologo.setPais(rs.getString("pais"));
                 odontologo.setEspecialidad(rs.getString("especialidad"));
                 odontologo.setTelefono(rs.getString("telefono"));
                 odontologo.setEmail(rs.getString("email"));
                 odontologo.setTipo_identificacion(rs.getString("tipo_identificacion"));
                 odontologo.setImagen(rs.getBytes("imagen"));
                 odontologo.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                 odontologo.setGenero(rs.getString("genero"));
                 odontologo.setNumero_licencia(rs.getString("numero_licencia"));                 
             }
             cn.close();
         } catch(SQLException e){
              System.out.println("Error al obtener el odontologo: " + e);
         }
         return odontologo;
    }
    
     //---------------------------------------------------------------------------------------------------------------------//
    //                                                      Metodo para eliminar el odontologo
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarOdontologo(String identificacion){
        boolean respuesta = false;
        String sql = "DELETE FROM tb_odontologos WHERE identificacion = ?";
        
        try{
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1,identificacion);
            
            if(pst.executeUpdate() > 0){
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e){
            System.out.println("Error al eliminar : " + e);
        }
        return  respuesta;
    }
    
}
