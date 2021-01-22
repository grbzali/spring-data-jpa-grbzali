package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_book",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private Set<Book> orderBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getOrderBook() {
        return orderBook;
    }

    public void setOrderBook(Set<Book> orderBook) {
        this.orderBook = orderBook;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", user=" + user +
                ", orderBook=" + orderBook +
                '}';
    }
}