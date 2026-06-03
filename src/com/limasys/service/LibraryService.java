package com.limasys.service;

import com.limasys.entity.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private final List<Book> books = new ArrayList<>();

    public void addBook(int id,
                        String title,
                        String genre,
                        String author,
                        int isbn) {

        Book book = new Book();

        book.setId(id);
        book.setTitle(title);
        book.setGenre(genre);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setAddedAt(LocalDateTime.now());

        books.add(book);
    }

}
