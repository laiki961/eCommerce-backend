package com.ventail.ecommerce.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="TransactionProduct")
public class TransactionProductEntity {
    @Id
    @Column(name="id", nullable = false, updatable = false)
    private String transactionProductId;

    @ManyToOne
    @JoinColumn(name="product_id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="transaction_id", nullable = false)
    private TransactionEntity transaction;

    @Column(name="subtotal", nullable = false)
    private Double subtotal;

    @Column(name="quantity", nullable = false)
    private Integer quantity;

    public TransactionProductEntity(ProductEntity product, TransactionEntity transaction, Integer quantity) {
        this.transactionProductId = transaction.getTransactionId()+"_"+product.getProductId();
        this.product = product;
        this.transaction = transaction;
        this.subtotal = product.getPrice()*quantity;
        this.quantity = quantity;
    }

    public TransactionProductEntity(ProductEntity product, TransactionEntity transaction) {
        this.transactionProductId = transaction.getTransactionId()+"_"+product.getProductId();
        this.product = product;
        this.transaction = transaction;
    }

    public TransactionProductEntity() {}

    public String getTransactionProductId() {
        return transactionProductId;
    }

    public void setTransactionProductId(String transactionProductId) {
        this.transactionProductId = transactionProductId;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TransactionProductEntity{" +
                "product=" + product +
                ", transaction=" + transaction +
                ", subtotal=" + subtotal +
                ", quantity=" + quantity +
                '}';
    }
}
