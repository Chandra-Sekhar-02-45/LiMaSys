package com.limasys.service;

import com.limasys.entity.Book;
import com.limasys.entity.Magazine;
import com.limasys.entity.SearchResult;
import com.limasys.exceptions.BookNotAvailableException;
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

    public SearchResult<Book> searchByAuthor(String author) {

        List<Book> filteredBooks =
                repository.getBooks()
                        .stream()
                        .filter(book ->
                                book.getAuthor()
                                        .toLowerCase()
                                        .contains(author.toLowerCase()))
                        .toList();

        return new SearchResult<>(filteredBooks, author);
    }

    public void borrowBook(int bookId)
            throws BookNotAvailableException {

        Book book = repository.getBooks()
                .stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);

        if(book == null) {
            System.out.println("Book Not Found");
            return;
        }

        if(!book.isAvailable()) {
            throw new BookNotAvailableException(
                    "Book Already Borrowed");
        }

        book.borrow();

        System.out.println(
                book.getTitle() +
                        " Borrowed Successfully");
    }

    public void returnBook(int bookId) {

        Book book = repository.getBooks()
                .stream()
                .filter(b -> b.getId() == bookId)
                .findFirst()
                .orElse(null);

        if(book == null) {
            System.out.println("Book Not Found");
            return;
        }

        book.returnItem();

        System.out.println(
                book.getTitle() +
                        " Returned Successfully");
    }
}