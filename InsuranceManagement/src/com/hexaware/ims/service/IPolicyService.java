package com.hexaware.ims.service;

import com.hexaware.ims.entity.Policy;
import myexceptions.PolicyNotFoundException;

import java.util.Collection;

	public interface IPolicyService {
		
	    boolean createPolicy(Policy policy);
	    
	    Policy getPolicy(int policyID) throws PolicyNotFoundException;
	    
	    Collection<Policy> getAllPolicies() throws PolicyNotFoundException;
	    
	    boolean updatePolicy(Policy policy) throws PolicyNotFoundException;
	    
	    boolean deletePolicy(int policyID) throws PolicyNotFoundException;
	}

