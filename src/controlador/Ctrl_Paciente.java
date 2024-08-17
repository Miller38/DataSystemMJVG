package controlador;

import java.sql.*;
import conexion.Conexion;
import modelo.Paciente;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import ventanas.FrmPacientes;

/**
 *
 * @author Miller
 */
public class Ctrl_Paciente {

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                     Metodo para guardar un paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean guardarPaciente(Paciente paciente) {
        boolean respuesta = false;

        String sql = "INSERT INTO tb_pacientes (nombre, apellido, direccion, ciudad, pais, telefono,"
                + " email, fechaNacimiento, genero, identificacion, tipo_identificacion, tipo_sangre, "
                + "alergias, imagen, ruta, historial_medico, estado_civil, ocupacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, paciente.getNombre());
            pst.setString(2, paciente.getApellido());
            pst.setString(3, paciente.getDireccion());
            pst.setString(4, paciente.getCiudad());
            pst.setString(5, paciente.getPais());
            pst.setString(6, paciente.getTelefono());
            pst.setString(7, paciente.getEmail());

            // Si paciente.getFechaNacimiento() es un LocalDate
            Date fechaNacimiento = paciente.getFechaNacimiento(); // Asegúrate de que este método devuelva LocalDate
            if (fechaNacimiento != null) {

                pst.setDate(8, new java.sql.Date(fechaNacimiento.getTime()));
            } else {
                pst.setNull(8, java.sql.Types.DATE); // Usa null si la fecha es opcional
            }

            pst.setString(9, paciente.getGenero());
            pst.setString(10, paciente.getIdentificacion());
            pst.setString(11, paciente.getTipo_identificacion());
            pst.setString(12, paciente.getTipo_sangre());
            pst.setBytes(13, paciente.getImagen());
            pst.setString(13, paciente.getAlergias());

            byte[] imagen = paciente.getImagen();
            if (imagen != null) {
                pst.setBytes(14, imagen);
            } else {
                pst.setNull(14, java.sql.Types.BLOB);
            }

            pst.setString(15, paciente.getRuta());
            pst.setString(16, paciente.getHistorialMedico());
            pst.setString(17, paciente.getEstado_civil());
            pst.setString(18, paciente.getOcupacion());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el paciente: " + e);
        }
        return respuesta;
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                      Metodo para actualizar el paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean actualizarPaciente(Paciente paciente) {
        boolean respuesta = false;
        String sql = "UPDATE tb_pacientes SET nombre = ?, apellido = ?, direccion = ?, ciudad = ?, pais = ?, telefono = ?, "
                + "email = ?, fechaNacimiento = ?, genero = ?, tipo_identificacion = ?, tipo_sangre = ?, alergias = ?, "
                + "imagen = ?, ruta = ?, historial_medico = ?, estado_civil = ?, ocupacion = ? WHERE identificacion = ?";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, paciente.getNombre());
            pst.setString(2, paciente.getApellido());
            pst.setString(3, paciente.getDireccion());
            pst.setString(4, paciente.getCiudad());
            pst.setString(5, paciente.getPais());
            pst.setString(6, paciente.getTelefono());
            pst.setString(7, paciente.getEmail());
            pst.setDate(8, new java.sql.Date(paciente.getFechaNacimiento().getTime()));
            pst.setString(9, paciente.getGenero());
            pst.setString(10, paciente.getTipo_identificacion());
            pst.setString(11, paciente.getTipo_sangre());
            pst.setString(12, paciente.getAlergias());

            byte[] imagen = paciente.getImagen();
            if (imagen != null) {
                pst.setBytes(13, imagen);
            } else {
                pst.setNull(13, java.sql.Types.BLOB);
            }

