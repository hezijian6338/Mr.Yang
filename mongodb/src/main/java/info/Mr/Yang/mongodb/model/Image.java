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
    private String id;

//    @ApiModelProperty(value = "与栏目PageSectionId关联的字段")
//    private int pageSectionId;

    @ApiModelProperty(value = "点击图片的链接")
    private String link;

    @ApiModelProperty(value = "点击图片链接的名字")
    private String linkName;

    @ApiModelProperty(value = "图片的源地址")
    private String src;

    @ApiModelProperty(value = "图片的标题")
    private String title;

//    public void setPageSectionId(int pageSectionId) {
//        this.pageSectionId = pageSectionId;
//    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public void setSrc(String src) {
        this.src = src;
    }

//    public int getPageSectionId() {
//        return pageSectionId;
//    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getLinkName() {
        return linkName;
    }

    public String getSrc() {
        return src;
    }

}
