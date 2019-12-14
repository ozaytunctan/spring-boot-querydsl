package tr.com.otunctan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import tr.com.otunctan.model.WtsTransaction;
import tr.com.otunctan.repository.spec.CustomizedWtsTransactionRepository;


@Repository
public interface WtsTransactionRepository extends JpaRepository<WtsTransaction, Integer>,
		QuerydslPredicateExecutor<WtsTransaction>, CustomizedWtsTransactionRepository {

}
