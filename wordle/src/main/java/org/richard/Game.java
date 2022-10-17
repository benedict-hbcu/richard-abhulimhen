package org.richard;

import java.util.Scanner;

import static org.richard.Util.Result.*;
import static org.richard.Util.getFormattedLetter;

public class Game {
    public static void welcome() {
        System.out.println("===============================");
        System.out.println("= Welcome to Richard's Wordle =");
        System.out.println("===============================");
    }
    public static int getDifficulty(Scanner scanner) {
        System.out.println("What is your level of difficulty? Easy, Medium or Hard?");
        String difficulty = scanner.nextLine().toLowerCase();

        switch (difficulty) {
            case "easy":
                return 10;
            case "medium":
                return 6;
            case "hard":
                return 3;
            default:
                return getDifficulty(scanner);
        }
    }
    public static int validateGuess(String userGuess, String rightGuess, int attemptLeft) {
        if (userGuess.length() == rightGuess.length()) {
            if (userGuess.equals(rightGuess)) {
                System.out.println("===============================");
                System.out.println("Congratulations! You won Richard's wordle!");
                System.out.println("===============================");
                return 200;
            } else {
                int userIndex = 0;
                for (char letter : userGuess.toCharArray()) {
                    int rightIndex = rightGuess.indexOf(letter);
                    if ( rightIndex != -1) {
                        if (userIndex == rightIndex) {
                            System.out.print(getFormattedLetter(letter, HIT));
                        } else {
                            System.out.print(getFormattedLetter(letter, SEMI_HIT));
                        }
                    } else {
                        System.out.print(getFormattedLetter(letter, MISS));
                    }
                    userIndex += 1;
                }
                System.out.println();
            }
            attemptLeft -= 1;
        } else{
            System.out.printf("Your guess must be %d letters.%n", rightGuess.length());
        }
        return attemptLeft;
    }

}
