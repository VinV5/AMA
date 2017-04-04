package ama.repositories;

import ama.model.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long>{
    Question findById(Long id);
    List<Question> findByAma(AMA ama);
}
