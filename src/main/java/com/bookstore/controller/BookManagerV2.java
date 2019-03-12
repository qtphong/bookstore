package com.bookstore.controller;

import com.bookstore.service.AuthorServiceImpl;
import com.bookstore.service.AuthorServiceV2;
import com.bookstore.service.BookServiceImpl;
import com.bookstore.service.BookServiceV2;

public class BookManagerV2 {

  public static void main(String[] args) {
    BookServiceV2 bookServiceV2 = new BookServiceImpl();
    bookServiceV2.getListBook();

    AuthorServiceV2 authorServiceV2 = new AuthorServiceImpl();
    authorServiceV2.getListAuthor();
  }

}
