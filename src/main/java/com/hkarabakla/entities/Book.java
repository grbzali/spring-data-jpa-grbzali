package com.hkarabakla.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    private String isbn;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToMany(mappedBy = "authorBook", cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<Author> authors;

    @ManyToMany(mappedBy = "orderBook",cascade = CascadeType.REMOVE)
    private Set<Order> orders;

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

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
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