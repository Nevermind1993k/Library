package com.nevermind.bu.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Book Entity Class
 * Contains data about book(s) and write them
 */
@Entity
@Table(name = "BOOKS")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "PAGES", nullable = false)
    private int pages;

    public Book(String name, String author, int pages) {
        this.name = name;
        this.author = author;
        this.pages = pages;
    }
}
