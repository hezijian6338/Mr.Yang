package info.Mr.Yang.mongodb.controller;

import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.dto.Favorites;
import info.Mr.Yang.mongodb.dto.UserIndex;
import info.Mr.Yang.mongodb.model.Address;
import info.Mr.Yang.mongodb.model.Coupon;
import info.Mr.Yang.mongodb.model.User;
import info.Mr.Yang.mongodb.service.AddressService;
import info.Mr.Yang.mongodb.service.CouponService;
import info.Mr.Yang.mongodb.service.FavoriteService;
import info.Mr.Yang.mongodb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
 * Date: 2016/11/15 15:49
 * Copyright(©) 2015 by xiaomo.
 **/

@RestController
@RequestMapping("user")
@Api("用户信息操作Api")
public class UserController {

    private final UserService service;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CouponService couponService;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        // User user = service.findById(id);
        UserIndex user = service.findById_UserIndex(id);
        return new Result<>(user);
    }

    @ApiOperation(value = "根据用户id获取收藏夹内容")
    @RequestMapping(value = "{id}/favorites", method = RequestMethod.GET)
    public Result getUserFavorites(@ApiParam(required = true, name = "id", value = "填写用户的id") @PathVariable("id") String id) {
        Favorites favorites = favoriteService.findProductById(id);
        return new Result<>(favorites);
    }

    @ApiOperation(value = "根据用户id获取收货地址")
    @RequestMapping(value = "{id}/addresses", method = RequestMethod.GET)
    public Result getUserAddresses(@ApiParam(required = true, name = "id", value = "填写用户的id")@PathVariable("id") String id) {
        User user = service.findById(id);
        List<Address> addresses = addressService.findByIds(user.getAddressList_id());
        return new Result<>(addresses);
    }

    @ApiOperation(value = "根据用户id获取优惠券")
    @RequestMapping(value = "{id}/coupons", method = RequestMethod.GET)
    public Result getUserCoupons(@ApiParam(required = true, name = "id", value = "填写用户的id")@PathVariable("id") String id) {
        User user = service.findById(id);
        List<Coupon> Coupon = couponService.findByIds(user.getCoupon_id());
        return new Result<>(Coupon);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody User user) {
        // user.setImg(file);
        return new Result<>(service.add(user));
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

    @ApiOperation(value = "更新整个User空的部分")
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Result update(@RequestBody User user) {
        service.update(user);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

    @ApiOperation(value = "根据id更新具体的键值对")
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Result update(@PathVariable("id") String id, @RequestBody Map updateFieldMap) {
        service.update(id, updateFieldMap);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
