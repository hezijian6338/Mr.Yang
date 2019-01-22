package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.ParameterDictionary;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @program: Shop
 * @description: WEB端栏目参数的具体JSON数据格式
 * @author: hezijian6338
 * @create: 2019-01-11 14:00
 **/

public class Sections {

    private String id;

    @ApiModelProperty(value = "关联页面的栏目id(唯一),也用来关联栏目内容的id(唯一)")
    private int pageSectionId;

    @ApiModelProperty(value = "栏目代码")
    private String code;

    @ApiModelProperty(value = "栏目详情")
    private ParameterDictionarys parameterDictionary;

    public void setId(String id) {
        this.id = id;
    }

    public void setPageSectionId(int pageSectionId) {
        this.pageSectionId = pageSectionId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setParameterDictionary(ParameterDictionarys parameterDictionary) {
        this.parameterDictionary = parameterDictionary;
    }

    public String getId() {
        return id;
    }

    public int getPageSectionId() {
        return pageSectionId;
    }

    public String getCode() {
        return code;
    }

    public ParameterDictionarys getParameterDictionary() {
        return parameterDictionary;
    }
}
