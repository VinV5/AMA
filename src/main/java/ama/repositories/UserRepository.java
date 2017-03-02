package ama.repositories;

import ama.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    public String findByName(String name);
}
