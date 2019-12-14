package tr.com.otunctan.repository.spec;

import java.util.List;

import tr.com.otunctan.dto.DepartmentPersonDto;
import tr.com.otunctan.dto.PersonDto;
import tr.com.otunctan.model.Person;

public interface CustomizedPersonRepository {

	public List<Person> findPersonByPredicate(PersonDto personDto);

	public List<DepartmentPersonDto> getInDepartmentMaxSalaryPerson();

}
