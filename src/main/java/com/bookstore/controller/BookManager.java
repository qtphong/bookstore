package com.bookstore.controller;

import com.bookstore.service.BookService;

public class BookManager {
    public static void main(String[] args){
        BookService bs = new BookService();
        bs.deleteBook(7);
        bs.addBook("Book1","Book1");
        bs.listBook();

    }
}
