package com.bookstore.controller;

import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;
import java.util.Iterator;
import java.util.List;

public class BookManager {
    public static void main(String[] args){


     AuthorService as = new AuthorService();
     as.listAuthor();

    }
}
