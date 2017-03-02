package ama.repositories;

import ama.model.AMA;
import org.springframework.data.repository.CrudRepository;

public interface AMARepository  extends CrudRepository<AMA, Long>{
    AMA findById(Long id);

}
