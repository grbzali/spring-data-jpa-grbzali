package com.hkarabakla.author;

import com.hkarabakla.author.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Integer> {


}
