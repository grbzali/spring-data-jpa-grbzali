package com.hkarabakla;

import com.hkarabakla.book.Book;
import com.hkarabakla.book.BookService;
import com.hkarabakla.category.CategoryService;
import com.hkarabakla.user.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hkarabakla");
        appContext.refresh();

        UserService userService = (UserService) appContext.getBean("userService");
        userService.userNameSearch();

        CategoryService categoryService = (CategoryService) appContext.getBean("categoryService");
        categoryService.categoryOperations();

        BookService bookService = (BookService) appContext.getBean("bookService");
        bookService.bookNameSearch();

        appContext.close();
    }
}
