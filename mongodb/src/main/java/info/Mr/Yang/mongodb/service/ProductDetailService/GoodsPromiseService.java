package info.Mr.Yang.mongodb.service.ProductDetailService;

import info.Mr.Yang.mongodb.model.ProductDetail.GoodsPromise;

import java.util.List;
import java.util.Map;

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


public interface GoodsPromiseService {

    /**
     * 查所有
     *
     * @return
     */
    List<GoodsPromise> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    GoodsPromise findById(String id);

    /**
     * 根据ids查
     *
     * @param Ids
     * @return
     */
    List<GoodsPromise> findByIds(List<String> Ids);

    /**
     * 添加
     *
     * @param address
     * @return
     */
    GoodsPromise add(GoodsPromise address);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     *
     * @param id, updateFieldMap
     * @return
     */
    void update(String id, Map<String, Object> updateFieldMap);

}
