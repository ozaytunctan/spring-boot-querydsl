package tr.com.otunctan.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.IDENTITY)
	private Integer id;

	@Length(max = 7, min = 7)
	private String number;

	@Length(max = 3, min = 3)
	private String code;

	private String countryCode;

	private Date createdDate = new Date();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "personId", foreignKey = @ForeignKey(foreignKeyDefinition = "id", name = "PHONE_PERSON_ID_FK"), referencedColumnName = "id")
	private Person person;

	public Phone(@Length(max = 7, min = 7) String number, @Length(max = 3, min = 3) String code, String countryCode) {
		super();
		this.id = 0;
		this.number = number;
		this.code = code;
		this.countryCode = countryCode;
	}

	public Phone() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void addPerson(Person person) {
		this.person = person;
	}

}
