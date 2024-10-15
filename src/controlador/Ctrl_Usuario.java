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
        Usuario usuario = null; // Inicializa la variable 'usuario' como null
        // SQL para seleccionar el usuario basándose en el nombre de usuario
        String sql = "SELECT id_usuario, tipo_nivel, estatus, password FROM tb_usuarios WHERE username = ?";
        try (
                // Establece la conexión a la base de datos y prepara la consulta
                Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {

            if (cn != null) {
                // Imprime mensaje de éxito si la conexión es exitosa
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                // Imprime mensaje de error si la conexión falla y retorna null
                System.out.println("Error al conectar a la base de datos.");
                return null;
            }

            // Establece el parámetro del nombre de usuario en la consulta
            pst.setString(1, objeto.getUsername());

            try (
                    // Ejecuta la consulta y obtiene el resultado
                    ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {
                    // Obtiene los datos del usuario desde el ResultSet
                    int id_usuario = rs.getInt("id_usuario");
                    String tipo_nivel = rs.getString("tipo_nivel");
                    String estatus = rs.getString("estatus");
                    String passwordAlmacenada = rs.getString("password");

                    // Encriptar la contraseña proporcionada por el usuario para comparar
                    String passwordIngresada = Utilidades.encriptarSHA3(objeto.getPassword());

                    // Compara la contraseña ingresada con la almacenada en la base de datos
                    if (passwordIngresada.equals(passwordAlmacenada)) {
                        usuario = new Usuario(); // Crea un nuevo objeto Usuario
                        usuario.setId_usuario(id_usuario); // Establece el ID del usuario
                        usuario.setUsername(objeto.getUsername()); // Establece el nombre de usuario
                        usuario.setTipo_nivel(tipo_nivel); // Establece el tipo de nivel
                        usuario.setEstatus(estatus); // Establece el estatus
                    } else {
                        // Imprime mensaje si la contraseña no coincide
                        System.out.println("La contraseña no coincide.");
                    }
                } else {
                    // Imprime mensaje si no se encuentra el usuario
                    System.out.println("No se encontró ningún usuario con el nombre de usuario proporcionado.");
                }
            }
        } catch (SQLException e) {
            // Maneja las excepciones SQL y muestra un mensaje de error
            // Logger.getLogger(Ctrl_Usuario.class.getName()).log(Level.SEVERE, "Error al autenticar al usuario", e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Por favor, inténtelo de nuevo.");
        }
        return usuario; // Retorna el usuario autenticado o null si no se autenticó
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                               Metodo para guardar un usuario
    //---------------------------------------------------------------------------------------------------------------------//
    public boolean guardarUsuario(Usuario usuario) {
        boolean respuesta = false; // Inicializa la variable de respuesta como false
        // SQL para insertar un nuevo usuario en la base de datos
        String sql = "INSERT INTO tb_usuarios (nombre_usuario, email, telefono, username, password, "
                + "tipo_nivel, estatus, registrado_por, imagen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // Establece la conexión a la base de datos
            Connection cn = Conexion.conectar();
            // Prepara la consulta SQL para la inserción de datos
            PreparedStatement pst = cn.prepareStatement(sql);

            // Establece los valores de los parámetros en la consulta
            pst.setString(1, usuario.getNombre_usuario()); // Establece el nombre del usuario
            pst.setString(2, usuario.getEmail()); // Establece el email del usuario
            pst.setString(3, usuario.getTelefono()); // Establece el teléfono del usuario
            pst.setString(4, usuario.getUsername()); // Establece el nombre de usuario
            // Encripta la contraseña del usuario antes de insertarla en la base de datos
            pst.setString(5, Utilidades.encriptarSHA3(usuario.getPassword()));
            pst.setString(6, usuario.getTipo_nivel()); // Establece el tipo de nivel del usuario
            pst.setString(7, usuario.getEstatus()); // Establece el estatus del usuario
            pst.setString(8, usuario.getRegistrado_por()); // Establece el nombre del registrador

            // Obtiene la imagen del usuario
            byte[] imagen = usuario.getImagen();
            if (imagen != null) {
                // Si la imagen no es null, se establece como un parámetro de tipo byte[]
                pst.setBytes(9, imagen);
            } else {
                // Si la imagen es null, se establece el parámetro como null en la base de datos
                pst.setNull(9, java.sql.Types.BLOB);
            }
            // Ejecuta la actualización en la base de datos y verifica si la inserción fue exitosa
            if (pst.executeUpdate() > 0) {
                respuesta = true;  // Cambia la respuesta a true si la inserción fue exitosa
            }
            // Cierra la conexión a la base de datos
            cn.close();
        } catch (SQLException e) {
            // Captura y muestra cualquier excepción SQL que ocurra durante la ejecución
            System.out.println("Error al guardar el usuario: " + e);
        }
        // Retorna la respuesta indicando si la inserción fue exitosa o no
        return respuesta;
    }

    //----------------------------------------------------------------------------------------------------------------------//
