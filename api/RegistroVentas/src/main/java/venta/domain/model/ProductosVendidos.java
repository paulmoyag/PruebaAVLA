package venta.domain.model;

import javax.persistence.*;

@Entity(name = "productos_vendidos")
public class ProductosVendidos {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id_venta")
    private long idVenta;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos producto;

    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
}
