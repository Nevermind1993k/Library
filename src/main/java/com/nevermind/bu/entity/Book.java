package com.nevermind.bu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Book Entity Class
 * Contains data about book(s) and write them
 *
 * @author Roman Kovaliov
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @Column(name = "PAGES", nullable = false)
    private int pages;

    @Column(name = "GENRE")
    private String genre;

    public Book(String name, Author author, int pages, String genre) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }
}
