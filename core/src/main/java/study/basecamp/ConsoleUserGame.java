package study.basecamp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleUserGame {
    private Scanner scanner;
    private boolean gameOver;
    private GameImpl gameImpl;

    @Autowired
    public void setGameImpl(GameImpl gameImpl) {
        this.gameImpl = gameImpl;
    }

    public void start() {
        scanner = new Scanner(System.in);
        gameIntro();
        while (!gameOver) {
            playGame();

            log.info("Do you want to play again (y/n)?");
            String userChoice = scanner.next();
            if (userChoice.equalsIgnoreCase("n")) {
                gameOver = true;
            } else {
                gameImpl.reset();
            }
        }
    }

    private void playGame() {

        while (!gameImpl.isGameWon()) {
            log.info("Your guess?");
            int guess = scanner.nextInt();
            log.info("My guess = {}", guess);
            gameImpl.setGuess(guess);
            gameImpl.check();
            if (gameImpl.isGameWon()) {
                int countOfUserGuessesToWin = gameImpl.getGuessCount() - gameImpl.getRemainingGuesses();
                String msg = String.format("You got it right in %d guesses", countOfUserGuessesToWin);
                log.info(msg);

            } else if (guess > gameImpl.getNumber()) {
                log.info("It's lower.");
                printResults();

            } else {
                log.info("It's higher...");
                printResults();
            }
        }
    }

    private void printResults() {
        String msg = String.format("It's between %d and %d", gameImpl.getSmallest(), gameImpl.getBiggest());
        log.info(msg);
        String msg1 = String.format("You have %d guesses left ", gameImpl.getRemainingGuesses());
        log.info(msg1);
    }

    private void gameIntro() {
        log.info("Let's play a guessing game!");
        String msg = String.format("Number is between %d and %d .", gameImpl.getSmallest(), gameImpl.getBiggest());
        log.info(msg);
    }
}
