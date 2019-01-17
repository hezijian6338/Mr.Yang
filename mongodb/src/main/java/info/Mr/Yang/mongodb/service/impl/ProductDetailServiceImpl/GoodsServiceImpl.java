package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.GoodsDao;
import info.Mr.Yang.mongodb.dto.Goodss;
import info.Mr.Yang.mongodb.model.ProductDetail.Goods;
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
        Goods goods = this.findById(id);
        goodss.setGoodsPromises(goodsPromiseService.findByIds(goods.getGoodsPromises()));
        goodss.setTitle(goods.getTitle());
        goodss.setThumb(goods.getThumb());
        goodss.setSubtitle(goods.getSubtitle());
        goodss.setSku_id(skuService.fillById(goods.getSku_id()));
        goodss.setRemain(goods.getRemain());
        goodss.setProduct_id(goods.getProduct_id());
        goodss.setPrice(goods.getPrice());
        goodss.setMarket_price(goods.getMarket_price());
        goodss.setInfo(goods.getInfo());
        goodss.setExpress(goods.getExpress());
        goodss.setId(goods.getId());
        return goodss;
    }

    @Override
    public List<Goods> findByIds(List<String> Ids) {
        return null;
    }

    @Override
    public Goods add(Goods goods) {
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
