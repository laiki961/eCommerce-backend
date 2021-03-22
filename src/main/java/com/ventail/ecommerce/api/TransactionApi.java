package com.ventail.ecommerce.api;

import com.ventail.ecommerce.domain.BillingInformation;
import com.ventail.ecommerce.domain.CheckoutItem;
import com.ventail.ecommerce.domain.Transaction;
import com.ventail.ecommerce.domain.entity.TransactionEntity;
import com.ventail.ecommerce.dto.request.CheckoutItemsRequestDto;
import com.ventail.ecommerce.dto.request.CompleteTransactionRequestDto;
import com.ventail.ecommerce.dto.response.TransactionResponseDto;
import com.ventail.ecommerce.service.TransactionService;
import com.ventail.ecommerce.service.impl.TransactionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
    @Autowired
    private TransactionService transactionService;

    Logger logger = LoggerFactory.getLogger(TransactionApi.class);

    @PostMapping
    public TransactionResponseDto createTransaction(@RequestBody List<CheckoutItemsRequestDto> checkoutItemDtos){
        //Convert List<CheckoutItemsRequestDto> to List<CheckoutItem>
        logger.debug(checkoutItemDtos.toString());

        List<CheckoutItem> checkoutItems = new ArrayList<>();
        for (int i=0; i<checkoutItemDtos.size(); i++){
            checkoutItems.add(checkoutItemDtos.get(i).toCheckoutItem());
        }
        Transaction transaction = transactionService.createTransaction(checkoutItems);
        //Convert transaction to TransactionResponseDto
        return new TransactionResponseDto(transaction);
    }

    @PatchMapping("/complete")
    public TransactionResponseDto completeTransaction(@RequestBody CompleteTransactionRequestDto completeTransactionRequestDto){
        //Convert BillingInformationRequestDto to BillingInformation
        BillingInformation billingInformation = completeTransactionRequestDto.getBillingInformation().toBillingInfo(completeTransactionRequestDto.getBillingInformation());
        Transaction transaction = transactionService.completeTransaction(completeTransactionRequestDto.getTransactionId(), billingInformation);
        return new TransactionResponseDto(transaction);
    }

    @GetMapping("/{transactionId}")
    public TransactionResponseDto getTransaction(@PathVariable ("transactionId") Long transactionId){
        Transaction transaction = transactionService.getTransaction(transactionId);
        return new TransactionResponseDto(transaction);
    }
}
