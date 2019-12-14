package tr.com.otunctan.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class WtsTransaction {

	@Id
	@GeneratedValue(generator = "idGenerator", strategy = GenerationType.IDENTITY)
	private Integer id;

	private String payNo;

	private Double amount;

	private Integer paymenth;

	@OneToMany(mappedBy = "wtsTransaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = FeesDiscount.class)
	private List<FeesDiscount> feesDiscount = new ArrayList<>();

	public WtsTransaction() {
		this.id = 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getPaymenth() {
		return paymenth;
	}

	public void setPaymenth(Integer paymenth) {
		this.paymenth = paymenth;
	}

	public List<FeesDiscount> getFeesDiscount() {
		return feesDiscount;
	}

	public void addFeesDiscount(FeesDiscount feesDiscount) {
		feesDiscount.wtsTransaction(this);
		this.feesDiscount.add(feesDiscount);
	}

}
