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
 * @description: 栏目详细内容的信息表
 * @author: hezijian6338
 * @create: 2019-01-10 13:37
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ParameterDictionary {

    @Id
    private int id;

    @ApiModelProperty(value = "用来关联栏目的id(PageSectionId)")
    private int pageSectionId;

    @ApiModelProperty(value = "用来干嘛的关键词,不是每个都有,主要是搜索栏")
    private String keyword;

    @ApiModelProperty(value = "部件的样式属性")
    private String position;

    @ApiModelProperty(value = "部件的样式属性")
    private String backgroundcolor;

    @ApiModelProperty(value = "部件的样式属性")
    private String color;

    @ApiModelProperty(value = "部件的样式属性")
    private String textalign;

    @ApiModelProperty(value = "部件的样式属性")
    private String boxcolor;

    @ApiModelProperty(value = "部件的样式属性")
    private String boxtype;

    @ApiModelProperty(value = "样式类型,除了搜索栏基本都有")
    private int type;

    @ApiModelProperty(value = "样式类型")
    private int imagegap;

    @ApiModelProperty(value = "显示位置?")
    private int shownumber;

    // @ApiModelProperty(value = "显示图片列表")  用PageSectionId来关联
    // private List<String> imagelist;

    @ApiModelProperty(value = "有待研究")
    private int source;

    @ApiModelProperty(value = "有待研究")
    private int showsort;

    @ApiModelProperty(value = "有待研究")
    private int tag;

    @ApiModelProperty(value = "有待研究")
    private String showtype;

    @ApiModelProperty(value = "有待研究")
    private String buttonvalue;

    @ApiModelProperty(value = "有待研究")
    private String productcategoryid;

    @ApiModelProperty(value = "有待研究")
    private String producttagid;

}
