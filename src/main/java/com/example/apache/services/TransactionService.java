package com.example.apache.services;

import com.example.apache.entities.Transaction;
import com.example.apache.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository repository;

    public TransactionService(TransactionRepository repository){
        this.repository=repository;
    }

    public List<Transaction> getTransactionList(){
        return this.repository.findAll();
    }

    public Transaction createTransaction(Transaction newTransaction){
        return this.repository.save(newTransaction);
    }
}