            pst.setString(14, paciente.getRuta());
            pst.setString(15, paciente.getHistorialMedico());
            pst.setString(16, paciente.getEstado_civil());
            pst.setString(17, paciente.getOcupacion());
            pst.setString(18, paciente.getIdentificacion());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el paciente: " + e);
        }

        return respuesta;

    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                      Metodo para eliminar el paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean eliminarPaciente(String identificacion) {
        boolean respuesta = false;
        String sql = "DELETE FROM tb_pacientes WHERE identificacion = ?";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, identificacion);

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el paciente: " + e);
        }

        return respuesta;
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                      Metodo para obtener un  paciente
    //---------------------------------------------------------------------------------------------------------------------//
    public Paciente obtenerPaciente(String identificacion) {
        Paciente paciente = null;
        String sql = "SELECT * FROM tb_pacientes WHERE identificacion = ?";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, identificacion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setCiudad(rs.getString("ciudad"));
                paciente.setPais(rs.getString("pais"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEmail(rs.getString("email"));
                paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                paciente.setGenero(rs.getString("genero"));
                paciente.setIdentificacion(rs.getString("identificacion"));
                paciente.setTipo_identificacion(rs.getString("tipo_identificacion"));
                paciente.setTipo_sangre(rs.getString("tipo_sangre"));
                paciente.setAlergias(rs.getString("alergias"));
                paciente.setImagen(rs.getBytes("imagen"));
                paciente.setRuta(rs.getString("ruta"));
                paciente.setHistorialMedico(rs.getString("historial_medico"));
                paciente.setEstado_civil(rs.getString("estado_civil"));
                paciente.setOcupacion(rs.getString("ocupacion"));
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el paciente: " + e);
        }

        return paciente;
    }

    //----------------------------------------------------------------------------------------------------------------------//
    //                                            Método para verificar si el paciente ya existe bd
    //----------------------------------------------------------------------------------------------------------------------//    
    public boolean existePaciente(String identificacion) {

        String sql = "SELECT  COUNT(*) FROM tb_pacientes WHERE identificacion = ?";
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

    //---------------------------------------------------------------------------------------------------------------------//
    //                                      Metodo para obtener todos los pacientes en la tabla
    //---------------------------------------------------------------------------------------------------------------------//
    public DefaultTableModel cargarTablaPacientes() {
        Connection cn = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();

        String sql = "SELECT id, nombre, apellido, direccion, ciudad, telefono, email,"
                + " identificacion FROM tb_pacientes";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

//            FrmPacientes.jTable_pacientes = new JTable(model);
//            FrmPacientes.jScrollPane3.setViewportView(FrmPacientes.jTable_pacientes);
//            
            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("apellido");
            model.addColumn("direccion");
            model.addColumn("ciudad");
            model.addColumn("telefono");
            model.addColumn("email");
            model.addColumn("identificacion");

            while (rs.next()) {
                Object fila[] = new Object[8];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("apellido");
                fila[3] = rs.getString("direccion");
                fila[4] = rs.getString("ciudad");
                fila[5] = rs.getString("telefono");
                fila[6] = rs.getString("email");
                fila[7] = rs.getString("identificacion");

                model.addRow(fila);
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla usuarios " + e.getMessage());
        }
        return model;
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                      Método para obtener los datos de un paciente por ID
    //---------------------------------------------------------------------------------------------------------------------//
    // Método para obtener los datos de un paciente por ID
    public Paciente obtenerPacientePorId(int id) {
        Paciente paciente = null;

        try {
            Connection con = Conexion.conectar();
            String sql = "SELECT id, nombre, apellido, direccion, ciudad, pais, telefono, email, fechaNacimiento, "
                    + "genero,  identificacion, tipo_identificacion,tipo_sangre,estado_civil, ocupacion ,"
                    + "imagen FROM tb_pacientes WHERE id = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();

                paciente.setId(rs.getInt(1));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellido(rs.getString("apellido"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setCiudad(rs.getString("ciudad"));
                paciente.setPais(rs.getString("pais"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEmail(rs.getString("email"));

                // Asignar la fecha de nacimiento, asegúrate de convertir correctamente si es necesario
            paciente.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                

                paciente.setGenero(rs.getString("genero"));
                paciente.setIdentificacion(rs.getString("identificacion"));
                paciente.setTipo_identificacion(rs.getString("tipo_identificacion"));
                paciente.setTipo_sangre(rs.getString("tipo_sangre"));
                paciente.setEstado_civil(rs.getString("estado_civil"));
                paciente.setOcupacion(rs.getString("ocupacion"));
                
                 // Obtener la imagen como un array de bytes y asignarla al objeto Paciente
            byte[] imagenBytes = rs.getBytes("imagen");
            if (imagenBytes != null) {
                paciente.setImagen(imagenBytes);
            }
           

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del paciente: " + e.getMessage());
        }

        return paciente;
    }

}
