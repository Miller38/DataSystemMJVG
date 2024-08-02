package controlador;

import conexion.Conexion;
import modelo.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;
import pdf.GeneradorPDF;
import servicios.Utilidades;

public class Ctrl_Usuario {

    /*
    * ------------------------------------------------------------------------------------------------------------------------
    *                                                               Método para iniciar sesión.
    * ------------------------------------------------------------------------------------------------------------------------
     */
    public Usuario loginUser(Usuario objeto) {
        Usuario usuario = null;
        String sql = "SELECT id_usuario, tipo_nivel, estatus, password FROM tb_usuarios WHERE username = ?";
        try (
                Connection cn = Conexion.conectar(); 
                PreparedStatement pst = cn.prepareStatement(sql)) {
            if (cn != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("Error al conectar a la base de datos.");
                return null;
            }

            pst.setString(1, objeto.getUsername());

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id_usuario = rs.getInt("id_usuario");
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    String passwordAlmacenada = rs.getString("password");

                    // Encriptar la contraseña proporcionada por el usuario
                    String passwordIngresada = Utilidades.encriptarSHA3(objeto.getPassword());

                    if (passwordIngresada.equals(passwordAlmacenada)) {
                        usuario = new Usuario();
                        usuario.setId_usuario(id_usuario);
                        usuario.setUsername(objeto.getUsername());
                        usuario.setTipo_nivel(tipo_nivel);
                        usuario.setEstatus(estatus);
                    } else {
                        System.out.println("La contraseña no coincide.");
                    }
                } else {
                    System.out.println("No se encontró ningún usuario con el nombre de usuario proporcionado.");
                }
            }
        } catch (SQLException e) {
            // Logger.getLogger(Ctrl_Usuario.class.getName()).log(Level.SEVERE, "Error al autenticar al usuario", e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Por favor, inténtelo de nuevo.");
        }
        return usuario;
    }
    
    
     //---------------------------------------------------------------------------------------------------------------------//
    //                                                               Metodo para guardar un usuario
    //---------------------------------------------------------------------------------------------------------------------//

    public boolean guardarUsuario(Usuario usuario) {
    boolean respuesta = false;
    String sql = "INSERT INTO tb_usuarios (nombre_usuario, email, telefono, username, password, tipo_nivel, estatus, registrado_por, imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);

        pst.setString(1, usuario.getNombre_usuario());
        pst.setString(2, usuario.getEmail());
        pst.setString(3, usuario.getTelefono());
        pst.setString(4, usuario.getUsername());
        pst.setString(5, Utilidades.encriptarSHA3(usuario.getPassword()));
        pst.setString(6, usuario.getTipo_nivel());
        pst.setString(7, usuario.getEstatus());
        pst.setString(8, usuario.getRegistrado_por());
         pst.setBytes(9, usuario.getImagen());
        

        if (pst.executeUpdate() > 0) {
            respuesta = true;
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al guardar el usuario: " + e);
    }
    return respuesta;
}
    
    //----------------------------------------------------------------------------------------------------------------------//
//                                                     Método para actualizar un usuario en la base de datos
//----------------------------------------------------------------------------------------------------------------------//
public boolean actualizarUsuario(Usuario usuario) {
    boolean respuesta = false;
    String sql = "UPDATE tb_usuarios SET nombre_usuario=?, email=?, telefono=?, username=?, password=?, tipo_nivel=?, estatus=?, registrado_por=? WHERE id_usuario=?";

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);

        pst.setString(1, usuario.getNombre_usuario());
        pst.setString(2, usuario.getEmail());
        pst.setString(3, usuario.getTelefono());
        pst.setString(4, usuario.getUsername());
        pst.setString(5, Utilidades.encriptarSHA3(usuario.getPassword()));
        pst.setString(6, usuario.getTipo_nivel());
        pst.setString(7, usuario.getEstatus());
        pst.setString(8, usuario.getRegistrado_por());
        pst.setInt(9, usuario.getId_usuario()); // ID del usuario

        if (pst.executeUpdate() > 0) {
            respuesta = true;
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al actualizar el usuario: " + e);
    }
    return respuesta;
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                     Método para eliminar un usuario de la base de datos
//----------------------------------------------------------------------------------------------------------------------//
public boolean eliminarUsuario(int idUsuario) {
    boolean respuesta = false;
    String sql = "DELETE FROM tb_usuarios WHERE id_usuario=?";

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idUsuario);

        if (pst.executeUpdate() > 0) {
            respuesta = true;
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al eliminar el usuario: " + e);
    }
    return respuesta;
}
    

//----------------------------------------------------------------------------------------------------------------------//
//                                                     Método para obtener un usuario por ID de la base de datos
//----------------------------------------------------------------------------------------------------------------------//
public Usuario obtenerUsuarioPorID(int idUsuario) {
    Usuario usuario = null;
    String sql = "SELECT * FROM tb_usuarios WHERE id_usuario=?";

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idUsuario);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId_usuario(rs.getInt("id_usuario"));
            usuario.setNombre_usuario(rs.getString("nombre_usuario"));
            usuario.setEmail(rs.getString("email"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setUsername(rs.getString("username"));
            usuario.setPassword(rs.getString("password")); // Nota: la contraseña puede estar encriptada
            usuario.setTipo_nivel(rs.getString("tipo_nivel"));
            usuario.setEstatus(rs.getString("estatus"));
            usuario.setRegistrado_por(rs.getString("registrado_por"));
            usuario.setImagen(rs.getBytes("imagen")); 
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al obtener el usuario por ID: " + e);
    }
    return usuario;
}

//----------------------------------------------------------------------------------------------------------------------//
//                                                    Método para verificar si un usuario existe en la base de datos
//----------------------------------------------------------------------------------------------------------------------//
public boolean existeUsuario(String username) {
    boolean existe = false;
    String sql = "SELECT COUNT(*) FROM tb_usuarios WHERE username=?";

    try {
        Connection cn = Conexion.conectar();
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            existe = rs.getInt(1) > 0;
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al verificar si el usuario existe: " + e);
    }
    return existe;
}

    /*
 * ------------------------------------------------------------------------------------------------------------------------
 *                                                               Método para generar reportes PDF
 * ------------------------------------------------------------------------------------------------------------------------
     */
  public void generarReportePDF() {
        GeneradorPDF generador = new GeneradorPDF();
        generador.generarReporteUsuarios();
    }
}
