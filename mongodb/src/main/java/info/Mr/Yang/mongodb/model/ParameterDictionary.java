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
    private String id;

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

     @ApiModelProperty(value = "显示图片列表")
     private List<String> image;

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

    @ApiModelProperty(value = "有待研究")
    private String productids;

    public void setId(String id) {
        this.id = id;
    }

    public void setPageSectionId(int pageSectionId) {
        this.pageSectionId = pageSectionId;
    }

    public void setBackgroundcolor(String backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    public void setBoxcolor(String boxcolor) {
        this.boxcolor = boxcolor;
    }

    public void setBoxtype(String boxtype) {
        this.boxtype = boxtype;
    }

    public void setButtonvalue(String buttonvalue) {
        this.buttonvalue = buttonvalue;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImagegap(int imagegap) {
        this.imagegap = imagegap;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setProductcategoryid(String productcategoryid) {
        this.productcategoryid = productcategoryid;
    }

    public void setProducttagid(String producttagid) {
        this.producttagid = producttagid;
    }

    public void setShownumber(int shownumber) {
        this.shownumber = shownumber;
    }

    public void setShowsort(int showsort) {
        this.showsort = showsort;
    }

    public void setShowtype(String showtype) {
        this.showtype = showtype;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setTextalign(String textalign) {
        this.textalign = textalign;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public int getPageSectionId() {
        return pageSectionId;
    }

    public int getImagegap() {
        return imagegap;
    }

    public int getShownumber() {
        return shownumber;
    }

    public int getShowsort() {
        return showsort;
    }

    public int getSource() {
        return source;
    }

    public int getTag() {
        return tag;
    }

    public int getType() {
        return type;
    }

    public String getBackgroundcolor() {
        return backgroundcolor;
    }

    public String getBoxcolor() {
        return boxcolor;
    }

    public String getBoxtype() {
        return boxtype;
    }

    public String getButtonvalue() {
        return buttonvalue;
    }

    public String getColor() {
        return color;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getPosition() {
        return position;
    }

    public String getProductcategoryid() {
        return productcategoryid;
    }

    public String getProducttagid() {
        return producttagid;
    }

    public String getShowtype() {
        return showtype;
    }

    public String getTextalign() {
        return textalign;
    }

    public List<String> getImage() {
        return image;
    }
}
