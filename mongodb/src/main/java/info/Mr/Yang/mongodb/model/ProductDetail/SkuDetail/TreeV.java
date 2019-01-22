package info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 规格详情中的详情
 * @author: hezijian6338
 * @create: 2019-01-16 15:18
 **/

public class TreeV {

    @Id
    private String id;

    @ApiModelProperty(value = "详情中的名称")
    private String name;

    @ApiModelProperty(value = "详情中显示的图片链接")
    private String imgUrl;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
