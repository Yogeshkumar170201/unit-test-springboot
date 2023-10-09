package com.books.book.store.service;

import com.books.book.store.model.Book;
import com.books.book.store.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;


    @Test
    public void BookService_AddBook_ReturnNothing() {
        Book book = Book.builder()
                .name("Book1")
                .price(893)
                .authorName("Author1")
                .rating(8.9f)
                .build();

        when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);
        Assertions.assertAll(()->bookService.addBook(book));

    }

    @Test
    public void BookService_GetAllBooks_ReturnsAllBooks(){
        List<Book> books = Arrays.asList(Mockito.mock(Book.class));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> returnedBooks = bookService.getAllBooks();
        Assertions.assertSame(books, returnedBooks);
        Assertions.assertTrue(returnedBooks.size()>0);
    }


    @Test
    public void BookService_DeleteBook_ReturnsNull(){
        Book book = Mockito.mock(Book.class);
        when(bookRepository.findByName("book1")).thenReturn(book);
        Assertions.assertAll(()->bookService.deleteBook("book1"));
    }

    @Test
    public void BookService_UpdateBook_ReturnsNull(){
        Book book = Mockito.mock(Book.class);
        when(bookRepository.findByName("book1")).thenReturn(book);
        when(bookRepository.save(book)).thenReturn(book);
        Assertions.assertAll(()->bookService.updateBook(book, "book1"));
    }

}