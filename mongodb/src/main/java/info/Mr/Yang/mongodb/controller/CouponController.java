package info.Mr.Yang.mongodb.controller;

import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.model.Coupon;
import info.Mr.Yang.mongodb.service.CouponService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
 * Date: 2016/11/15 15:49
 * Copyright(©) 2015 by xiaomo.
 **/

@RestController
@RequestMapping("coupon")
@Api("优惠券信息操作Api")
public class CouponController {

    private final CouponService service;

    @Autowired
    public CouponController(CouponService service) {
        this.service = service;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        Coupon coupon = service.findById(id);
        return new Result<>(coupon);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Coupon coupon) {
        // coupon.setImg(file);
        return new Result<>(service.add(coupon));
    }
    

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
