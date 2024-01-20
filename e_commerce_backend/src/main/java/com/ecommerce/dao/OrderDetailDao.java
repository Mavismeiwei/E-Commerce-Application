package com.ecommerce.dao;

import com.ecommerce.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {

}
