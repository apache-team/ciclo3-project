package com.example.apache.services;

import com.example.apache.entities.Transaction;
import com.example.apache.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Transaction> getId(long id){
        return this.repository.findById(id);
    }

    public void deleteId(long id){
        this.repository.deleteById( id);
    }

    public Optional<Transaction> updateID(Transaction newData, Long id){
        return Optional.of(this.repository.findById(id)
                .map(transaction -> {
                    transaction.setConcept(newData.getConcept());
                    transaction.setAmount(newData.getAmount());
                    transaction.setCreatedAt(newData.getCreatedAt());
                    transaction.setUpdatedAt(newData.getUpdatedAt());
//                    transaction.setEmployee(newData.getEmployee());
//                    transaction.setEnterprise(newData.getEnterprise());
                    return repository.save(transaction);
                }).orElseGet(() -> {
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }

    public int save(Transaction u){
        int res=0;

        Transaction transaction = this.repository.save(u);

        if(!transaction.equals(null)){
            res = 1;
        }
        return res;
    }
}
