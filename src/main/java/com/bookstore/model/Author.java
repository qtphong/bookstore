package com.bookstore.model;

import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="authors_id")
    private Set<Book> books;

    public Author(){}

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

    public Set getBooks() {
        return books;
    }

    public void setBooks(Set books) {
        this.books = books;
    }
}
