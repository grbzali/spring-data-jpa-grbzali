package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private double total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private Set<Book> orderBooks;

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

    public Set<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBook(Set<Book> orderBooks) {
        this.orderBooks = orderBooks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", user=" + user +
                ", orderBooks=" + orderBooks +
                '}';
    }
}