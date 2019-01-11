package info.Mr.Yang.mongodb.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: Shop
 * @description: 不再备注DTO了, 根据WEB来定义一样的接口
 * @author: hezijian6338
 * @create: 2019-01-11 11:08
 **/

public class UserIndex {

    private int id;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "头像信息")
    private String avatar;

    @ApiModelProperty(value = "待付款")
    private int unPayTotal;

    @ApiModelProperty(value = "待发货")
    private int unRecieveTotal;

    @ApiModelProperty(value = "售后")
    private int afterSaleTotal;

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAfterSaleTotal(int afterSaleTotal) {
        this.afterSaleTotal = afterSaleTotal;
    }

    public void setUnPayTotal(int unPayTotal) {
        this.unPayTotal = unPayTotal;
    }

    public void setUnRecieveTotal(int unRecieveTotal) {
        this.unRecieveTotal = unRecieveTotal;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public int getUnPayTotal() {
        return unPayTotal;
    }

    public int getUnRecieveTotal() {
        return unRecieveTotal;
    }

    public int getAfterSaleTotal() {
        return afterSaleTotal;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUserName() {
        return userName;
    }

}
