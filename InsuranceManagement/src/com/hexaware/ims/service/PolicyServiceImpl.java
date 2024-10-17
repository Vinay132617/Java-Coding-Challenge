package com.hexaware.ims.service;

import com.hexaware.ims.dao.IPolicyDAO;
import com.hexaware.ims.dao.PolicyDAOImpl;
import com.hexaware.ims.entity.Policy;
import myexceptions.PolicyNotFoundException;

import java.util.Collection;

public class PolicyServiceImpl implements IPolicyService {
    private final IPolicyDAO policyDAO;

    // Constructor Injection of DAO
    public PolicyServiceImpl(IPolicyDAO policyDAO) {
        this.policyDAO = policyDAO;
    }

    @Override
    public boolean createPolicy(Policy policy) {
        return policyDAO.createPolicy(policy);
    }

    @Override
    public Policy getPolicy(int policyID) throws PolicyNotFoundException {
        return policyDAO.getPolicy(policyID);
    }

    @Override
    public Collection<Policy> getAllPolicies() throws PolicyNotFoundException {
        return policyDAO.getAllPolicies();
    }

    @Override
    public boolean updatePolicy(Policy policy) throws PolicyNotFoundException {
        return policyDAO.updatePolicy(policy);
    }

    @Override
    public boolean deletePolicy(int policyID) throws PolicyNotFoundException {
        return policyDAO.deletePolicy(policyID);
    }
}
