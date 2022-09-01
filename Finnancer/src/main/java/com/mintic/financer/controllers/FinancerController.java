/**
 * @author : aegon
 * @created : 2022-08-31
 */
package com.mintic.financer.controllers;

import com.mintic.financer.entities.Enterprise;
import com.mintic.financer.services.FinancerService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancerController {
  Enterprise enterprise;
  FinancerService financerService;

  public FinancerController(Enterprise enterprise) {
    this.enterprise = enterprise;
  }

  @GetMapping("/enterprises")
  public List<Enterprise> EnterpriseList() {
    return financerService.getEnterpriseList();
  }
}
