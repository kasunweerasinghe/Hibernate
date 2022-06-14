package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderDetail {
    @Id
    private String id;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Orders orders;

    private int Qty;

    public OrderDetail() {
    }

    public OrderDetail(String id, Item item, Orders orders, int qty) {
        this.id = id;
        this.item = item;
        this.orders = orders;
        Qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id='" + id + '\'' +
                ", item=" + item +
                ", orders=" + orders +
                ", Qty=" + Qty +
                '}';
    }
}
