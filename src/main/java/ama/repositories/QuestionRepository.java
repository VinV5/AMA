package ama.repositories;

import ama.model.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long>{
    Question findById(Long id);
}
