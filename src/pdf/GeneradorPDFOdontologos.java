
package pdf;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import conexion.Conexion; // Importa la clase Conexion del paquete conexion
import java.sql.Connection; // Importa la clase Connection de java.sql
import java.sql.PreparedStatement; // Importa la clase PreparedStatement de java.sql
import java.sql.SQLException; // Importa la clase SQLException de java.sql
import javax.swing.JOptionPane; // Importa la clase JOptionPane de javax.swing
import java.sql.ResultSet; // Importa la clase ResultSet de java.sql

//import para itext
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author Miller
 */
public class GeneradorPDFOdontologos {
    
      public void generarReporteOdontologos() {
    Document documento = new Document(); // Crea un nuevo documento PDF.
    try {
        String ruta = System.getProperty("user.home"); // Obtiene la ruta del directorio del usuario.
        PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Odontologos.pdf")); 
        // Inicializa el escritor de PDF y especifica la ruta donde se guardará el archivo.

        Image header = Image.getInstance("src/images/header.png"); // Carga una imagen desde la ruta especificada.
        header.scaleToFit(550, 1300); // Ajusta el tamaño de la imagen.
        header.setAlignment(Chunk.ALIGN_CENTER); // Centra la imagen en el documento.

        Paragraph parrafo = new Paragraph(); // Crea un nuevo párrafo.
        parrafo.setAlignment(Paragraph.ALIGN_CENTER); // Centra el texto del párrafo.
        parrafo.add("Formato creado por MIllIANY TECH ® \n\n"); // Agrega texto al párrafo.
        parrafo.setFont(FontFactory.getFont("Tahoma", 18, com.itextpdf.text.Font.BOLD, BaseColor.DARK_GRAY)); 
        // Establece la fuente, el tamaño, el estilo y el color del texto.
        parrafo.add("Reporte Oodntologos \n\n"); // Agrega más texto al párrafo.

        documento.open(); // Abre el documento para agregar contenido.

        documento.add(header); // Agrega la imagen al documento.
        documento.add(parrafo); // Agrega el párrafo al documento.

        PdfPTable tabla = new PdfPTable(8); // Crea una tabla con 7 columnas.
        tabla.addCell("Nombre"); // Agrega una celda con el encabezado "ID".
        tabla.addCell("Apellido"); // Agrega una celda con el encabezado "Usuario".
         tabla.addCell("Direccion");
        tabla.addCell("Ciudad"); // Agrega una celda con el encabezado "Nombre".
        tabla.addCell("Telefono"); // Agrega una celda con el encabezado "Apellido".
        tabla.addCell("Email"); // Agrega una celda con el encabezado "Telefono".
        tabla.addCell("Identificacion"); // Agrega una celda con el encabezado "Email".
        tabla.addCell("Genero");
        
        try {
            Connection con = Conexion.conectar(); // Establece una conexión con la base de datos.
            PreparedStatement pst = con.prepareStatement("SELECT nombre_odontologo, apellido, direccion, ciudad, telefono, email, identificacion, genero FROM tb_odontologos"); 
            // Prepara una declaración SQL para seleccionar todos los registros de la tabla "usuarios".
            ResultSet rs = pst.executeQuery(); // Ejecuta la declaración SQL y obtiene los resultados.

            if (rs.next()) { // Comprueba si hay resultados.
                do {
                    tabla.addCell(rs.getString(1)); // Agrega el valor de la primera columna a la tabla.
                    tabla.addCell(rs.getString(2)); // Agrega el valor de la segunda columna a la tabla.
                    tabla.addCell(rs.getString(3)); // Agrega el valor de la tercera columna a la tabla.
                    tabla.addCell(rs.getString(4)); // Agrega el valor de la cuarta columna a la tabla.
                    tabla.addCell(rs.getString(5)); // Agrega el valor de la quinta columna a la tabla.
                    tabla.addCell(rs.getString(6)); // Agrega el valor de la sexta columna a la tabla.
                    tabla.addCell(rs.getString(7)); // Agrega el valor de la séptima columna a la tabla
                    tabla.addCell(rs.getString(8));
                    
                } while (rs.next()); // Continúa hasta que no haya más resultados.

                documento.add(tabla); // Agrega la tabla al documento.
                
            }
        } catch (DocumentException | SQLException e) {
            e.printStackTrace(); // Maneja excepciones relacionadas con el documento o la base de datos.
        }
        documento.close(); // Cierra el documento.
        
        JOptionPane.showMessageDialog(null, "Reporte PDF creado con éxito."); 
        // Muestra un mensaje indicando que el reporte se creó con éxito.
    } catch (DocumentException | HeadlessException | FileNotFoundException e) {
        e.printStackTrace(); // Maneja excepciones relacionadas con el documento, GUI o archivo no encontrado.
    } catch(IOException e){
        System.out.println("Error en la imagen " + e); // Maneja excepciones relacionadas con la imagen.
    }
}
    
}
