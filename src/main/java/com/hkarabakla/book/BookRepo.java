package com.hkarabakla.book;

import com.hkarabakla.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book,Integer> {

    Book findByName(String name);

    List<Book> findAllByNameContainingIgnoreCase(String name);
}
