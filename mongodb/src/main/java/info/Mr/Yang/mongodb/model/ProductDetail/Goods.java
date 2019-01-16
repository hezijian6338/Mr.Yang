package info.Mr.Yang.mongodb.model.ProductDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 商品详情
 * @author: hezijian6338
 * @create: 2019-01-16 15:07
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    @Id
    private String id;

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
    private String sku_id;

}
