package com.ventail.ecommerce.domain.dto.request;

public class CompleteTransactionRequestDto {
    private Long transactionId;
    private BillingInformationRequestDto billingInformation;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BillingInformationRequestDto getBillingInformation() {
        return billingInformation;
    }

    public void setBillingInformation(BillingInformationRequestDto billingInformation) {
        this.billingInformation = billingInformation;
    }

    @Override
    public String toString() {
        return "CompleteTransactionRequestDto{" +
                "transactionId=" + transactionId +
                ", billingInformationRequestDto=" + billingInformation +
                '}';
    }
}
