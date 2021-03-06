package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.dto.ParameterDictionarys;
import info.Mr.Yang.mongodb.model.Image;
import info.Mr.Yang.mongodb.model.ParameterDictionary;

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


public interface ParameterDictionaryService {

    /**
     * 查所有
     *
     * @return
     */
    List<ParameterDictionary> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    ParameterDictionary findById(String id);

    /**
     * 添加
     *
     * @param ParameterDictionary
     * @return
     */
    ParameterDictionary add(ParameterDictionary ParameterDictionary);

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

    List<Image> findImage(List<String> ids);

    ParameterDictionarys findPdsById(String id);

}
