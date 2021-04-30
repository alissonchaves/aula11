package br.una.alisson.aula11.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidade;

    private Long total;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido ped;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto pro;

    public Item() {
    }

    public Item(Long id, Long quantidade, Long total, Pedido ped, Produto pro) {
        this.id = id;
        this.quantidade = quantidade;
        this.total = total;
        this.ped = ped;
        this.pro = pro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Pedido getPed() {
        return ped;
    }

    public void setPed(Pedido ped) {
        this.ped = ped;
    }

    public Produto getPro() {
        return pro;
    }

    public void setPro(Produto pro) {
        this.pro = pro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(quantidade, item.quantidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantidade);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", quantidade='" + quantidade + '\'' +
                ", total='" + total + '\'' +
                ", pedido_id='" + ped + '\'' +
                ", produto_id='" + pro + '\'' +
                '}';
    }
}