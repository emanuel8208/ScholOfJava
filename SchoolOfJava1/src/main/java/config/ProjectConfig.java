package config;

import objects.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public Cat cat() {
        Cat c = new Cat();
        c.name = "TOM";
        return c;
    }
}
