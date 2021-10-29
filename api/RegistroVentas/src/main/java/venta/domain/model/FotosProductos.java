package venta.domain.model;

public class FotosProductos {
    private long idProducto;
    private byte[] nombre;

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public byte[] getNombre() {
        return nombre;
    }

    public void setNombre(byte[] nombre) {
        this.nombre = nombre;
    }
}
