package com.limasys.repository;

import com.limasys.entity.Book;
import com.limasys.entity.Magazine;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    private final List<Book> books = new ArrayList<>();
    private final List<Magazine> magazines = new ArrayList<>();

    public LibraryRepository() {
        loadBooks();
        loadMagazines();
    }

    private void loadBooks() {
        Book b1 = new Book();
        b1.setId(1);
        b1.setTitle("Clean Code");
        b1.setGenre("Programming");
        b1.setAuthor("Robert Martin");
        b1.setAddedAt(LocalDateTime.now());

        Book b2 = new Book();
        b2.setId(2);
        b2.setTitle("Effective Java");
        b2.setGenre("Programming");
        b2.setAuthor("Joshua Bloch");
        b2.setAddedAt(LocalDateTime.now());

        books.add(b1);
        books.add(b2);
    }

    private void loadMagazines() {
        Magazine m1 = new Magazine();
        m1.setId(101);
        m1.setTitle("Tech Monthly");
        m1.setGenre("Technology");
        m1.setIssueNumber(1);

        Magazine m2 = new Magazine();
        m2.setId(102);
        m2.setTitle("Science Today");
        m2.setGenre("Science");
        m2.setIssueNumber(15);

        magazines.add(m1);
        magazines.add(m2);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }
}