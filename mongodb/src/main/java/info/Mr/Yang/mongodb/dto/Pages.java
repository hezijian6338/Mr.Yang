package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.Section;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 完整的WEB端需要的页面JSON数据格式
 * @author: hezijian6338
 * @create: 2019-01-11 13:57
 **/

public class Pages {

    private int id;

    @ApiModelProperty(value = "主页名称")
    private String name;

    @ApiModelProperty(value = "主页背景颜色...")
    private String backgroundColor;

    @ApiModelProperty(value = "主页栏目")
    private List<Sections> sections;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void setSections(List<Sections> sections) {
        this.sections = sections;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public List<Sections> getSections() {
        return sections;
    }
}
