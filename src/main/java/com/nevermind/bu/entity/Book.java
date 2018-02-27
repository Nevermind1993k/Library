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
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    @Column(name = "PAGES", nullable = false)
    private int pages;

    @Column(name = "GENRE")
    private String genre;

}
