package com.nevermind.bu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Author Entity Class
 * Contains data about literature and write them
 *
 * @author Roman Kovaliov
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Literature literature;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;

    public Author(String name, Literature literature) {
        this.name = name;
        this.literature = literature;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", literature=" + literature +
                ", books=");
        for (Book book : books) {
            str.append(book.getName()).append("; ");
        }
        return str.toString() + "}";
    }
}
