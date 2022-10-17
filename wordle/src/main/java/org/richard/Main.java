package org.richard;

import java.util.Scanner;
import static org.richard.Game.*;
import static org.richard.Util.getRandomWord;
public class Main {
    private static String rightGuess;
    private static String userGuess;
    private static int totalAttempt;
    private static int attemptLeft;

    public static void main(String[] args) {
        welcome();
        rightGuess = getRandomWord();
        Scanner scanner = new Scanner(System.in);

        totalAttempt = getDifficulty(scanner);
        attemptLeft = totalAttempt;
        while (attemptLeft > 0 && attemptLeft != 200) {
            System.out.printf("Enter word (attempt %d of %d):%n", attemptLeft, totalAttempt);
            userGuess = scanner.nextLine().toLowerCase();
            attemptLeft = validateGuess(userGuess, rightGuess, attemptLeft);
        }
        if (attemptLeft != 200) {
            System.out.printf("Uh oh, You lost. The right word was %s.", rightGuess);
        }
    }

}