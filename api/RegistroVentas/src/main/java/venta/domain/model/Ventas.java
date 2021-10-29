package venta.domain.model;

import javax.persistence.*;

@Entity
public class Ventas {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;
    private double total;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
