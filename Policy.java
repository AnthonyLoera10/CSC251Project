/**
 * Policy class represents an insurance policy for one person
 * @author Anthony Loera
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
    
    /**
     * No-arg constructor with default values
     */
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
    
    /**
     * Constructor that accepts all arguments
     * @param policyNumber the policy number
     * @param providerName the insurance provider name
     * @param policyholderFirstName the policyholder's first name
     * @param policyholderLastName the policyholder's last name
     * @param policyholderAge the policyholder's age
     * @param smokingStatus the policyholder's smoking status
     * @param height the policyholder's height in inches
     * @param weight the policyholder's weight in pounds
     */
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
    
    /**
     * Sets the policy number
     * @param policyNumber the policy number to set
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    /**
     * Sets the provider name
     * @param providerName the provider name to set
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    /**
     * Sets the policyholder's first name
     * @param policyholderFirstName the first name to set
     */
    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }
    
    /**
     * Sets the policyholder's last name
     * @param policyholderLastName the last name to set
     */
    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }
    
    /**
     * Sets the policyholder's age
     * @param policyholderAge the age to set
     */
    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }
    
    /**
     * Sets the smoking status
     * @param smokingStatus the smoking status to set
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    
    /**
     * Sets the height
     * @param height the height in inches to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Sets the weight
     * @param weight the weight in pounds to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    /**
     * Gets the policy number
     * @return the policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }
    
    /**
     * Gets the provider name
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }
    
    /**
     * Gets the policyholder's first name
     * @return the first name
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }
    
    /**
     * Gets the policyholder's last name
     * @return the last name
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }
    
    /**
     * Gets the policyholder's age
     * @return the age
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }
    
    /**
     * Gets the smoking status
     * @return the smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }
    
    /**
     * Gets the height
     * @return the height in inches
     */
    public double getHeight() {
        return height;
    }
    
    /**
     * Gets the weight
     * @return the weight in pounds
     */
    public double getWeight() {
        return weight;
    }
    
    /**
     * Calculates the BMI (Body Mass Index)
     * @return the BMI value
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
    
    /**
     * Calculates the policy price based on age, smoking status, and BMI
     * @return the total policy price
     */
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