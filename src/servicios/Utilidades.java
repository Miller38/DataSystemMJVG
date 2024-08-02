package servicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilidades {

    // Método para encriptar un texto utilizando SHA3-256
    public static String encriptarSHA3(String texto) {
        try {
            // Obtiene una instancia del algoritmo SHA3-256
            MessageDigest md = MessageDigest.getInstance("SHA3-256");
            // Convierte el texto en un array de bytes y calcula el hash
            byte[] hash = md.digest(texto.getBytes());
            // StringBuilder para construir el resultado en formato hexadecimal
            StringBuilder sb = new StringBuilder();
            // Convierte cada byte del hash en su representación hexadecimal
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            // Retorna el hash en formato hexadecimal como una cadena de texto
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Lanza una RuntimeException si el algoritmo SHA3-256 no está disponible
            throw new RuntimeException(e);
        }
    }

    // Método para verificar si una contraseña ingresada coincide con la contraseña almacenada
    public static boolean verificarPassword(String passwordIngresada, String passwordAlmacenada) {
        // Encripta la contraseña ingresada utilizando SHA3-256
        String passwordEncriptada = encriptarSHA3(passwordIngresada);
        // Compara la contraseña encriptada con la contraseña almacenada
        return passwordEncriptada.equals(passwordAlmacenada);
    }
}
