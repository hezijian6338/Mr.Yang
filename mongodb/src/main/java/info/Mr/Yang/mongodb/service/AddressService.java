package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.Address;

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


public interface AddressService {

    /**
     * 查所有
     *
     * @return
     */
    List<Address> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Address findById(Long id);

    /**
     * 根据ids查
     *
     * @param Ids
     * @return
     */
    List<Address> findByIds(List<String> Ids);

    /**
     * 添加
     *
     * @param address
     * @return
     */
    Address add(Address address);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新
     *
     * @param address
     * @return
     */
    void update(Address address);

}
