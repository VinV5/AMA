package ama;

import ama.model.AMA;
import ama.model.User;
import ama.repositories.AMARepository;
import ama.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by robertfernandes on 2/7/2017.ss
 */
@SpringBootApplication
public class AMAApplication {

    @Autowired
    private AMARepository amaRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AMAApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            User a = new User("Ahmad");
            AMA ama = new AMA(a, "hi");
            userRepository.save(a);
            amaRepository.save(ama);
        };
    }
}
