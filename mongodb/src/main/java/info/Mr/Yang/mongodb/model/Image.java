package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 存放信息图片详细信息表
 * @author: hezijian6338
 * @create: 2019-01-11 14:22
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    private int id;

    @ApiModelProperty(value = "与栏目PageSectionId关联的字段")
    private int pageSectionId;

    @ApiModelProperty(value = "点击图片的链接")
    private String link;

    @ApiModelProperty(value = "点击图片链接的名字")
    private String linkName;

    @ApiModelProperty(value = "图片的源地址")
    private String src;

    @ApiModelProperty(value = "图片的标题")
    private String title;

}
