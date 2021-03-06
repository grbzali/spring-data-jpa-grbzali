package com.hkarabakla.book;

import com.hkarabakla.author.Author;
import com.hkarabakla.category.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void bookNameSearch(){
        Book book = new Book();
        book.setIsbn(UUID.randomUUID().toString());
        book.setName("java 101");

        Author author = new Author();
        author.setName("Ali");
        book.setAuthors(Arrays.asList(author));

        Category category = new Category();
        category.setName("Computer");
        book.setCategory(category);

        book.setPrice(10);
        book.setDescription("Java Tutorial");
        book.setImageUrl("image path");

        bookRepo.save(book);


        System.out.println(bookRepo.findAllByNameContainingIgnoreCase("java"));

    }
}
