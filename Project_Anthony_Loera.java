import java.util.Scanner;

/**
 * Demo class to demonstrate the Policy class functionality
 */
public class Project_Anthony_Loera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Please enter the Policy Number: ");
        int policyNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Please enter the Provider Name: ");
        String providerName = scanner.nextLine();
        
        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = scanner.nextLine();
        
        System.out.print("Please enter the Policyholder's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();
        
        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = scanner.nextDouble();
        
        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = scanner.nextDouble();
        
        // Create Policy object using constructor with arguments
        Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                   age, smokingStatus, height, weight);
        
        // Display policy information
        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
        System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
        System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
        
        scanner.close();
    }
}