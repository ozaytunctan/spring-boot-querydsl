package tr.com.otunctan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.querydsl.core.annotations.QueryEntity;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;

	private String lastName;

	private boolean active = false;

	private Date createdDate;

	private Double salary;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person", targetEntity = Phone.class)
	private List<Phone> phones = new ArrayList<Phone>();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Department.class)
	@JoinColumn(name = "department_id", referencedColumnName = "id",
	foreignKey = @ForeignKey(foreignKeyDefinition = "id",name="PERSON_DEPARTMENT_FK"))
	private Department department;

	public Person() {
		setId(0);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String name) {
		this.firstName = name;
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

	public void addPhone(Phone phone) {
		phone.addPerson(this);
		this.phones.add(phone);
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {

		this.phones = phones;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void department(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return this.department;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
