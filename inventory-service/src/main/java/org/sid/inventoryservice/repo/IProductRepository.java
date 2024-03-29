package org.sid.inventoryservice.repo;

import org.sid.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IProductRepository extends JpaRepository<Product,Long> {
}
