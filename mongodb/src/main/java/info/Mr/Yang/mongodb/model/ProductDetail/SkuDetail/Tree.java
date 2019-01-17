package info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 商品详情中, 商品规格中的规格详细
 * @author: hezijian6338
 * @create: 2019-01-16 15:08
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Tree {

    @Id
    private String id;

    @ApiModelProperty(value = "规格名称")
    private String k;

    @ApiModelProperty(value = "规格详情")
    private List<TreeV> v;

    @ApiModelProperty(value = "规格代号/id")
    private String k_s;

    public void setId(String id) {
        this.id = id;
    }

    public void setK(String k) {
        this.k = k;
    }

    public void setK_s(String k_s) {
        this.k_s = k_s;
    }

    public void setV(List<TreeV> v) {
        this.v = v;
    }

    public List<TreeV> getV() {
        return v;
    }

    public String getK() {
        return k;
    }

    public String getK_s() {
        return k_s;
    }

    public String getId() {
        return id;
    }

}
