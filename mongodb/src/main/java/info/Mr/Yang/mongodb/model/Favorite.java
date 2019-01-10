package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

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

    // @ApiModelProperty(value = "总页数(相当于循环显示数量,这个估计以后可以去掉)")
    // private int totalPage;

    @ApiModelProperty(value = "用户id关联字段")
    private int user_id;

    @ApiModelProperty(value = "产品id关联字段")
    private int product_id;

}
