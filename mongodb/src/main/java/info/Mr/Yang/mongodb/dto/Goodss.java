package info.Mr.Yang.mongodb.dto;

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

    @ApiModelProperty(value = "产品id,关联产品的id")
    private String product_id;

    @ApiModelProperty(value = "产品详情标题")
    private String title;

    @ApiModelProperty(value = "产品详情描述")
    private String subtitle;

    @ApiModelProperty(value = "显示价格,分位")
    private int price;

    @ApiModelProperty(value = "外面销售的价格,分位")
    private int market_price;

    @ApiModelProperty(value = "不详")
    private String express;

    @ApiModelProperty(value = "不详")
    private int remain;

    @ApiModelProperty(value = "循环播放列表,直接存放地址就行")
    private List<String> thumb;

    @ApiModelProperty(value = "商品详情")
    private String info;

    @ApiModelProperty(value = "提供服务的详情")
    private List<GoodsPromise> goodsPromises;

    @ApiModelProperty(value = "放商品规格详情")
    private Skus sku;

    public void setId(String id) {
        this.id = id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpress() {
        return express;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public void setGoodsPromises(List<GoodsPromise> goodsPromises) {
        this.goodsPromises = goodsPromises;
    }

    public void setMarket_price(int market_price) {
        this.market_price = market_price;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    public void setSku_id(Skus sku) {
        this.sku = sku;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setThumb(List<String> thumb) {
        this.thumb = thumb;
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getMarket_price() {
        return market_price;
    }

    public int getRemain() {
        return remain;
    }

    public List<GoodsPromise> getGoodsPromises() {
        return goodsPromises;
    }

    public List<String> getThumb() {
        return thumb;
    }

    public Skus getSku() {
        return sku;
    }

    public String getSubtitle() {
        return subtitle;
    }

}
