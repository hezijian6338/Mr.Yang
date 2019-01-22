package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.Product;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 收藏夹完整JSON格式
 * @author: hezijian6338
 * @create: 2019-01-11 15:01
 **/

public class Favorites {

    private String id;

    @ApiModelProperty(value = "收藏夹的商品")
    private List<Product> products;

    public void setId(String id) {
        this.id = id;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProduct() {
        return products;
    }

}
