package com.nevermind.bu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Literature Entity Class
 * Contains data about literature and write them
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    public Literature(String name) {
        this.name = name;
    }
}
