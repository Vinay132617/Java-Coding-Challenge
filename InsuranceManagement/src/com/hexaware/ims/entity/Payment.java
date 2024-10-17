package com.hexaware.ims.entity;

import java.util.Date;

public class Payment {
    private int paymentID;
    private Date paymentDate;
    private double paymentAmount;
    private Client client;
	public Payment(int paymentID, Date paymentDate, double paymentAmount, Client client) {
		super();
		this.paymentID = paymentID;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
		this.client = client;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount
				+ ", client=" + client + "]";
	}
    
    
}
