package com.examples.microserv.extbilling.jpa;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.examples.microserv.extbilling.model.Bill;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SearchBillRepositoryTest {

	@Autowired
	TestEntityManager entityMgr;
	
	@MockBean
	RestTemplate restTemplate;
	

	@Test
	public void testFetchBill() {
		Bill bill = new Bill();
		bill.setBillAmount(new BigDecimal(1000));
		bill.setId("TIC1212");
		bill.setBillControlNumber("991221212121");
		bill.setCustomerEmail("simba@joel.com");
		bill.setServiceId("12");
		bill.setExpirationDate(new Date());
		bill.setReceiveDate(new Date());

		entityMgr.persist(bill);

		Bill found = entityMgr.find(Bill.class, bill.getId());

		assertEquals(bill.getId(), found.getId());

	}

}
