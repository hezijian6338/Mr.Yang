package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.CartDao;
import info.Mr.Yang.mongodb.dao.ProductDao;
import info.Mr.Yang.mongodb.model.Cart;
import info.Mr.Yang.mongodb.service.CartService;
import info.Mr.Yang.mongodb.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author : xiaomo
 * github: https://github.com/xiaomoinfo
 * email: xiaomo@xiaomo.info
 * <p>
 * Date: 2016/11/15 15:45
 * Copyright(©) 2015 by xiaomo.
 **/

@Service
public class CartServiceImpl implements CartService {
    private final CartDao dao;

    @Autowired
    public CartServiceImpl(CartDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<Cart> findAll() {
        return dao.findAll();
    }

    @Override
    public Cart findById(String id) {
        Optional<Cart> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Cart add(Cart cart) {
        cart.setId(null);
        return dao.save(cart);
    }

    @Override
    public List<Cart> adds(List<Cart> carts) {
        List<Cart> carts_noId = new ArrayList<>();
        for (Cart cart : carts) {
            cart.setId(null);
            carts_noId.add(cart);
        }
        return dao.saveAll(carts_noId);
    }

    @Override
    public void delete(String id) {
        Optional<Cart> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(String id, Map<String, Object> updateFieldMap) {
        dao.update(id, updateFieldMap);
    }
}
