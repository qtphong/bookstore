package com.bookstore.controller;

import com.bookstore.model.Author;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;

public class BookManager {
    public static void main(String[] args){
       BookService bk = new BookService();
       bk.listBook();

    }
}
