package org.sid.orderservice.service;

import org.sid.orderservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerRestClientService {
    @GetMapping("/customers/{id}?projection=FullCustomer")
    public Customer customerById(@PathVariable Long id);
    @GetMapping("/customers?projection=FullCustomer")
    public PagedModel<Customer> allCustomers();
}
