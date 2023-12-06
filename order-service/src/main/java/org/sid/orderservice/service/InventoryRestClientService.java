package org.sid.orderservice.service;
import org.sid.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping("/products/{id}?projection=FullProduct")
    public Product productById(@PathVariable("id") Long id);

    @GetMapping("/products?projection=FullProduct")
    public PagedModel<Product> allProducts();
}


