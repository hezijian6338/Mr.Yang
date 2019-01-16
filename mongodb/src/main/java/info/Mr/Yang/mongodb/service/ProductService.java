package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.Product;

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


public interface ProductService {

    /**
     * 查所有
     *
     * @return
     */
    List<Product> findAll();

//    SkuList<Product> findLimit(Long lastId, int PageSize);

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Product findById(Long id);

    /**
     * 添加
     *
     * @param Product
     * @return
     */
    Product add(Product Product);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新
     *
     * @param Product
     * @return
     */
    void update(Long id, Map<String, Object> updateFieldMap);

}
