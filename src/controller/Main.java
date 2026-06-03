package controller;

import java.util.Scanner;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run(String... args) {
        // Scanner is automatically closed using try-with-resources
        try(Scanner sc = new Scanner(System.in)) {
            do {
                int option = InputUtil.acceptMenuOption(sc);
                switch(option) {
                    case 1 :
                        System.out.println("Book Added Successfully");
                        break ;
                    case 2 :
                        System.out.println("The Book Written By The Author : ");
                        break ;
                    case 3 :
                        System.out.println("All Books In The Library : ");
                        break ;
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

