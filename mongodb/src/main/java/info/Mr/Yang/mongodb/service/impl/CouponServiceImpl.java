package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.CouponDao;
import info.Mr.Yang.mongodb.model.Coupon;
import info.Mr.Yang.mongodb.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class CouponServiceImpl implements CouponService {
    private final CouponDao dao;

    @Autowired
    public CouponServiceImpl(CouponDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Coupon> findAll() {
        return dao.findAll();
    }

    @Override
    public Coupon findById(Long id) {
        Optional<Coupon> optionalCoupon = dao.findById(id);
        return optionalCoupon.orElse(null);
    }
    

    @Override
    public Coupon add(Coupon Coupon) {
        return dao.save(Coupon);
    }

    @Override
    public void delete(Long id) {
        Optional<Coupon> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public Coupon update(Coupon Coupon) {
        return dao.save(Coupon);
    }
}
