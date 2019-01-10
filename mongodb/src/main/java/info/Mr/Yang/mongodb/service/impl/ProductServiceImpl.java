package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.ProductDao;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

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
    public Product update(Product Product) {
        return dao.save(Product);
    }
}
