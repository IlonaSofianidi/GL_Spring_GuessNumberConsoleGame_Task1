package study.basecamp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public NumberGeneratorImpl numberGenerator(){
        return new NumberGeneratorImpl();
    }
    @Bean
    public GameImpl gameImpl(){
        return new GameImpl();
    }
}
