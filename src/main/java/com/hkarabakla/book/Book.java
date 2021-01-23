package com.hkarabakla.book;

import com.hkarabakla.author.Author;
import com.hkarabakla.category.Category;
import com.hkarabakla.order.Order;

import javax.persistence.*;
import java.util.List;

@Entity(name = "books")
public class Book {

    @Id
    private String isbn;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "authorBook", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Author> authors;

    @ManyToMany(mappedBy = "orderBooks")
    private List<Order> orders;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", authors=" + authors +
                '}';
    }
}