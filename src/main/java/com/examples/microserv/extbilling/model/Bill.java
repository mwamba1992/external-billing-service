package com.examples.microserv.extbilling.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {

	@Id
	private String  id;

	private String billControlNumber;

	private BigDecimal billAmount;

	private Date ReceiveDate;

	private Date expirationDate;

	private String serviceId;

	private Long CurrencyId;

	private String customerEmail;

	public Bill() {
		super();

	}

	public Bill(String id, String billControlNumber, BigDecimal billAmount, Date receiveDate, Date expirationDate,
			String serviceId, Long currencyId, String customerEmail) {
		super();
		this.id = id;
		this.billControlNumber = billControlNumber;
		this.billAmount = billAmount;
		ReceiveDate = receiveDate;
		this.expirationDate = expirationDate;
		this.serviceId = serviceId;
		CurrencyId = currencyId;
		this.customerEmail = customerEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Long getCurrencyId() {
		return CurrencyId;
	}

	public void setCurrencyId(Long currencyId) {
		CurrencyId = currencyId;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billControlNumber=" + billControlNumber + ", billAmount=" + billAmount
				+ ", ReceiveDate=" + ReceiveDate + ", expirationDate=" + expirationDate + ", serviceId=" + serviceId
				+ ", CurrencyId=" + CurrencyId + ", customerEmail=" + customerEmail + "]";
	}

	
}
