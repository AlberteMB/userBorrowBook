package com.example.userBorrowBook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;
    private int points;

    // let s create a relationship between UserApp and Borrow: one to many
    // let s create a relationship between Book and Borrow: one to many

    // in this case the relationship will be bidirectional
    // and the owner will be the Borrow entity

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn( name = "BOOK_ID", nullable = false)
    private Book book;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn( name = "USER_ID", nullable = false)
    private UserApp user;
}