//                                                     Método para actualizar un usuario en la base de datos
//----------------------------------------------------------------------------------------------------------------------//
    public boolean actualizarUsuario(Usuario usuario) {
        boolean respuesta = false; // Inicializa la variable de respuesta como false
        // SQL para actualizar un usuario existente en la base de datos
        String sql = "UPDATE tb_usuarios SET nombre_usuario=?, email=?, telefono=?, username=?, password=?,"
                + " tipo_nivel=?, estatus=?, registrado_por=?, imagen=? WHERE id_usuario=?";

        try {
            // Establece la conexión a la base de datos
            Connection cn = Conexion.conectar();
            // Prepara la consulta SQL para la actualización de datos
            PreparedStatement pst = cn.prepareStatement(sql);

            // Establece los valores de los parámetros en la consulta
            pst.setString(1, usuario.getNombre_usuario());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getTelefono());
            pst.setString(4, usuario.getUsername());
            // Encripta la contraseña del usuario antes de actualizarla en la base de datos
            pst.setString(5, Utilidades.encriptarSHA3(usuario.getPassword()));
            pst.setString(6, usuario.getTipo_nivel());
            pst.setString(7, usuario.getEstatus());
            pst.setString(8, usuario.getRegistrado_por());

            // Obtiene la imagen del usuario
            byte[] imagen = usuario.getImagen();
            if (imagen != null) {
                // Si la imagen no es null, se establece como un parámetro de tipo byte[]
                pst.setBytes(9, imagen);
            } else {
                // Si la imagen es null, se establece el parámetro como null en la base de datos
                pst.setNull(9, java.sql.Types.BLOB);
            }
            // Establece el ID del usuario que se actualizará
            pst.setInt(10, usuario.getId_usuario());

            // Ejecuta la actualización en la base de datos y verifica si la actualización fue exitosa
            if (pst.executeUpdate() > 0) {
                respuesta = true;   // Cambia la respuesta a true si la actualización fue exitosa
            }
            // Cierra la conexión a la base de datos
            cn.close();
        } catch (SQLException e) {
            // Captura y muestra cualquier excepción SQL que ocurra durante la ejecución
            System.out.println("Error al actualizar el usuario: " + e);
        }
        // Retorna la respuesta indicando si la actualización fue exitosa o no
        return respuesta;
    }
//----------------------------------------------------------------------------------------------------------------------//
//                                                     Método para eliminar un usuario de la base de datos
//----------------------------------------------------------------------------------------------------------------------//

    public boolean eliminarUsuario(int idUsuario) {
        boolean respuesta = false; // Inicializa la variable de respuesta como false
        // SQL para eliminar un usuario basado en su ID
        String sql = "DELETE FROM tb_usuarios WHERE id_usuario=?";

        try {
            // Establece la conexión a la base de datos
            Connection cn = Conexion.conectar();
            // Prepara la consulta SQL para la eliminación de datos
            PreparedStatement pst = cn.prepareStatement(sql);
            // Establece el ID del usuario que se desea eliminar
            pst.setInt(1, idUsuario);

            // Ejecuta la actualización en la base de datos y verifica si la eliminación fue exitosa
            if (pst.executeUpdate() > 0) {
                respuesta = true;  // Cambia la respuesta a true si la eliminación fue exitosa
            }
            
            // Cierra la conexión a la base de datos
            cn.close();
        } catch (SQLException e) {
            // Captura y muestra cualquier excepción SQL que ocurra durante la ejecución
            System.out.println("Error al eliminar el usuario: " + e);
        }
        // Retorna la respuesta indicando si la eliminación fue exitosa o no
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

                // Verificar si las fechas no son nulas antes de asignarlas
                Date fechaCreacion = rs.getDate("fecha_creacion");
                if (fechaCreacion != null) {
                    usuario.setFecha_creacion(fechaCreacion);
                }

                Date ultimaSesion = rs.getDate("ultima_sesion");
                if (ultimaSesion != null) {
                    usuario.setUltima_sesion(ultimaSesion);
                }

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

    /*
 * ------------------------------------------------------------------------------------------------------------------------
 *                                               Método para actualizar la última sesión
 * ------------------------------------------------------------------------------------------------------------------------
     */
    public void updateUsuario(Usuario usuario) {
        String sql = "UPDATE tb_usuarios SET ultima_sesion = ? WHERE username = ?";

        try (
                Connection cn = Conexion.conectar(); PreparedStatement pst = cn.prepareStatement(sql)) {
            pst.setTimestamp(1, new java.sql.Timestamp(usuario.getUltima_sesion().getTime()));
            pst.setString(2, usuario.getUsername());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }

    /*
 * ------------------------------------------------------------------------------------------------------------------------
 *                                               Método para obtener laimagen del usuario
 * ------------------------------------------------------------------------------------------------------------------------
     */
    public byte[] obtenerImagenUsuario(String username) {
        byte[] imagen = null;
        String sql = "SELECT imagen FROM tb_usuarios WHERE username = ?";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                imagen = rs.getBytes("imagen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagen;
    }

    //---------------------------------------------------------------------------------------------------------------------//
    //                                                   Metodo para mostrar la cantidad de usuarios 
    //---------------------------------------------------------------------------------------------------------------------//
    public int contarUsuarios() {
        int totalUsuarios = 0;
        String sql = "SELECT  COUNT(*) AS total from tb_usuarios";

        try {
            Connection cn = Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalUsuarios = rs.getInt("total");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Maneja excepciones
        }
        return totalUsuarios; // Retorna el total de usuarios
    }
   

}
