package com.hexaware.ims.entity;

public class Policy {
	
    private int policyID;
    private String policyName;
    private String policyType;
    private double coverageAmount;
    
	public Policy(int policyID, String policyName, String policyType, double coverageAmount) {
		super();
		this.policyID = policyID;
		this.policyName = policyName;
		this.policyType = policyType;
		this.coverageAmount = coverageAmount;
	}

	public int getPolicyID() {
		return policyID;
	}

	public void setPolicyID(int policyID) {
		this.policyID = policyID;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	@Override
	public String toString() {
		return "Policy [policyID=" + policyID + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", coverageAmount=" + coverageAmount + "]";
	}
    
	
    
}
