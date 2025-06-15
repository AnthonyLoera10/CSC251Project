import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Demo class to demonstrate the Policy class functionality
 * Reads policy information from a file and displays all policies
 * @author Anthony Loera
 */
public class Project_Anthony_Loera {
    public static void main(String[] args) {
        // ArrayList to store Policy objects
        ArrayList<Policy> policies = new ArrayList<Policy>();
        
        try {
            // Create Scanner to read from file
            File file = new File("PolicyInformation.txt");
            Scanner fileScanner = new Scanner(file);
            
            // Read policy information from file
            while (fileScanner.hasNextLine()) {
                // Read all 8 pieces of information for each policy
                String policyNumberStr = fileScanner.nextLine().trim();
                
                // Skip empty lines
                if (policyNumberStr.isEmpty()) {
                    continue;
                }
                
                try {
                    int policyNumber = Integer.parseInt(policyNumberStr);
                    String providerName = fileScanner.nextLine().trim();
                    String firstName = fileScanner.nextLine().trim();
                    String lastName = fileScanner.nextLine().trim();
                    int age = Integer.parseInt(fileScanner.nextLine().trim());
                    String smokingStatus = fileScanner.nextLine().trim();
                    double height = Double.parseDouble(fileScanner.nextLine().trim());
                    double weight = Double.parseDouble(fileScanner.nextLine().trim());
                    
                    // Create Policy object and add to ArrayList
                    Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                             age, smokingStatus, height, weight);
                    policies.add(policy);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing number in file. Skipping this policy.");
                    continue;
                }
            }
            
            fileScanner.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found: PolicyInformation.txt");
            System.out.println("Please make sure the file is in the correct location.");
            return;
        }
        
        // Display information for each policy
        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
            System.out.println(); // Empty line between policies
        }
        
        // Count and display number of smokers and non-smokers
        int smokerCount = 0;
        int nonSmokerCount = 0;
        
        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equals("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }
        
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}