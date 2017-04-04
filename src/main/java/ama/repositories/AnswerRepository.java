package ama.repositories;

import ama.model.Answer;
import org.springframework.data.repository.CrudRepository;

public interface AnswerRepository extends CrudRepository<Answer, Long>{
    Answer findById(Long id);
}
