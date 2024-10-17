package com.hexaware.ims.dao;

import java.util.Collection;

import com.hexaware.ims.entity.Policy;

import myexceptions.PolicyNotFoundException;

public interface IPolicyDAO {
	
	    boolean createPolicy(Policy policy);
	    Policy getPolicy(int policyID) throws PolicyNotFoundException;
	    Collection<Policy> getAllPolicies() throws PolicyNotFoundException;
	    boolean updatePolicy(Policy policy) throws PolicyNotFoundException;
	    boolean deletePolicy(int policyID) throws PolicyNotFoundException;
	

}
