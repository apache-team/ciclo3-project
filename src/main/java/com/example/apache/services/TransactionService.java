package com.example.apache.services;

import com.example.apache.entities.Transaction;
import com.example.apache.exceptions.TransactionNotFoundException;
import com.example.apache.repositories.TransactionRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
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
        newTransaction.setCreatedAt(LocalDate.now());
        newTransaction.setUpdatedAt(LocalDate.now());
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
                    transaction.setUpdatedAt(LocalDate.now());
                    transaction.setEmployee(newData.getEmployee());
                    transaction.setEnterprise(newData.getEnterprise());
                    return repository.save(transaction);
                }).orElseGet(() -> {
                    newData.setUpdatedAt(LocalDate.now());
                    newData.setId(id);
                    return repository.save(newData);
                }));
    }

    public void updateTransaction(Transaction newData, long id) {
        Transaction transaction = repository.findById(id).orElseThrow(TransactionNotFoundException::new);

        boolean needUpdate = false;

        if (StringUtils.hasLength(newData.getConcept())) {
            transaction.setConcept(newData.getConcept());
            needUpdate = true;
        }

        if (newData.getAmount() != transaction.getAmount()) {
            transaction.setAmount(newData.getAmount());
            needUpdate = true;
        }

        if (newData.getEnterprise() != null) {
            transaction.setEnterprise(newData.getEnterprise());
            needUpdate = true;
        }

        if (newData.getEmployee() != null) {
            transaction.setEmployee(newData.getEmployee());
            needUpdate = true;
        }

        if (needUpdate) {
            transaction.setUpdatedAt(LocalDate.now());
            repository.save(transaction);
        }
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
