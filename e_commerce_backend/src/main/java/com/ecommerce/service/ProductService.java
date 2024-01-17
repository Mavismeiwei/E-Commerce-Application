package com.ecommerce.service;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addNewProduct(Product product){
       return productDao.save(product);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productDao.findAll();
    }

    public void deleteProductDescription(Integer productId) {
        productDao.deleteById(productId);
    }
}
