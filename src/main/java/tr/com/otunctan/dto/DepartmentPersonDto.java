package tr.com.otunctan.dto;

public class DepartmentPersonDto {
	
	private Integer personId;
	
	private String personName;
	
	private String personLastName;
	
	private Double salary;
	
	
	private String departmentName;
	
	private String phoneNumber;
	
	public DepartmentPersonDto() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentPersonDto(Integer personId, String personName, String personLastName, Double salary,
			String departmentName) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personLastName = personLastName;
		this.salary = salary;
		this.departmentName = departmentName;
	}
	
	public DepartmentPersonDto(Integer personId, String personName, String personLastName,String phoneNumber, Double salary) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personLastName = personLastName;
		this.salary = salary;
		this.setPhoneNumber(phoneNumber);
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonLastName() {
		return personLastName;
	}

	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	
	

}
