package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.dto.Favorites;
import info.Mr.Yang.mongodb.model.Favorite;
import info.Mr.Yang.mongodb.model.Product;

import java.util.List;

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


public interface FavoriteService {

    /**
     * 查所有
     *
     * @return
     */
    List<Favorite> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Favorite findById(String id);


    /**
     * 添加
     *
     * @param Favorite
     * @return
     */
    Favorite add(Favorite Favorite);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     *
     * @param Favorite
     * @return
     */
    Favorite update(Favorite Favorite);

    Favorites findProductById(String id);

}
