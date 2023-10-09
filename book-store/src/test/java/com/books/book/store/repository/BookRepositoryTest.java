package com.books.book.store.repository;

import com.books.book.store.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void BookRepository_AddBook_ReturnAddedBook(){
        Book book = Book.builder()
                .name("zzz")
                .price(1000)
                .authorName("aaa")
                .rating(7.9f)
                .build();
        Book bookRep = bookRepository.save(book);
        assertNotNull(bookRep);
        assertEquals(book.getName(), bookRep.getName());
        assertEquals(book.getPrice(), bookRep.getPrice());
        assertEquals(book.getAuthorName(), bookRep.getAuthorName());
        assertEquals(book.getRating(), bookRep.getRating());
        assertTrue(bookRep.getBookId()>0);
    }

    @Test
    public void BookRepository_getAllBooks_ReturnAllBooks(){
        Book book1 = Book.builder()
                .name("ab")
                .price(500)
                .authorName("bb")
                .rating(6.8f)
                .build();
        Book book2 = Book.builder()
                .name("ac")
                .price(700)
                .authorName("zz")
                .rating(9.6f)
                .build();
        bookRepository.save(book1);
        bookRepository.save(book2);

        List<Book> books = bookRepository.findAll();
        assertNotNull(books);
        assertTrue(books.size()>=2);
    }

    @Test
    public void BookRepository_DeleteBookByName_ReturnNull(){
        Book book = Book.builder()
                .name("book1")
                .price(500)
                .authorName("bb")
                .rating(6.8f)
                .build();
        Book addedBook = bookRepository.save(book);
        bookRepository.delete(addedBook);
        Book bookAfterDeletion = bookRepository.findByName(addedBook.getName());
        assertNull(bookAfterDeletion);
    }


    @Test
    public void BookRepository_UpdateBookByName_ReturnUpdatedBook(){
        Book book = Book.builder()
                .name("book1")
                .price(500)
                .authorName("bb")
                .rating(6.8f)
                .build();
        Book addedBook = bookRepository.save(book);
        addedBook.setName("book2");
        addedBook.setAuthorName("cc");
        addedBook.setPrice(456);
        addedBook.setRating(4.6f);
        Book updatedBook = bookRepository.save(addedBook);
        assertNotNull(updatedBook);
        assertEquals(addedBook.getName(), updatedBook.getName());
        assertEquals(addedBook.getAuthorName(), updatedBook.getAuthorName());
        assertEquals(addedBook.getPrice(), updatedBook.getPrice());
        assertEquals(addedBook.getRating(), updatedBook.getRating());
        assertEquals(addedBook.getBookId(), updatedBook.getBookId());
        assertTrue(updatedBook.getBookId()>0);
    }

}