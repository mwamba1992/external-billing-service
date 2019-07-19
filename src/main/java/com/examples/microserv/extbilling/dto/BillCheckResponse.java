package com.examples.microserv.extbilling.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BillCheckResponse {

	private String billId;

	private String billControlNumber;

	private BigDecimal billAmount;

	private Date ReceiveDate;

	private Date expirationDate;

	private String serviceId;

	private String CurrencyCode;

	private String customerEmail;
	
	private String stsCode;

	public String getbillId() {
		return billId;
	}

	public void setbillId(String id) {
		this.billId = id;
	}

	public String getBillControlNumber() {
		return billControlNumber;
	}

	public void setBillControlNumber(String billControlNumber) {
		this.billControlNumber = billControlNumber;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public Date getReceiveDate() {
		return ReceiveDate;
	}

	public void setReceiveDate(Date receiveDate) {
		ReceiveDate = receiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getCurrencyId() {
		return CurrencyCode;
	}

	public void setCurrencyId(String currencyId) {
		CurrencyCode = currencyId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getStsCode() {
		return stsCode;
	}

	public void setStsCode(String stsCode) {
		this.stsCode = stsCode;
	}
	
	
	
	
	
}
