package info.Mr.Yang.mongodb.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("product")
@Api("产品信息操作Api")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        Product product = service.findById(id);
        return new Result<>(product);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        PageInfo pageInfo = new PageInfo(service.findAll());

        return new Result<>(pageInfo);
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Product product) {
        // product.setImg(file);
        return new Result<>(service.add(product));
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

}
