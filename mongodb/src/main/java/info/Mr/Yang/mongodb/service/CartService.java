package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.Cart;

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


public interface CartService {

    /**
     * 查所有
     *
     * @return
     */
    List<Cart> findAll();

//    SkuList<Cart> findLimit(Long lastId, int PageSize);

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Cart findById(String id);

    /**
     * 添加
     *
     * @param cart
     * @return
     */
    Cart add(Cart cart);

    List<Cart> adds(String user_id, List<Cart> carts);

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

    String checkExist(String user_id, String product_id, String skuList_id);

    void updatePrice(String id, String skuList_id, Map<String, Object> updateFieldMap);

}
