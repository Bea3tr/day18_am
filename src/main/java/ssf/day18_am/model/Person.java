package ssf.day18_am.model;

import jakarta.validation.constraints.*;

public class Person {

    private String id;

    @NotNull(message="Name cannot be null")
    @NotEmpty(message="Name cannot be empty")
    @Size(min=5, max=150, message="Name must be between 5 and 150 characters")
    private String fullName;

    // required and must be in email format
    @Email
    @NotNull(message="Email cannot be null")
    @NotEmpty(message="Email cannot be empty")
    private String email;

    // between 111111 and 888888
    @Size(min=6, max=6)
    @Pattern(regexp = "[1-8]+", message="Postal code must be between 111111 and 888888")
    private String postalCode;

    // 7 digits number only - use regular expression
    @Pattern(regexp = "\\d+")
    @Size(min=7, max=7)
    private String phoneNumber;

    public Person() {}
    public Person(String id,
            @NotNull(message = "Name cannot be null") @NotEmpty(message = "Name cannot be empty") @Size(min = 5, max = 150, message = "Name must be between 5 and 150 characters") String fullName,
            @Email @NotNull(message = "Email cannot be null") @NotEmpty(message = "Email cannot be empty") String email,
            @Size(min = 6, max = 6) @Pattern(regexp = "[1-8]", message = "Postal code must be between 111111 and 888888") String postalCode,
            @Pattern(regexp = "[\\d+]") @Size(min = 7, max = 7) String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPostalCode() {return postalCode;}
    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id + "," + 
                "\"fullName\": " + fullName + "," + 
                "\"email\": " + email + "," + 
                "\"postalCode\": " + postalCode + "," + 
                "\"phoneNumber\": " + phoneNumber +
                "}";
    }
    
}
