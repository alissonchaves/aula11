package br.una.alisson.aula11.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Float total;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cli;

    public Pedido() {
    }

    public Pedido(Long id, String status, Float total, Cliente cli) {
        this.id = id;
        this.status = status;
        this.total = total;
        this.cli = cli;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(status, pedido.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", total='" + total + '\'' +
                ", cli='" + cli + '\'' +
                '}';
    }
}

// Cliente (status, total, fone)