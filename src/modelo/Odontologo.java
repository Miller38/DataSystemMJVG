
package modelo;


import java.util.Date;

/**
 *
 * @author Miller
 */
public class Odontologo {
    
    private int id;
    private String nombre_odontologo;
    private String apellido;
    private String direccion;
    private String ciudad;
    private String pais;
    private String especialidad;
    private String telefono;
    private String email;
    private String identificacion;
    private byte[] imagen;
    private String tipo_identificacion;
    private Date fecha_nacimiento;
    private String genero;
    private String numero_licencia;
    private Date fecha_registro;

    public Odontologo() {
    }

    public Odontologo(int id, String nombre_odontologo, String apellido, String direccion, String ciudad, String pais, String especialidad, String telefono, String email, String identificacion, byte[] imagen, String tipo_identificacion, Date fecha_nacimiento, String genero, String numero_licencia, Date fecha_registro) {
        this.id = id;
        this.nombre_odontologo = nombre_odontologo;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.pais = pais;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.email = email;
        this.identificacion = identificacion;
        this.imagen = imagen;
        this.tipo_identificacion = tipo_identificacion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.numero_licencia = numero_licencia;
        this.fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_odontologo() {
        return nombre_odontologo;
    }

    public void setNombre_odontologo(String nombre_odontologo) {
        this.nombre_odontologo = nombre_odontologo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNumero_licencia() {
        return numero_licencia;
    }

    public void setNumero_licencia(String numero_licencia) {
        this.numero_licencia = numero_licencia;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

   
}
