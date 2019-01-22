package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.Coupon;

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


public interface CouponService {

    /**
     * 查所有
     *
     * @return
     */
    List<Coupon> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    Coupon findById(String id);

    /**
     * 根据ids查
     *
     * @param ids
     * @return
     */
    List<Coupon> findByIds(List<String> ids);

    /**
     * 添加
     *
     * @param Coupon
     * @return
     */
    Coupon add(Coupon Coupon);

    /**
     * 删除
     *
     * @param id
     */
    void delete(String id);

    /**
     * 更新
     *
     * @param Coupon
     * @return
     */
    Coupon update(Coupon Coupon);

}
