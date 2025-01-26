package Hangman;

import java.util.Scanner;
import java.util.Random;

public class HangmanGame {

    // Word bank for the game
    private static final String[] WORDS = {"java", "python", "programming", "hangman", "developer"};

    // Method to pick a random word
    private static String getRandomWord() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = getRandomWord();  // Randomly selected word
        char[] guessedWord = new char[wordToGuess.length()];  // Tracks guessed letters
        int attemptsLeft = 6;  // Number of wrong attempts allowed
        boolean wordGuessed = false;  // Flag to track if the word is fully guessed

        // Initialize guessed word with underscores
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        System.out.println("Welcome to Hangman Game!");

        // Game Loop
        while (attemptsLeft > 0 && !wordGuessed) {
            // Show current state of guessed word
            System.out.println("Word to guess: " + String.valueOf(guessedWord));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Enter a letter: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            // Check if the guessed letter is in the word
            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedWord[i] = guess;  // Reveal the letter
                    correctGuess = true;
                }
            }

            // If wrong guess, reduce attempts
            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Wrong guess! Try again.");
            }

            // Check if the word is fully guessed
            wordGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        // End of game: check win or lose
        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + wordToGuess);
        } else {
            System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
        }
    }
}

