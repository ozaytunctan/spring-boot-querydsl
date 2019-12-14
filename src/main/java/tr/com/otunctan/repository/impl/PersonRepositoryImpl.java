package tr.com.otunctan.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import tr.com.otunctan.dto.DepartmentPersonDto;
import tr.com.otunctan.dto.PersonDto;
import tr.com.otunctan.model.Person;
import tr.com.otunctan.model.QDepartment;
import tr.com.otunctan.model.QPerson;
import tr.com.otunctan.model.QPhone;
import tr.com.otunctan.repository.spec.CustomizedPersonRepository;

@MappedSuperclass
public class PersonRepositoryImpl implements CustomizedPersonRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Person> findPersonByPredicate(PersonDto personDto) {
		QPerson person = QPerson.person;
		QPhone phone = QPhone.phone;
		JPAQuery<Person> query = new JPAQuery<>(entityManager);
		List<Person> personList = query.from(person).where(person.active.eq(true))
				.groupBy(person.firstName, person.salary).orderBy(person.salary.desc()).fetch();

		return personList;
	}

	@Override
	public List<DepartmentPersonDto> getInDepartmentMaxSalaryPerson() {

		QPerson person = QPerson.person;
		QDepartment department = QDepartment.department;
		QPhone phone = QPhone.phone;
		JPAQuery<Person> query = new JPAQuery<>(entityManager);

		List<DepartmentPersonDto> personList = query
				.select(Projections.constructor(DepartmentPersonDto.class, person.id, person.firstName, person.lastName,
						phone.code.concat(phone.number), person.salary))
				.from(person).innerJoin(person.phones, phone).where(person.active.isTrue()).fetch();

		return personList;
	}

}
