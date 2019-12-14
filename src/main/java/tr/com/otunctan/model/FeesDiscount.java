package tr.com.otunctan.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
public class FeesDiscount {

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.IDENTITY)
	private Integer id;

	private String currency;

	private Double price;

	private Double discount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "wts_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FeesDiscount_WtsTransaction_FK"))
	private WtsTransaction wtsTransaction;

	public FeesDiscount() {
		this.id = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * @return the wtsTransaction
	 */
	// public WtsTransaction getWtsTransaction() {
	// return wtsTransaction;
	// }

	/**
	 * @param wtsTransaction the wtsTransaction to set
	 */
	public void wtsTransaction(WtsTransaction wtsTransaction) {
		this.wtsTransaction = wtsTransaction;
	}

}
