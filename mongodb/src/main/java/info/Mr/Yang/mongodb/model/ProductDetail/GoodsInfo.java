package info.Mr.Yang.mongodb.model.ProductDetail;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 默认商品详情
 * @author: hezijian6338
 * @create: 2019-01-22 14:46
 **/

public class GoodsInfo {

    @Id
    private String id;

    @ApiModelProperty(value = "默认商品的标题")
    private String title;

    @ApiModelProperty(value = "默认商品的图片链接")
    private String picture;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPicture() {
        return picture;
    }
}
