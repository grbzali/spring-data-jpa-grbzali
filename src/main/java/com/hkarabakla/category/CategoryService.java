package com.hkarabakla.category;

import com.hkarabakla.book.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void categoryOperations() {

        Book b1 = new Book();
        b1.setIsbn(UUID.randomUUID().toString());
        b1.setName("Spring in Action");

        Category c1 = new Category();
        c1.setName("Computer Science");
        c1.setBooks(Arrays.asList(b1));

        categoryRepo.save(c1);

        //System.out.println(b1);
        //System.out.println(c1);
    }
}
