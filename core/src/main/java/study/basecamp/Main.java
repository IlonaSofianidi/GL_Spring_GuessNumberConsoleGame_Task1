package study.basecamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        log.info("Guess Number");

        // create context
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        // get bean
        study.basecamp.NumberGenerator numberGenerator
                = context.getBean("numberGenerator", study.basecamp.NumberGenerator.class);

        // biz logic
        int guess = numberGenerator.next();
        log.info("My guess = {}", guess);

        // get bean
        study.basecamp.Game game = context.getBean(study.basecamp.Game.class);
        game.setGuess(guess);

        log.info("Result = {}", game.isGameWon() ? "Win" : "Lose");

        // close context
        context.close();


    }
}
