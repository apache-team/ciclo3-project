package com.example.apache.controllers;

import com.example.apache.services.EnterpriseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FrontController {
  EnterpriseService enterpriseService;

  public FrontController(EnterpriseService enterpriseService) {
    this.enterpriseService = enterpriseService;
  }

  @GetMapping("/")
  public String index() {
    return "home";
  }


  @GetMapping("/layout")
  public String sideBar() {
    return "layouts/template";
  }

  @GetMapping("/manager_transaction")
  public String transaction(Map<String, Object>model) {
    model.put("title", "Transacciones");
    model.put("main_title", "Ingresos y Gastos");
    model.put("img_name", "money.png");
    model.put("key", "manager");
    return "manager_transaction";
  }


  @GetMapping("/manager_user")
  public String user(Map<String, Object>model) {
    model.put("title", "Usuarios");
    model.put("main_title", "Usuarios");
    model.put("img_name", "user.png");
    model.put("key", "manager");
    return "manager_user";
  }

  @GetMapping("/manager_enterprise")
  public String enterprise(Map<String, Object>model) {
    model.put("title", "Empresas");
    model.put("main_title", "Empresas");
    model.put("img_name", "enterprise.png");
    model.put("key", "manager");
    return "manager_enterprise";
  }

  @GetMapping("/create_transaction")
  public String createTransaction(Map<String, Object>model) {
    model.put("title", "Transacciones");
    model.put("main_title", "Ingresos y Gastos");
    model.put("img_name", "money.png");
    model.put("key", "create");
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
}

