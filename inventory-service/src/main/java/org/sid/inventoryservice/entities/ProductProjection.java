package org.sid.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "FullProduct", types = Product.class)
public interface ProductProjection {
    public Long getId();
    public int getquatity();
    public String getname();
    public double getprice();
}
