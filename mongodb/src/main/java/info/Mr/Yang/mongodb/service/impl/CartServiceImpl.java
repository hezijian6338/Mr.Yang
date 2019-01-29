package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.CartDao;
import info.Mr.Yang.mongodb.dao.ProductDao;
import info.Mr.Yang.mongodb.model.Cart;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.CartService;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuDetailService.SkuListService;
import info.Mr.Yang.mongodb.service.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    public SkuListService skuListService;

    @Autowired
    public ProductService productService;

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
    public List<Cart> adds(String user_id, List<Cart> carts) {
        List<Cart> carts_noId = new ArrayList<>();
        for (Cart cart : carts) {
            String exist_id = this.checkExist(user_id, cart.getProduct_id(), cart.getSkuList_id());
            Product product = productService.findById(cart.getProduct_id());
            cart.setTitle(product.getTitle());
            cart.setImageURL(product.getImageURL());
            if (exist_id.isEmpty()) {
                cart.setId(null);
                cart.setUser_id(user_id);
                cart.setPrice(Integer.toString(skuListService.findById(cart.getSkuList_id()).getPrice() * cart.getQuantity()));
//                carts_noId.add(cart);
//                dao.saveAll(carts_noId);
                carts_noId.add(dao.save(cart));
            } else {
                Cart exist_cart = this.findById(exist_id);
                int quantity = exist_cart.getQuantity() + cart.getQuantity();
                exist_cart.setQuantity(quantity);
                int price = skuListService.findById(cart.getSkuList_id()).getPrice() * quantity;
                exist_cart.setPrice(Integer.toString(price));
                Map<String, Object> map = new HashMap<>();
                map.put("price", Integer.toString(price));
                map.put("quantity", quantity);
                map.put("title", cart.getTitle());
                map.put("imageURL", cart.getImageURL());
                map.put("desc", cart.getDesc());
                dao.update(exist_id, map);
                carts_noId.add(exist_cart);
            }
        }
        return carts_noId;
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

    @Override
    public String checkExist(String user_id, String product_id, String skuList_id) {

        Cart cart = mongoTemplate.findOne(Query.query(new Criteria().andOperator(
                Criteria.where("user_id").is(user_id),
                Criteria.where("product_id").is(product_id),
                Criteria.where("skuList_id").is(skuList_id)
        )), Cart.class);
        return cart == null ? "" : cart.getId();
    }

}
