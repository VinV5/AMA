package ama;

import ama.model.AMA;
import ama.model.Category;
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
            AMA ama = new AMA( "I am the Monkey Man, I like causing monkey trouble. AMA");
            ama.setCategory(Category.Monkey_Business);

            AMA ama2 = new AMA( "Hey, it's me Pandora, Harbinger of doom and all AMA");
            ama2.setCategory(Category.Awesome);
            ama2.setVotes(2);
            amaRepository.save(ama);
            amaRepository.save(ama2);
        };
    }


}
