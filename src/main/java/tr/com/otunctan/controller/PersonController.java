package tr.com.otunctan.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.com.otunctan.dto.DepartmentPersonDto;
import tr.com.otunctan.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	PersonRepository personRepository;

	@RequestMapping(path = "/getAllPersons")
	public ResponseEntity<List<DepartmentPersonDto>> getAllPersonByPredicate() {

		
		ModelMapper mapper = new ModelMapper();

		

		return ResponseEntity.status(HttpStatus.OK).body(personRepository.getInDepartmentMaxSalaryPerson());

	}

}
