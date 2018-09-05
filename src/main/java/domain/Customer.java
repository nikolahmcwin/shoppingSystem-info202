/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author peani371
 */
public class Customer {

    private Integer customerID;
    private String username;
    private String firstName;
    private String surname;
    private String password;
    private String address;
    private String email;
    private String creditCard;

    public void setPersonID(Integer personID) {
        this.customerID = personID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmailAddress(String emailAddress) {
        this.email = emailAddress;
    }

    public void setCreditCardDetails(String creditCardDetails) {
        this.creditCard = creditCardDetails;
    }

    public Integer getPersonID() {
        return customerID;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }
    
    public String getEmailAddress() {
        return email;
    }

    public String getCreditCardDetails() {
        return creditCard;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", firstName=" 
                + firstName + ", surname=" + surname + '}';
    }

}
