package tr.com.otunctan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import tr.com.otunctan.model.Person;
import tr.com.otunctan.repository.spec.CustomizedPersonRepository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> 
                               ,QuerydslPredicateExecutor<Person>,
                               CustomizedPersonRepository{

}
