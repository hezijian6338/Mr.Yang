package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.SkuList;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.Tree;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 完整的Sku
 * @author: hezijian6338
 * @create: 2019-01-17 16:09
 **/

public class Skus {

    private String id;

    @ApiModelProperty(value = "规格详情")
    private List<Tree> tree;

    @ApiModelProperty(value = "规格组合")
    private List<SkuList> list;

    @ApiModelProperty(value = "无规格商品 skuId 取 collection_id，否则取所选 sku 组合对应的 id")
    private String collection_id;

    @ApiModelProperty(value = "商品总库存")
    private int stock_num;

    @ApiModelProperty(value = "默认价格（单位元）")
    private String price;

    @ApiModelProperty(value = "是否无规格商品")
    private boolean none_sku;

    @ApiModelProperty(value = "hide_stock")
    private boolean hide_stock;

    public void setStock_num(int stock_num) {
        this.stock_num = stock_num;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCollection_id(String collection_id) {
        this.collection_id = collection_id;
    }

    public void setHide_stock(boolean hide_stock) {
        this.hide_stock = hide_stock;
    }

    public void setList(List<SkuList> list) {
        this.list = list;
    }

    public void setNone_sku(boolean none_sku) {
        this.none_sku = none_sku;
    }

    public void setTree(List<Tree> tree) {
        this.tree = tree;
    }

    public boolean getNone_sku(){
        return none_sku;
    }

    public boolean getHide_stock(){
        return hide_stock;
    }


    public int getStock_num() {
        return stock_num;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public List<SkuList> getList() {
        return list;
    }

    public List<Tree> getTree() {
        return tree;
    }

    public String getCollection_id() {
        return collection_id;
    }
}
