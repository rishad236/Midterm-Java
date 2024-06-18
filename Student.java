package mid.app.midterm;

import java.util.Arrays;
import java.util.List;

public class Student {
    private int studentNumber;
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String address;
    private String province;
    private double averageGrade;
    private String major;

    // List of valid provinces abbreviations in Canada
    private static final List<String> VALID_PROVINCES = Arrays.asList(
            "AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT");

    // Constructor with validation
    public Student(int studentNumber, String firstName, String lastName, String telephoneNumber,
                   String address, String province, double averageGrade, String major) {
        // Validation rules
        if (studentNumber <= 200034000) {
            throw new IllegalArgumentException("Student number must be greater than 200034000");
        }
        if (firstName.length() < 2) {
            throw new IllegalArgumentException("First name must be more than 1 character");
        }
        if (lastName.length() < 2) {
            throw new IllegalArgumentException("Last name must be more than 1 character");
        }
        if (!isValidTelephoneNumber(telephoneNumber)) {
            throw new IllegalArgumentException("Invalid telephone number");
        }
        if (address.length() <= 6) {
            throw new IllegalArgumentException("Address must be more than 6 characters");
        }
        if (!VALID_PROVINCES.contains(province)) {
            throw new IllegalArgumentException("Province is not valid");
        }
        if (averageGrade < 0 || averageGrade > 100) {
            throw new IllegalArgumentException("Average grade must be in the range of 0-100");
        }
        if (major.length() <= 5) {
            throw new IllegalArgumentException("Major must be more than 5 characters");
        }

        // Initialize instance variables
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.province = province;
        this.averageGrade = averageGrade;
        this.major = major;
    }

    // Getters and Setters with validation in setters where applicable

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        // Validate student number
        if (studentNumber <= 200034000) {
            throw new IllegalArgumentException("Student number must be greater than 200034000");
        }
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // Validate first name
        if (firstName.length() < 2) {
            throw new IllegalArgumentException("First name must be more than 1 character");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        // Validate last name
        if (lastName.length() < 2) {
            throw new IllegalArgumentException("Last name must be more than 1 character");
        }
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        // Validate telephone number
        if (!isValidTelephoneNumber(telephoneNumber)) {
            throw new IllegalArgumentException("Invalid telephone number");
        }
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // Validate address
        if (address.length() <= 6) {
            throw new IllegalArgumentException("Address must be more than 6 characters");
        }
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        // Validate province
        if (!VALID_PROVINCES.contains(province)) {
            throw new IllegalArgumentException("Province is not valid");
        }
        this.province = province;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        // Validate average grade
        if (averageGrade < 0 || averageGrade > 100) {
            throw new IllegalArgumentException("Average grade must be in the range of 0-100");
        }
        this.averageGrade = averageGrade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        // Validate major
        if (major.length() <= 5) {
            throw new IllegalArgumentException("Major must be more than 5 characters");
        }
        this.major = major;
    }

    // Utility method to validate North American telephone number
    private boolean isValidTelephoneNumber(String telephoneNumber) {
        // Placeholder method for validation logic
        // Actual implementation depends on specific requirements
        // For example, use regex or other validation rules
        return telephoneNumber != null && !telephoneNumber.isEmpty();
    }

    // Example usage in a main method
    public static void main(String[] args) {
        // Example of creating a student with valid parameters
        try {
            Student student = new Student(200034001, "John", "Doe", "123-456-7890",
                    "123 Main St", "ON", 85.5, "Computer Science");
            // Use getters and setters as needed
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating student: " + e.getMessage());
        }
    }
}
