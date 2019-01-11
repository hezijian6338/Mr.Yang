package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 产品的信息表
 * @author: hezijian6338
 * @create: 2019-01-10 11:22
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private int id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "价格")
    private String price;

    @ApiModelProperty(value = "商品图片地址")
    private String imageURL;

    public void setId(int id) {
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

    public int getId() {
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
