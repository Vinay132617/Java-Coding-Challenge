package com.hexaware.ims.presentation;

import java.util.Collection;
import java.util.Scanner;

import com.hexaware.ims.dao.IPolicyDAO;
import com.hexaware.ims.dao.PolicyDAOImpl; // Assuming this is your DAO implementation
import com.hexaware.ims.service.IPolicyService;
import com.hexaware.ims.service.PolicyServiceImpl;
import com.hexaware.ims.entity.Policy;
import myexceptions.PolicyNotFoundException;

public class InsuranceApp {

    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {

        IPolicyDAO policyDAO = new PolicyDAOImpl(); 

        IPolicyService insurance = new PolicyServiceImpl(policyDAO);
        
        System.out.println("Insurance Management System");
        while (true) {
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy");
            System.out.println("3. Get All Policies");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        createPolicy(insurance);
                        break;
                    case 2:
                        getPolicy(insurance);
                        break;
                    case 3:
                        getAllPolicies(insurance);
                        break;
                    case 4:
                        updatePolicy(insurance);
                        break;
                    case 5:
                        deletePolicy(insurance);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (PolicyNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private static void deletePolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.print("Enter Policy ID to delete: ");
        int policyIdToDelete = scanner.nextInt();
        
        if (insurance.deletePolicy(policyIdToDelete)) {
            System.out.println("Policy deleted successfully!");
        } else {
            System.out.println("Policy with ID " + policyIdToDelete + " not found.");
        }
    }

    private static void updatePolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.print("Enter Policy ID to update: ");
        int policyIdToUpdate = scanner.nextInt();
        
        Policy policyToUpdate = insurance.getPolicy(policyIdToUpdate);
        if (policyToUpdate != null) {
            System.out.print("Enter updated Policy Name: ");
            scanner.nextLine(); // Clear the buffer
            String updatedPolicyName = scanner.nextLine();
            policyToUpdate.setPolicyName(updatedPolicyName);
            
            System.out.print("Enter updated Policy Type: ");
            String updatedPolicyType = scanner.nextLine();
            policyToUpdate.setPolicyType(updatedPolicyType);
            
            System.out.print("Enter updated Coverage Amount: ");
            double updatedCoverageAmount = scanner.nextDouble();
            policyToUpdate.setCoverageAmount(updatedCoverageAmount);

            if (insurance.updatePolicy(policyToUpdate)) {
                System.out.println("Policy updated successfully!");
            } else {
                System.out.println("Policy update failed!");
            }
        } else {
            throw new PolicyNotFoundException("Policy with ID " + policyIdToUpdate + " not found.");
        }
    }

    private static void getAllPolicies(IPolicyService insurance) throws PolicyNotFoundException {
        Collection<Policy> allPolicies = insurance.getAllPolicies();
        
        if (allPolicies != null && !allPolicies.isEmpty()) {
            System.out.println("All Policies are:");
            for (Policy policy : allPolicies) {
                System.out.println(policy);
            }
        } else {
            System.out.println("No policies found.");
        }
    }

    private static void getPolicy(IPolicyService insurance) throws PolicyNotFoundException {
        System.out.print("Enter Policy ID to retrieve: ");
        int policyIdToRetrieve = scanner.nextInt();
        
        Policy retrievedPolicy = insurance.getPolicy(policyIdToRetrieve);
        System.out.println("Retrieved Policy: " + retrievedPolicy);
    }

    private static void createPolicy(IPolicyService insurance) {
        System.out.print("Enter Policy ID: ");
        int policyId = scanner.nextInt();
        
        System.out.print("Enter Policy Name: ");
        scanner.nextLine(); // Clear the buffer
        String policyName = scanner.nextLine();
        
        System.out.print("Enter Policy Type: ");
        String policyType = scanner.nextLine();
        
        System.out.print("Enter Coverage Amount: ");
        double coverageAmount = scanner.nextDouble();

        Policy newPolicy = new Policy(policyId, policyName, policyType, coverageAmount);

        if (insurance.createPolicy(newPolicy)) {
            System.out.println("Policy created successfully!");
        } else {
            System.out.println("Policy creation failed!");
        }
    }
}
