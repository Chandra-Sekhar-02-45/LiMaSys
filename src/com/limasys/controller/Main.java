package com.limasys.controller;

import java.util.Scanner;

import com.limasys.entity.Book;
import com.limasys.entity.SearchResult;
import com.limasys.exceptions.BookNotAvailableException;
import com.limasys.service.LibraryService;
import com.limasys.util.InputUtil;

public class Main {
    private final LibraryService libraryService = new LibraryService();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run(String... args) {
        // Scanner is automatically closed using try-with-resources
        try(Scanner sc = new Scanner(System.in)) {
            do {
                int option = InputUtil.acceptMenuOption(sc);
                switch(option) {
                    case 1: {
                        System.out.print("Enter Book Id : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title : ");
                        String title = sc.nextLine();

                        System.out.print("Enter Genre : ");
                        String genre = sc.nextLine();

                        System.out.print("Enter Author : ");
                        String author = sc.nextLine();

                        System.out.print("Enter ISBN : ");
                        int isbn = sc.nextInt();

                        libraryService.addBook(id, title, genre, author, isbn);

                        System.out.println("Book Added Successfully");
                        break;
                    }
                    case 2 : {
                        sc.nextLine();

                        System.out.print("Enter Author Name : ");
                        String author = sc.nextLine();

                        SearchResult<Book> result =
                                libraryService.searchByAuthor(author);

                        System.out.println("\nSearch Results:");

                        if (result.getResults().isEmpty()) {
                            System.out.println("No books found.");
                        } else {

                            result.getResults()
                                    .forEach(book ->
                                            System.out.println(book.display()));
                        }

                        break;
                    }
                    case 3: {
                        System.out.println("\n===== BOOKS =====");

                        libraryService.getAllBooks()
                                .forEach(book -> System.out.println(book.display()));

                        System.out.println("\n===== MAGAZINES =====");

                        libraryService.getAllMagazines()
                                .forEach(magazine -> System.out.println(magazine.display()));

                        System.out.println("\n");
                        break;
                    }
                    case 4: {

                        System.out.print("Enter Book Id : ");
                        int bookId = sc.nextInt();

                        try {
                            libraryService.borrowBook(bookId);
                        }
                        catch(BookNotAvailableException exception) {
                            System.out.println(exception.getMessage());
                        }

                        break;
                    }
                    case 5 : {
                        System.out.println("Returning Book Confirmed");
                        break;
                    }
                    default : {
                        System.out.println("Program Exit");
                    }
                }
            } while(InputUtil.wantToContinue(sc));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

