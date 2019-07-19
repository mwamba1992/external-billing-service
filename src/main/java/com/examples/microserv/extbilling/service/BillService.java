package com.examples.microserv.extbilling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examples.microserv.extbilling.model.Bill;
import com.examples.microserv.extbilling.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	BillRepository billRepository;

	public Bill getBill(String ctrNum) {
		return billRepository.findBybillControlNumber(ctrNum);

	}

	public Bill createBill(Bill bill) {
		return billRepository.save(bill);

	}

}
