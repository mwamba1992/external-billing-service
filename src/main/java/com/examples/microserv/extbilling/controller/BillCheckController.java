package com.examples.microserv.extbilling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.examples.microserv.extbilling.dto.BillCheckRequest;
import com.examples.microserv.extbilling.dto.BillCheckResponse;
import com.examples.microserv.extbilling.dto.Currency;
import com.examples.microserv.extbilling.model.Bill;
import com.examples.microserv.extbilling.service.BillService;

@RestController
@RequestMapping("/extbills")
public class BillCheckController {

	@Autowired
	BillCheckResponse checkResponse;

	@Autowired
	BillService billservice;

	@Autowired
	RestTemplate restTemp;

	@Value("currency.get.url")
	String getCurrencyUrl;

	Logger log = LoggerFactory.getLogger(BillCheckController.class);

	@PostMapping(value = "/search", consumes = "application/json", produces = "application/json")
	public BillCheckResponse getBill(@RequestBody BillCheckRequest checkRequest) {

		log.info("****Incomoming Request***: {} " + checkRequest.toString());

		if (billservice.getBill(checkRequest.getControlNumber()) != null) {
			Bill bill = billservice.getBill(checkRequest.getControlNumber());

			checkResponse.setbillId(checkRequest.getBillCheckId());
			checkResponse.setBillAmount(bill.getBillAmount());
			checkResponse.setBillControlNumber(bill.getBillControlNumber());
			checkResponse.setCurrencyId("TZS");
			checkResponse.setCustomerEmail(bill.getCustomerEmail());
			checkResponse.setExpirationDate(bill.getExpirationDate());
			checkResponse.setReceiveDate(bill.getReceiveDate());
			checkResponse.setStsCode("777");
			checkResponse.setServiceId(bill.getServiceId());

		} else {
			checkResponse.setStsCode("666");
		}

		log.info("****Outgoing Response***: {} " + checkResponse.toString());
		return checkResponse;

	}

	public String getCurrency(String ccyId) {
		try {

			ResponseEntity<Currency> response = restTemp.getForEntity(getCurrencyUrl + "/" + ccyId, Currency.class);
			Currency currency = response.getBody();

			return currency.getShortName();

		} catch (Exception e) {
			e.printStackTrace();
			return "NONE";
		}

	}

}
