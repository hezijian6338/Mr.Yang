package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @program: Shop
 * @description: 栏目信息表
 * @author: hezijian6338
 * @create: 2019-01-10 11:58
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    private int id;

    @ApiModelProperty(value = "关联页面的栏目id(唯一),也用来关联栏目内容的id(唯一)")
    private int pageSectionId;

    @ApiModelProperty(value = "pd的id,因为发现psid不唯一")
    private int pd_id;

    @ApiModelProperty(value = "栏目代码")
    private String code;

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPageSectionId(int pageSectionId) {
        this.pageSectionId = pageSectionId;
    }

    public void setPd_id(int pd_id) {
        this.pd_id = pd_id;
    }

    public int getId() {
        return id;
    }

    public int getPageSectionId() {
        return pageSectionId;
    }

    public int getPd_id() {
        return pd_id;
    }

    public String getCode() {
        return code;
    }
}
