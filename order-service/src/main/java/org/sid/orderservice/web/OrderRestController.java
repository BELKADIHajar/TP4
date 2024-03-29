package org.sid.orderservice.web;

import org.aspectj.weaver.ast.Or;
import org.sid.orderservice.entities.Order;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repository.OrderRepository;
import org.sid.orderservice.repository.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;


    public OrderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

   @GetMapping("/Myorder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
       Customer customer= customerRestClientService.customerById(order.getCustomerId());
       order.setCustomer(customer);
       order.getProductItemList().forEach(productItem -> {
           Product product=inventoryRestClientService.productById(productItem.getProductId());
           productItem.setProduct(product);
       });
       return order;
    }
}
