package com.examples.microserv.extbilling.dto;

import org.springframework.stereotype.Component;

@Component
public class BillCheckRequest {
	String billCheckId;
	
	String controlNumber;
	
	String spCode;

	public String getBillCheckId() {
		return billCheckId;
	}

	public void setBillCheckId(String billCheckId) {
		this.billCheckId = billCheckId;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}
	
	
	
}
