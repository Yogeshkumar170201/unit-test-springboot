package com.books.book.store.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long bookId;
    @Column(
            unique = true
    )
    @NotNull
    private String name;
    @NotNull
    private double price;
    @NotNull
    private String authorName;
    @NotNull
    private float rating;

}
