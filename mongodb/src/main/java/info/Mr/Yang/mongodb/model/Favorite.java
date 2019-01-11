package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 用来存放用户的收货地址
 * @author: hezijian6338
 * @create: 2019-01-10 10:13
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

    @Id
    private int id;

    @ApiModelProperty(value = "产品id关联字段")
    private List<String> product_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setProduct_id(List<String> product_id) {
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public List<String> getProduct_id() {
        return product_id;
    }

}
