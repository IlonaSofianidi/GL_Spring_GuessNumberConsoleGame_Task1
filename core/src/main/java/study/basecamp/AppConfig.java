package study.basecamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@ComponentScan
@Configuration
public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public NumberGeneratorImpl numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public GameImpl gameImpl() {
        return new GameImpl();
    }

    @Bean
    public ConsoleUserGame consoleUserGame() {
        return new ConsoleUserGame();
    }

    @Bean
    public GameProperties gameProperties() {
        return new GameProperties();
    }

}
