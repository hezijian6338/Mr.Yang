package info.Mr.Yang.mongodb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.model.Cart;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.CartService;
import info.Mr.Yang.mongodb.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("cart")
@Api("购物车的操作Api")
public class CartController {

    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        Cart cart = service.findById(id);
        return new Result<>(cart);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        PageInfo pageInfo = new PageInfo(service.findAll());

        return new Result<>(pageInfo);
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Cart cart) {
        cart.setId("");
        // cart.setImg(file);
        return new Result<>(service.add(cart));
    }
    

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

    @ApiOperation(value = "根据id更新具体的键值对")
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Result update(@PathVariable("id") String id, @RequestBody Map updateFieldMap) {
        service.update(id, updateFieldMap);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

    @ApiOperation(value = "根据id和商品详情更新数量和商品价格")
    @RequestMapping(value = "{id}/skuList/{sl_id}", method = RequestMethod.PATCH)
    public Result updatePrice(@PathVariable("id") String id, @PathVariable String sl_id, @RequestBody Map updateFieldMap) {
        service.updatePrice(id, sl_id, updateFieldMap);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
