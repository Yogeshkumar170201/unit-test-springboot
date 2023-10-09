package com.books.book.store.service;

import com.books.book.store.model.Book;
import com.books.book.store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) throws Exception {
        try {
            if(book.getAuthorName().isBlank()){
                throw new Exception("Author Name can't be empty");
            }
            if(book.getName().isBlank()){
                throw new Exception("Book Name can't be empty");
            }
            Book bookRep = bookRepository.save(book);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(String name) throws Exception {
        Book book =  bookRepository.findByName(name);
        if (book==null){
            throw new Exception("Book doesn't exist");
        }
        bookRepository.delete(book);
    }



    @Override
    public void updateBook(Book book, String name) throws Exception {
        Book bookRep =  bookRepository.findByName(name);
        if (bookRep==null){
            throw new Exception("Book doesn't exist");
        }
        try {
            bookRep.setName(book.getName());
            bookRep.setRating(book.getRating());
            bookRep.setAuthorName(book.getAuthorName());
            bookRep.setPrice(book.getPrice());
            Book updatedBook = bookRepository.save(bookRep);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
