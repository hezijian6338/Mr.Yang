package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.Image;

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


public interface ImageService {

    /**
     * 查所有
     *
     * @return
     */
    List<Image> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Image findById(String id);

    List<Image> findByIds(List<String> ids);

    /**
     * 添加
     *
     * @param image
     * @return
     */
    Image add(Image image);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     *
     * @param id, updateFielMap
     * @return
     */
    void update(String id, Map<String, Object> updateFieldMap);

}
