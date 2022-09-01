/**
 * @author : aegon
 * @created : 2022-08-31
 */
package com.mintic.financer.services;

import com.mintic.financer.entities.Enterprise;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FinancerService {

  Enterprise enterprise1 = new Enterprise("Oracle", "12345", "98765", "calle 1");
  Enterprise enterprise2 = new Enterprise("Google", "8765", "23456", "calle 2");
  List<Enterprise> enterprises = new ArrayList<>();

  public List<Enterprise> getEnterpriseList() {
    enterprises.add(enterprise1);
    enterprises.add(enterprise2);
    return this.enterprises;
  }
}
