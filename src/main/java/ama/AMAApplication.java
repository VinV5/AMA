package ama;

import ama.model.AMA;
import ama.model.Answer;
import ama.model.Question;
import ama.model.User;
import ama.repositories.AMARepository;
import ama.repositories.UserRepository;
import org.hibernate.Hibernate;
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
            AMA ama = new AMA( "hi");
            Question q = new Question("hello", ama);
            Answer a = new Answer("bye", q);
            q.addAnswer(a);
            ama.addQuestion(q);
            amaRepository.save(ama);
        };
    }


}
