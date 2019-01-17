package info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 产品规格详情组合
 * @author: hezijian6338
 * @create: 2019-01-16 15:08
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SkuList {

    @Id
    private String id;

    @ApiModelProperty(value = "组合价格")
    private int price;

    @ApiModelProperty(value = "详情1")
    private String s1;

    @ApiModelProperty(value = "详情2")
    private String s2;

    @ApiModelProperty(value = "详情3")
    private String s3;

    @ApiModelProperty(value = "组合对应的库存")
    private int stock_num;

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public void setStock_num(int stock_num) {
        this.stock_num = stock_num;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getStock_num() {
        return stock_num;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }
}
