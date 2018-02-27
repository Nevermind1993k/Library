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
@NoArgsConstructor
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "literature", cascade = CascadeType.ALL)
    private List<Author> authors;

    @Override
    public String toString() {
        String str = "Literature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=";
        for (Author author : authors) {
            str += author.getName() + "; ";
        }
        return str + "}";
    }
}
