package com.limasys.controller;

import java.util.Scanner;

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
                    case 1:
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
                    case 2 :
                        System.out.println("The Book Written By The Author : ");
                        break ;
                    case 3:

                        System.out.println("\n===== BOOKS =====");

                        libraryService.getAllBooks()
                                .forEach(book -> System.out.println(book.display()));

                        System.out.println("\n===== MAGAZINES =====");

                        libraryService.getAllMagazines()
                                .forEach(magazine -> System.out.println(magazine.display()));

                        break;
                    case 4 :
                        System.out.println("Borrowing Book Confirmed");
                        break ;
                    case 5 :
                        System.out.println("Returning Book Confirmed");
                        break ;
                    default :
                        System.out.println("Program Exit");
                }
            } while(InputUtil.wantToContinue(sc));
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

