package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.GoodsPromiseDao;
import info.Mr.Yang.mongodb.model.ProductDetail.GoodsPromise;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.Tree;
import info.Mr.Yang.mongodb.service.ProductDetailService.GoodsPromiseService;
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
public class GoodsPromiseServiceImpl implements GoodsPromiseService {
    private final GoodsPromiseDao dao;

    @Autowired
    public GoodsPromiseServiceImpl(GoodsPromiseDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<GoodsPromise> findAll() {
        return dao.findAll();
    }
    
    @Override
    public GoodsPromise findById(String id) {
        Optional<GoodsPromise> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<GoodsPromise> findByIds(List<String> Ids) {
        List<GoodsPromise> goodsPromises = new ArrayList<>();
        for (String id : Ids) {
            goodsPromises.add(this.findById(id));
        }
        return goodsPromises;
    }

    @Override
    public GoodsPromise add(GoodsPromise goodsPromise) {
        return dao.save(goodsPromise);
    }

    @Override
    public void delete(String id) {
        Optional<GoodsPromise> optional = dao.findById(id);
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
