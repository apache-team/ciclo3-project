package com.example.apache.controllers;

import com.example.apache.entities.Transaction;
import com.example.apache.entities.User;
import com.example.apache.services.TransactionService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class FrontTransaction {
    TransactionService services;

    public FrontTransaction(TransactionService services){
        this.services = services;
    }

    @GetMapping("frontTransaction")
    public String index(Model model){
        List<Transaction> transactions = this.services.getTransactionList();
        model.addAttribute("transactions", transactions);
        return "transaction";
    }

    @GetMapping("/newTransaction")
    public String agregar(Model model){
        model.addAttribute("transaction", new Transaction());
        return "formTransaction";
    }

    @PostMapping("/saveTransaction")
    public String save(Transaction transaction, Model model){
        services.save(transaction);
        return "redirect:/frontTransaction";
    }

    @GetMapping("/editTransaction/{id}")
    public String editar(@PathVariable long id, Model model){
        Optional<Transaction> transaction = services.getId(id);
        model.addAttribute("transaction", transaction);
        return "formTransactionEdit";
    }

    @GetMapping("/deleteTransaction/{id}")
    public String delete(@PathVariable long id, Model model){
        services.deleteId(id);
        return "redirect:/frontTransaction";
    }
}
