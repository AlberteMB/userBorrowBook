package com.example.userBorrowBook.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserApp {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String userAppName;
    private String email;
    private String password;
    private int age;
    private String address;
    private boolean isArchived;
    private LocalDate dob;

    // let s relation book with user many to many
    // with join table and bidirectional: the owner will be user
    //
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "APPUSER_BOOK_JOINTABLE",
                joinColumns = { @JoinColumn(name = "USERAPP_FK")},
                inverseJoinColumns = {@JoinColumn(name = "BOOK_FK") })
    private List<Book> books;

}
