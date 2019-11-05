package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import domain.Actor;



@Repository
public interface RegistrationRepository extends CrudRepository<Actor, Integer>{

}
