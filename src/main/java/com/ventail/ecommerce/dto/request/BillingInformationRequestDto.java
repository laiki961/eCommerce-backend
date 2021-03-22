package com.ventail.ecommerce.dto.request;

import com.ventail.ecommerce.domain.BillingInformation;

public class BillingInformationRequestDto {
    private String firstName;
    private String lastName;
    private String billingAddressLine1;
    private String billingAddressLine2;
    private String email;

    public BillingInformation toBillingInfo(BillingInformationRequestDto billingInformationRequestDto){
        BillingInformation billingInformation = new BillingInformation();
        billingInformation.setFirstName(billingInformationRequestDto.getFirstName());
        billingInformation.setLastName(billingInformationRequestDto.getLastName());
        billingInformation.setEmail(billingInformationRequestDto.getEmail());
        billingInformation.setBillingAddressLine1(billingInformationRequestDto.getBillingAddressLine1());
        billingInformation.setBillingAddressLine2(billingInformationRequestDto.getBillingAddressLine2());
        return billingInformation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingAddressLine2() {
        return billingAddressLine2;
    }

    public void setBillingAddressLine2(String billingAddressLine2) {
        this.billingAddressLine2 = billingAddressLine2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BillingInformationRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", billingAddressLine1='" + billingAddressLine1 + '\'' +
                ", billingAddressLine2='" + billingAddressLine2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
