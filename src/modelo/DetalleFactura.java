
package modelo;

/**
 *
 * @author Miller
 */
public class DetalleFactura {
    
    private int id;
    private int idFactura;
    private int idServicio;
    private int cantidad;
    private double precio;

    public DetalleFactura() {
    }

    public DetalleFactura(int id, int idFactura, int idServicio, int cantidad, double precio) {
        this.id = id;
        this.idFactura = idFactura;
        this.idServicio = idServicio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
}
