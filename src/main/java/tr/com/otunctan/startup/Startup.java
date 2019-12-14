package tr.com.otunctan.startup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tr.com.otunctan.model.Department;
import tr.com.otunctan.model.FeesDiscount;
import tr.com.otunctan.model.Person;
import tr.com.otunctan.model.Phone;
import tr.com.otunctan.model.WtsTransaction;
import tr.com.otunctan.repository.PersonRepository;
import tr.com.otunctan.repository.WtsTransactionRepository;

@Component
public class Startup implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private WtsTransactionRepository wtsTransactionRepository;

	@Override
	public void run(String... args) throws Exception {

		Department department = new Department("Yazılım", "001");
		Person p1 = new Person();
		p1.setSalary(200D);
		p1.setName("Ahmet");
		p1.department(department);
		p1.setActive(true);
		p1.addPhone(new Phone("8671747", "539", "056"));

		p1 = personRepository.save(p1);

		Person p2 = new Person();
		p2.setName("yağmur");
		p2.setActive(true);
		p2.setSalary(1500D);
		p2.department(p1.getDepartment());
		p2.addPhone(new Phone("0110467", "538", "102"));
		p2.addPhone(new Phone("0110469", "538", "102"));

		Person p3 = new Person();
		p3.setName("Ali");
		p3.setActive(true);
		p3.setSalary(9000D);
		p3.department(new Department("IK", "002"));
		p3.addPhone(new Phone("0110563", "538", "102"));
		p3.addPhone(new Phone("0110568", "538", "103"));

		personRepository.saveAll(Arrays.asList(p2, p3));

		insertAll();

	}

	public void insertAll() {

		FeesDiscount feesDiscount = new FeesDiscount();
		feesDiscount.setCurrency("TL");
		feesDiscount.setDiscount(1.0);
		feesDiscount.setPrice(10.0);

		FeesDiscount feesDiscount2 = new FeesDiscount();
		feesDiscount2.setCurrency("TL");
		feesDiscount2.setDiscount(1.0);
		feesDiscount2.setPrice(70.0);

		FeesDiscount feesDiscount3 = new FeesDiscount();
		feesDiscount3.setCurrency("TL");
		feesDiscount3.setDiscount(1.0);
		feesDiscount3.setPrice(100.0);

		WtsTransaction wtsTransaction = new WtsTransaction();
		wtsTransaction.setAmount(5.0);
		wtsTransaction.setPaymenth(5);
		wtsTransaction.setPayNo("wts01");
		wtsTransaction.addFeesDiscount(feesDiscount);

		WtsTransaction wtsTransaction2 = new WtsTransaction();
		wtsTransaction2.setAmount(5.0);
		wtsTransaction2.setPaymenth(5);
		wtsTransaction2.setPayNo("wts01");
		wtsTransaction2.addFeesDiscount(feesDiscount2);

		WtsTransaction wtsTransaction3 = new WtsTransaction();
		wtsTransaction3.setAmount(5.0);
		wtsTransaction3.setPaymenth(6);
		wtsTransaction3.setPayNo("wts01");
		wtsTransaction3.addFeesDiscount(feesDiscount3);

		wtsTransactionRepository.saveAll(Arrays.asList(wtsTransaction, wtsTransaction2, wtsTransaction3));

	}

}
