package tr.com.otunctan.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQuery;

import tr.com.otunctan.dto.SearchWtsTransactionDto;
import tr.com.otunctan.model.QFeesDiscount;
import tr.com.otunctan.model.QWtsTransaction;
import tr.com.otunctan.repository.spec.CustomizedWtsTransactionRepository;

public class WtsTransactionRepositoryImpl implements CustomizedWtsTransactionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SearchWtsTransactionDto> getTt() {

		QWtsTransaction wtsTransaction = QWtsTransaction.wtsTransaction;
		QFeesDiscount feesDiscount = QFeesDiscount.feesDiscount;

		JPAQuery<?> query = new JPAQuery<>(entityManager);

		Map<String, Double> dd = query.select().from(wtsTransaction)
				.innerJoin(wtsTransaction.feesDiscount, feesDiscount).where(wtsTransaction.payNo.isNotNull())
				.transform(GroupBy.groupBy(wtsTransaction.payNo).as(GroupBy.max(wtsTransaction.amount)));

		return null;
	}

}
