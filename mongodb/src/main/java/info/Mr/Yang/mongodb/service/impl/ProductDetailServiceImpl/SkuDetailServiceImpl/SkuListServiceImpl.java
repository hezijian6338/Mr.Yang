package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl.SkuDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.SkuDetail.SkuListDao;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.SkuList;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuDetailService.SkuListService;
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
public class SkuListServiceImpl implements SkuListService {
    private final SkuListDao dao;

    @Autowired
    public SkuListServiceImpl(SkuListDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<SkuList> findAll() {
        return dao.findAll();
    }
    
    @Override
    public SkuList findById(String id) {
        Optional<SkuList> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<SkuList> findByIds(List<String> Ids) {
        List<SkuList> skuLists = new ArrayList<>();
        for (String id : Ids) {
            skuLists.add(this.findById(id));
        }
        return skuLists;
    }

    @Override
    public SkuList add(SkuList skuList) {
        skuList.setId(null);
        return dao.save(skuList);
    }

    @Override
    public void delete(String id) {
        Optional<SkuList> optional = dao.findById(id);
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
