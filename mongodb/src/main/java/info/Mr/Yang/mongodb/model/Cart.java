package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 购物车列表,一个商品一条信息
 * @author: hezijian6338
 * @create: 2019-01-10 11:22
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    private String id;

    @ApiModelProperty(value = "用户的id")
    private String user_id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "商品描述,暂时不用,但是保留字段")
    private String desc;

    @ApiModelProperty(value = "商品图片地址")
    private String imageURL;

    @ApiModelProperty(value = "购买商品的数量")
    private int quantity;

    @ApiModelProperty(value = "产品的简要信息Product表的id")
    private String product_id;

    @ApiModelProperty(value = "产品详情中规格信息skuList表的id")
    private String skuList_id;

//    以下两个先不启用,后续再补上

//    @ApiModelProperty(value = "商品礼物")
//    private List<Gift> gifts;

//    @ApiModelProperty(value = "折扣信息")
//    private List<Coupon> coupons;

    public void setId(String id) {
        this.id = id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setSkuList_id(String skuList_id) {
        this.skuList_id = skuList_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getSkuList_id() {
        return skuList_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

}
