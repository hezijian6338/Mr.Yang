package info.Mr.Yang.mongodb.controller;

import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.model.Favorite;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.FavoriteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
 * Date: 2016/11/15 15:49
 * Copyright(©) 2015 by xiaomo.
 **/

@RestController
@RequestMapping("favorite")
@Api("收藏夹信息操作Api")
public class FavoriteController {

    private final FavoriteService service;

    @Autowired
    public FavoriteController(FavoriteService service) {
        this.service = service;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") Long id) {
        Favorite favorite = service.findById(id);
        return new Result<>(favorite);
    }

//    @RequestMapping(value = "{user_id}/products", method = RequestMethod.GET)
//    public Result getByUser(@PathVariable("user_id") Long user_id) {
//        SkuList<Product> favorites = service.findProductByUser(user_id);
//        return new Result<>(favorites);
//    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Favorite favorite) {
        // favorite.setImg(file);
        return new Result<>(service.add(favorite));
    }
    

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
