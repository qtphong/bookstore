package com.bookstore.model;

import java.io.Serializable;
import org.hibernate.annotations.CollectionId;
import com.bookstore.model.Author;
import javax.persistence.*;

@Entity
@Table(name="books")
public class Book implements Serializable {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="authors_id")
    private Author author;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book(){}
    public Book( String title, String description){

        this.title = title;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", author=" + author +
            '}';
    }
}
