package com.ecommerce.dao;

import com.ecommerce.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

}
