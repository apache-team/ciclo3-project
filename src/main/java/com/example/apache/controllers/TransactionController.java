package com.example.apache.controllers;

import com.example.apache.entities.Transaction;
import com.example.apache.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {
    TransactionService service;

    public TransactionController(TransactionService service){
        this.service =service;
    }

    @GetMapping("/transaction")
    public List<Transaction> transactionList(){
        return this.service.getTransactionList();
    }

    @PostMapping(value = "/transaction", consumes = {"application/json"})
    public Transaction createTransaction(@RequestBody Transaction transaction){
        return this.service.createTransaction(transaction);
    }

}
