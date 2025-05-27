/**
 * Policy class represents an insurance policy for one person
 */
public class Policy {
    // Attributes
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height; // in inches
    private double weight; // in pounds
    
    // No-arg constructor with default values
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
    }
    
    // Constructor that accepts all arguments
    public Policy(int policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }
    
    // Setter methods (mutators)
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }
    
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }
    
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
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
    
    // Getter methods (accessors)
    public int getPolicyNumber() {
        return policyNumber;
    }
    
    public String getProviderName() {
        return providerName;
    }
    
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }
    
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }
    
    public int getPolicyholderAge() {
        return policyholderAge;
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
    
    // Method to calculate BMI
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
    
    // Method to calculate policy price
    public double calculatePolicyPrice() {
        double basePrice = 600.0;
        double additionalFees = 0.0;
        
        // Age fee (over 50)
        if (policyholderAge > 50) {
            additionalFees += 75.0;
        }
        
        // Smoking fee
        if (smokingStatus.equals("smoker")) {
            additionalFees += 100.0;
        }
        
        // BMI fee (over 35)
        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFees += (bmi - 35) * 20;
        }
        
        return basePrice + additionalFees;
    }
}