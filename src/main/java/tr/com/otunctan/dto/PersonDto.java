package tr.com.otunctan.dto;

import java.util.Date;
import java.util.List;

import tr.com.otunctan.model.Department;

public class PersonDto {

	private Integer id;

	private String name;

	private boolean active = false;

	private Date createdDate;
	
	private List<PhoneDto> phones;
	
	private Department department;
	

	public PersonDto() {
		super();
	}

	
	

	public PersonDto(Integer id, String name, boolean active, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
		this.createdDate = createdDate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}




	public List<PhoneDto> getPhones() {
		return phones;
	}




	public void setPhones(List<PhoneDto> phones) {
		this.phones = phones;
	}




	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}




	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}


}
