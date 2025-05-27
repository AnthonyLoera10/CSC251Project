import java.util.Scanner;

/**
 * Policy class represents an insurance policy for one person
 */
class Policy {
    // Private fields for policy attributes
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds
    
    /**
     * No-argument constructor with default values
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }
    
    /**
     * Constructor that accepts all arguments
     */
    public Policy(String policyNumber, String providerName, String firstName, 
                  String lastName, int age, String smokingStatus, 
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }
    
    // Getter methods (accessors)
    public String getPolicyNumber() {
        return policyNumber;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getSmokingStatus() {
        return smokingStatus;
    }
    
    public double getHeight() {
        return height;
    }
    
    public double getWeight() {
        return weight;
    }
    
    // Setter methods (mutators)
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * Calculates and returns the BMI of the policyholder
     * BMI = (Policyholder's Weight * 703) / (Policyholder's Height^2)
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
    
    /**
     * Calculates and returns the price of the insurance policy
     * Base fee: $600
     * Additional fees:
     * - Over 50 years old: +$75
     * - Smoker: +$100
     * - BMI over 35: +(BMI - 35) * 20
     */
    public double calculatePolicyPrice() {
        double basePrice = 600.0;
        double additionalFees = 0.0;
        
        // Age fee
        if (age > 50) {
            additionalFees += 75.0;
        }
        
        // Smoking fee
        if (smokingStatus.equals("smoker")) {
            additionalFees += 100.0;
        }
        
        // BMI fee
        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFees += (bmi - 35) * 20;
        }
        
        return basePrice + additionalFees;
    }
}

/**
 * Demo class to demonstrate the Policy class functionality
 */
public class Project_Anthony_Loera {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Please enter the Policy Number: ");
        String policyNumber = scanner.nextLine();
        
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
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
        System.out.printf("Policyholder's BMI: %.2f%n", policy.calculateBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.calculatePolicyPrice());
        
        scanner.close();
    }
}