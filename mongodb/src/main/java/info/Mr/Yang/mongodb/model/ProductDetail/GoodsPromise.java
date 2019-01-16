package info.Mr.Yang.mongodb.model.ProductDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 商品承诺提供的服务
 * @author: hezijian6338
 * @create: 2019-01-16 16:49
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPromise {

    @Id
    private String id;

    @ApiModelProperty(value = "服务名字")
    private String name;

    @ApiModelProperty(value = "服务详情")
    private String info;

    @ApiModelProperty(value = "图标类型")
    private String icon;

    @ApiModelProperty(value = "图标的颜色")
    private String color;

}
