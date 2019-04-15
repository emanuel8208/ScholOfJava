    package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import repository.TransactionRepository;

    @Configuration
@ComponentScan( basePackages = {"services", "repository"})
public class ProjectConfig {

        @Bean
        public TransactionRepository transactionRepository() {
            TransactionRepository transactionRepository = new TransactionRepository();
            transactionRepository.setName("asd");
            return transactionRepository;
        }
    }

