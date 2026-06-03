package com.limasys.service;

import com.limasys.entity.Book;
import com.limasys.entity.Magazine;
import com.limasys.repository.LibraryRepository;

import java.time.LocalDateTime;
import java.util.List;

public class LibraryService {

    private final LibraryRepository repository;

    public LibraryService() {
        repository = new LibraryRepository();
    }

    public List<Book> getAllBooks() {
        return repository.getBooks();
    }

    public List<Magazine> getAllMagazines() {
        return repository.getMagazines();
    }

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

        repository.getBooks().add(book);
    }
}