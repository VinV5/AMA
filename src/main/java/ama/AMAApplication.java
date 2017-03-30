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
            //User a = new User("Ahmad");
            AMA ama = new AMA( "hi");
            Hibernate.initialize(ama.questionList);
            Question q = new Question("hello");
            Answer a = new Answer("bye");
            Hibernate.initialize(q.answerList);
            q.addAnswer(a);
            ama.addQuestion(q);

            //userRepository.save(a);
            amaRepository.save(ama);
        };
    }


}
