package com.nevermind.bu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@NoArgsConstructor
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

    @Column(name = "GENRE")
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    private Literature literature;

    public Book(String name, String author, int pages, String genre, Literature literature) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
        this.literature = literature;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", genre='" + genre + '\'' +
                ", literature=" + literature +
                '}';
    }
}
