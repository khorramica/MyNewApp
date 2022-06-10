package ir.khorrami.mynewapp.model;

public class Employee {
    private int employeeId;
    private String employeeName,dateOfBirth,currentAddress,permanentAddress,city,nationality,pinCode;

    public Employee(int employeeId, String employeeName, String dateOfBirth, String currentAddress, String permanentAddress, String city, String nationality, String pinCode) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
        this.city = city;
        this.nationality = nationality;
        this.pinCode = pinCode;
    }

    public Employee(String employeeName, String dateOfBirth, String city) {
        this.employeeName = employeeName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
