package com.nevermind.bu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Literature Entity Class
 * Contains data about literature and write them
 *
 * @author Roman Kovaliov
 */
@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
public class Literature {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "literature", cascade = CascadeType.ALL)
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "BOOK_ID")
    private List<Book> books;

    public Literature(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String str = "Literature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=";
        for (Book book : books) {
            str += book.getName() + "; ";
        }
        return str + "}";
    }
}
