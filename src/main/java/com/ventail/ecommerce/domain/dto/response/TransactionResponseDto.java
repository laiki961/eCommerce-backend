package com.ventail.ecommerce.domain.dto.response;

import com.ventail.ecommerce.domain.Transaction;
import com.ventail.ecommerce.domain.enumeration.TransactionStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    private Long transactionId;
    private List<TransactionItemsResponseDto> items;
    private Double total;
    private TransactionStatusEnum status;

    public TransactionResponseDto(Transaction transaction) {
        this.transactionId = transaction.getTransactionId();
        List<TransactionItemsResponseDto> transactionItemsResponseDto = new ArrayList<>();
        // Create TransactionItemsResponseDto
        for(int i=0; i<transaction.getItems().size();i++){
            transactionItemsResponseDto.add(new TransactionItemsResponseDto(transaction.getItems().get(i)));
        }
        this.items = transactionItemsResponseDto;
        this.total = transaction.getTotal();
        this.status = transaction.getStatus();
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<TransactionItemsResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionItemsResponseDto> items) {
        this.items = items;
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

    @Override
    public String toString() {
        return "TransactionResponseDto{" +
                "transactionId=" + transactionId +
                ", items=" + items +
                ", total=" + total +
                ", status=" + status +
                '}';
    }
}
