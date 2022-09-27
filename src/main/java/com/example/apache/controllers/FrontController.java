package com.example.apache.controllers;

import com.example.apache.entities.Transaction;
import com.example.apache.entities.User;
import com.example.apache.services.EmployeeService;
import com.example.apache.services.EnterpriseService;
import com.example.apache.services.TransactionService;
import com.example.apache.services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class FrontController {
  EnterpriseService enterpriseService;
  TransactionService transactionService;
  UserService userService;
  EmployeeService employeeService;

  public FrontController(EnterpriseService enterpriseService, TransactionService transactionService, UserService userService, EmployeeService employeeService) {
    this.enterpriseService = enterpriseService;
    this.transactionService = transactionService;
    this.userService = userService;
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public String index(Model model, @AuthenticationPrincipal OidcUser principal) {
    return "home";
  }


  @GetMapping("/layout")
  public String sideBar() {
    return "layouts/template";
  }

  @GetMapping("/manager_transaction")
  public String transaction(Model model, Map<String, Object> variables) {
    model.addAttribute("transactionList", this.transactionService.getTransactionList());
    variables.put("title", "Transacciones");
    variables.put("main_title", "Ingresos y Gastos");
    variables.put("img_name", "money.png");
    variables.put("key", "manager");
    return "manager_transaction";
  }

  @GetMapping("/manager_user")
  public String user(Model model, Map<String, Object>variables) {
    model.addAttribute("employeeList", this.employeeService.getEmployeeList());
    variables.put("title", "Usuarios");
    variables.put("main_title", "Usuarios");
    variables.put("img_name", "user.png");
    variables.put("key", "manager");
    return "manager_user";
  }

  @GetMapping("/manager_enterprise")
  public String enterprise(Model model, Map<String, Object>variables) {
    model.addAttribute("enterpriseList", this.enterpriseService.getEnterpriseList());
    variables.put("title", "Empresas");
    variables.put("main_title", "Empresas");
    variables.put("img_name", "enterprise.png");
    variables.put("key", "manager");
    return "manager_enterprise";
  }

  @GetMapping("/create_transaction")
  public String createTransaction(Model model, Map<String, Object>variables) {
    model.addAttribute("transaction", new Transaction());
    variables.put("title", "Transacciones");
    variables.put("main_title", "Ingresos y Gastos");
    variables.put("img_name", "money.png");
    variables.put("key", "create");
    return "create_transaction";
  }

  @GetMapping("/create_user")
  public String createUser(Map<String, Object>model) {
    model.put("title", "Usuarios");
    model.put("main_title", "Usuarios");
    model.put("img_name", "user.png");
    model.put("key", "create");
    return "create_user";
  }

  @GetMapping("/create_enterprise")
  public String createEnterprise(Map<String, Object>model) {
    model.put("title", "Empresas");
    model.put("main_title", "Empresas");
    model.put("img_name", "enterprise.png");
    model.put("key", "create");
    return "create_enterprise";
  }

  @PostMapping("/save_transaction")
  public String save(Transaction transaction, Model model) {
    transactionService.save(transaction);
    return "redirect:/manager_transaction";
  }

  @GetMapping("/delete_transaction/{id}")
  public String deleteTransaction(@PathVariable long id, Model model) {
    transactionService.deleteId(id);
    return "redirect:/manager_transaction";
  }

  @GetMapping("/editTransaction/{id}")
  public String editar(@PathVariable long id, Model model, Map<String, Object>variables){
    variables.put("title", "Transacciones");
    variables.put("main_title", "Ingresos y Gastos");
    variables.put("img_name", "money.png");
    variables.put("key", "create");

    Optional<Transaction> transaction = transactionService.getId(id);
    model.addAttribute("transaction", transaction);
    return "edit_transaction";
  }


}

