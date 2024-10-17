package com.hexaware.ims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.hexaware.ims.entity.Policy;

import myexceptions.PolicyNotFoundException;
import util.DBConnection;

public class PolicyDAOImpl implements IPolicyDAO {
	
	
	private Connection connection;
	
	public PolicyDAOImpl() {
		super();
		connection = DBConnection.getDBConnection();
	}


    @Override
    public boolean createPolicy(Policy policy) {
        String query = "INSERT INTO Policy (policyId, policyName, policyType,coverageAmount) VALUES (?, ?, ?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,policy.getPolicyID());
            preparedStatement.setString(2, policy.getPolicyName());
            preparedStatement.setString(3, policy.getPolicyType());
            preparedStatement.setDouble(4, policy.getCoverageAmount());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
            return false;
        }

    }

    @Override
    public Policy getPolicy(int policyId) throws PolicyNotFoundException {
        String query = "SELECT * FROM Policy WHERE policyId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, policyId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int policy_id = resultSet.getInt("policyId");
                String policyName = resultSet.getString("policyName");
                String policyType = resultSet.getString("policyType");
                double coverageAmount = resultSet.getDouble("coverageAmount");
                Policy policy = new Policy(policy_id,policyName,policyType,coverageAmount);
                return policy;
            }
            else{
                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while retrieving policy with ID " + policyId);
        }
    }

    @Override
    public Collection<Policy> getAllPolicies() throws PolicyNotFoundException {
        List<Policy> policies = new ArrayList<>();
        String query = "SELECT * FROM Policy";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                int policy_id = resultSet.getInt("policyId");
                String policyName = resultSet.getString("policyName");
                String policyType = resultSet.getString("policyType");
                double coverageAmount = resultSet.getDouble("coverageAmount");
                Policy policy = new Policy(policy_id,policyName,policyType,coverageAmount);
                policies.add(policy);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while retrieving all policies");
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        String query = "UPDATE Policy SET policyName = ?, policyType = ?, coverageAmount = ? WHERE policyId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, policy.getPolicyName());
            preparedStatement.setString(2, policy.getPolicyType());
            preparedStatement.setDouble(3, policy.getCoverageAmount());
            preparedStatement.setInt(4, policy.getPolicyID());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) throws PolicyNotFoundException {
        String query = "DELETE FROM Policy WHERE policyId = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1,policyId);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } else {
                throw new PolicyNotFoundException("Policy with ID " + policyId + " not found.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new PolicyNotFoundException("Error while deleting policy with ID " + policyId);
        }
    }
}
