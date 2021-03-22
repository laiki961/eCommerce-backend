package com.ventail.ecommerce.domain.entity;

import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="transaction_id", nullable = false, updatable = false)
    private Long transactionId;

    @Column(name ="total", nullable = false)
    private Double total;

    @Column(name="status", nullable = false)
    @Enumerated(EnumType.ORDINAL) //Make Jpa to save enum name into the column value
    private TransactionStatusEnum status;

    @Column(name = "billing_address1")
    private String addressLine1;

    @Column(name = "billing_address2")
    private String addressLine2;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="email")
    private String email;

    @OneToMany(mappedBy = "transaction", fetch = FetchType.EAGER)
    private List<TransactionProductEntity> transactionProducts;

    public TransactionEntity() {}

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TransactionProductEntity> getTransactionProducts() {
        return transactionProducts;
    }

    public void setTransactionProducts(List<TransactionProductEntity> transactionProducts) {
        this.transactionProducts = transactionProducts;
    }

    public TransactionEntity(Long transactionId, Double total, TransactionStatusEnum status, String addressLine1, String addressLine2, String firstName, String lastName, String email) {
        this.transactionId = transactionId;
        this.total = total;
        this.status = status;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
