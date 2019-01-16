package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.ProductDao;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

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
public class ProductServiceImpl implements ProductService {
    private final ProductDao dao;

    @Autowired
    public ProductServiceImpl(ProductDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

//    @Override
//    List<Product> findLimit(Long lastId, int PageSize) {
//        //用来封装所有条件的对象
//        Query query = new Query();
//        //用来构建条件
//        Criteria criteria = new Criteria();
//        List<Order> orders = new ArrayList<Order>();  //排序
//        orders.add(new Order(Direction.DESC, "_id"));
//        Sort sort = new Sort(orders);
//
//
//        return mongoTemplate.find()
//    }

    @Override
    public Product findById(Long id) {
        Optional<Product> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product add(Product Product) {
        return dao.save(Product);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(Long id, Map<String, Object> updateFieldMap) {
        dao.update(id, updateFieldMap);
    }
}
