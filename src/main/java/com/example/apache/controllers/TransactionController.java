package com.example.apache.controllers;

import com.example.apache.entities.Transaction;
import com.example.apache.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/transaction/{id}")
    public Optional<Transaction> getId(@PathVariable("id") Long id){
        return this.service.getId(id);
    }

    @DeleteMapping("/transaction/{id}")
    public String DeleteId(@PathVariable("id") Long id){

        this.service.deleteId(id);
        return "Registro eliminado con exito";
    }

    @PutMapping("/transaction/{id}")
    Optional<Transaction> replaceUser(@RequestBody Transaction newData, @PathVariable Long id) {
        return this.service.updateID(newData,id);
    }

}
