package info.Mr.Yang.mongodb.model.ProductDetail;

import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.SkuList;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.Tree;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 商品规格总表
 * @author: hezijian6338
 * @create: 2019-01-16 15:31
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Sku {

    @Id
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

}
