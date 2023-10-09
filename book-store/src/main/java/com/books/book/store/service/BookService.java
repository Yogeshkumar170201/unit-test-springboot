package com.books.book.store.service;

import com.books.book.store.model.Book;

import java.util.List;

public interface BookService {
    void addBook(Book book) throws Exception;

    List<Book> getAllBooks();

    void deleteBook(String name) throws Exception;

    void updateBook(Book book, String name) throws Exception;
}
