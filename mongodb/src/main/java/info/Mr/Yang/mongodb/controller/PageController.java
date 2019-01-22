package info.Mr.Yang.mongodb.controller;

import info.Mr.Yang.core.base.Result;
import info.Mr.Yang.core.constant.CodeConst;
import info.Mr.Yang.mongodb.dto.Pages;
import info.Mr.Yang.mongodb.model.Page;
import info.Mr.Yang.mongodb.service.PageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("page")
@Api("页面参数信息操作Api")
public class PageController {

    private final PageService service;

    @Autowired
    public PageController(PageService service) {
        this.service = service;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Result get(@PathVariable("id") String id) {
        Page page = service.findById(id);
        return new Result<>(page);
    }

    @ApiOperation(value = "获取最终Page格式参数")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Result getPages(@PathVariable("id") String id) {
        Pages pages = service.findSById(id);
        return new Result<>(pages);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result<>(service.findAll());
    }


    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody Page page) {
        // page.setImg(file);
        return new Result<>(service.add(page));
    }
    

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public Result delete(@PathVariable("id") String id) {
        service.delete(id);
        return new Result(CodeConst.SUCCESS.getResultCode(), CodeConst.SUCCESS.getMessage());
    }

}
