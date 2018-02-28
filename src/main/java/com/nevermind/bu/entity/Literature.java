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
//@Getter
//@Setter
@NoArgsConstructor
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "literature", cascade = CascadeType.ALL)
    private List<Author> authors;

    public Literature(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Literature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=");
        for (Author author : authors) {
            str.append(author.getName()).append("; ");
        }
        return str.toString() + "}";
    }
}
