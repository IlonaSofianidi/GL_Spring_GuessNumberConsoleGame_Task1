package study.basecamp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Guess Number");

        // create context
        ConfigurableApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        // get bean
        study.basecamp.ConsoleUserGame consoleUserGame
                = context.getBean("consoleUserGame", study.basecamp.ConsoleUserGame.class);
        consoleUserGame.start();

        // close context
        context.close();


    }
}
