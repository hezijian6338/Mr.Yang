package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.GoodsDao;
import info.Mr.Yang.mongodb.dto.Goodss;
import info.Mr.Yang.mongodb.model.ProductDetail.Goods;
import info.Mr.Yang.mongodb.model.ProductDetail.GoodsInfo;
import info.Mr.Yang.mongodb.service.ProductDetailService.GoodsPromiseService;
import info.Mr.Yang.mongodb.service.ProductDetailService.GoodsService;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

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
public class GoodsServiceImpl implements GoodsService {
    private final GoodsDao dao;

    @Autowired
    public GoodsServiceImpl(GoodsDao dao) {
        this.dao = dao;
    }

    @Autowired
    public MongoTemplate mongoTemplate;

    @Autowired
    private GoodsPromiseService goodsPromiseService;

    @Autowired
    private SkuService skuService;

    @Override
    public List<Goods> findAll() {
        return dao.findAll();
    }
    
    @Override
    public Goods findById(String id) {
        Optional<Goods> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Goodss fillById(String id) {
        Goodss goodss = new Goodss();
        GoodsInfo goodsInfo = new GoodsInfo();

        Goods goods = this.findById(id);
        goodss.setGoodsPromises(goodsPromiseService.findByIds(goods.getGoodsPromises()));
        goodss.setSku(skuService.fillById(goods.getSku_id()));
        goodss.setGoods(goods);
        goodss.setId(goods.getId());

//        存放product的id值
        goodsInfo.setId(goods.getProduct_id());
        goodsInfo.setPicture(goods.getThumb().get(0));
        goodsInfo.setTitle(goods.getSubtitle());
        goodss.setGoodsInfo(goodsInfo);
        return goodss;
    }

    @Override
    public List<Goods> findByIds(List<String> Ids) {
        return null;
    }

    @Override
    public Goods add(Goods goods) {
        goods.setId(null);
        return dao.save(goods);
    }

    @Override
    public void delete(String id) {
        Optional<Goods> optional = dao.findById(id);
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
