package com.ecommerce.dao;

import com.ecommerce.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {

}
