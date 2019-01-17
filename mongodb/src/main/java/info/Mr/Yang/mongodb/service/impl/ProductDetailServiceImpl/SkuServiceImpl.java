package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.SkuDao;
import info.Mr.Yang.mongodb.dto.Skus;
import info.Mr.Yang.mongodb.model.ProductDetail.Sku;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuDetailService.SkuListService;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuDetailService.TreeService;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

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
public class SkuServiceImpl implements SkuService {
    private final SkuDao dao;

    @Autowired
    public SkuServiceImpl(SkuDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Autowired
    private SkuListService skuListService;

    @Autowired
    private TreeService treeService;

    @Override
    public List<Sku> findAll() {
        return dao.findAll();
    }
    
    @Override
    public Sku findById(String id) {
        Optional<Sku> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Skus fillById(String id) {
        Sku sku = this.findById(id);
        Skus skus = new Skus();
        skus.setList(skuListService.findByIds(sku.getList()));
        skus.setTree(treeService.findByIds(sku.getTree()));
        skus.setCollection_id(sku.getCollection_id());
        skus.setStock_num(sku.getStock_num());
        skus.setPrice(sku.getPrice());
        skus.setNone_sku(sku.getNone_sku());
        skus.setHide_stock(sku.getHide_stock());
        skus.setId(sku.getId());
        return skus;
    }

    @Override
    public List<Sku> findByIds(List<String> Ids) {
        return null;
    }

    @Override
    public Sku add(Sku sku) {
        return dao.save(sku);
    }

    @Override
    public void delete(String id) {
        Optional<Sku> optional = dao.findById(id);
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
