package com.ecommerce.service;

import com.ecommerce.configuration.JwtRequestFilter;
import com.ecommerce.dao.CartDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;
    public Cart addToCart(Integer productId) {
        Product product = productDao.findById(productId).get();

        User user = null;
        String username = JwtRequestFilter.CURRENT_USER;
        if (username != null) {
            user = userDao.findById(username).get();
        }

        if(product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartDao.save(cart);
        }
        return null;
    }
}
