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
 * @description: 主页面的信息表
 * @author: hezijian6338
 * @create: 2019-01-10 11:50
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Page {

    @Id
    private int id;

    @ApiModelProperty(value = "主页名称")
    private String name;

    @ApiModelProperty(value = "主页背景颜色...")
    private String backgroundColor;

    @ApiModelProperty(value = "主页栏目管理id(暂确定,不关联主id,关联的也是唯一id)")
    private List<String> section_id;

}
