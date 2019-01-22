package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.ProductDetail.Goods;
import info.Mr.Yang.mongodb.model.ProductDetail.GoodsInfo;
import info.Mr.Yang.mongodb.model.ProductDetail.GoodsPromise;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 产品详细全资料
 * @author: hezijian6338
 * @create: 2019-01-17 16:33
 **/

public class Goodss {

    private String id;

    @ApiModelProperty(value = "goods详情")
    private Goods goods;

    @ApiModelProperty(value = "提供服务的详情")
    private List<GoodsPromise> goodsPromises;

    @ApiModelProperty(value = "放商品规格详情")
    private Skus sku;

    @ApiModelProperty(value = "默认商品详情")
    private GoodsInfo goodsInfo;

    public void setId(String id) {
        this.id = id;
    }

    public void setGoodsPromises(List<GoodsPromise> goodsPromises) {
        this.goodsPromises = goodsPromises;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setSku(Skus sku) {
        this.sku = sku;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public String getId() {
        return id;
    }

    public Goods getGoods() {
        return goods;
    }

    public List<GoodsPromise> getGoodsPromises() {
        return goodsPromises;
    }

    public Skus getSku() {
        return sku;
    }

}
