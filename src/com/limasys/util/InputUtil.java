package com.limasys.util;

import java.util.Scanner;

public class InputUtil {
    public static int acceptMenuOption(Scanner sc){
        System.out.println("Welcome To LiMaSys");
        System.out.println("Enter 1 : Add Book");
        System.out.println("Enter 2 : Search Books By Author");
        System.out.println("Enter 3 : Get All The Available Books & Magazines");
        System.out.println("Enter 4 : Borrow Book From Library");
        System.out.println("Enter 5 : Returning The Borrowed Book To Library");
        System.out.println("Enter 6 : Search Books By Genre");



        int selectedOption = sc.nextInt();
        if(selectedOption == 1) {
            return selectedOption ;
        }
        else if(selectedOption == 2) {
            return selectedOption ;
        }
        else if(selectedOption == 3) {
            return selectedOption ;
        }
        else if(selectedOption == 4) {
            return selectedOption ;
        }
        else if(selectedOption == 5) {
            return selectedOption ;
        }
        else {
            return acceptMenuOption(sc) ;
        }
    }

    public static boolean wantToContinue(Scanner sc) {
        System.out.println("To Continue Enter 'Y' or To Exit Program Enter 'F'");
        char selectedOption = sc.next().toUpperCase().charAt(0);
        return selectedOption == 'Y';
    }
}
