package study.basecamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import study.basecamp.config.AppConfig;
import study.basecamp.config.GameProperties;
import study.basecamp.game.ConsoleUserGame;
import study.basecamp.game.GameImpl;
import study.basecamp.game.NumberGeneratorImpl;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class AppConfigTest {
    @Autowired
   private GameImpl gameImpl;
    @Autowired
    private GameProperties gameProperties;
    @Autowired
    private NumberGeneratorImpl numberGenerator;
    @Autowired
    private ConsoleUserGame consoleUserGame;

    @Test
    public void testGameImpl() {
        assertEquals(
                "class study.basecamp.game.GameImpl",
                this.gameImpl.getClass().toString());
    }
    @Test
    public void testGameProperties(){
        assertEquals(
                "class study.basecamp.config.GameProperties",
                this.gameProperties.getClass().toString());
    }
    @Test
    public void testNumberGenerator(){
        assertEquals(
                "class study.basecamp.game.NumberGeneratorImpl",
                this.numberGenerator.getClass().toString());
    }
    @Test
    public void testConsoleUserGame(){
        assertEquals(
                "class study.basecamp.game.ConsoleUserGame",
                this.consoleUserGame.getClass().toString());
    }

}