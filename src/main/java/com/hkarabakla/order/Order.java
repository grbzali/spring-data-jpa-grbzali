package com.hkarabakla.order;

import com.hkarabakla.book.Book;
import com.hkarabakla.user.User;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private double total;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_books",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> orderBooks;

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

    public List<Book> getOrderBooks() {
        return orderBooks;
    }

    public void setOrderBook(List<Book> orderBooks) {
        this.orderBooks = orderBooks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total=" + total +
                ", orderBooks=" + orderBooks +
                '}';
    }
}