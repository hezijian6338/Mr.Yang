package info.Mr.Yang.mongodb.dto;

import info.Mr.Yang.mongodb.model.Address;
import info.Mr.Yang.mongodb.model.Coupon;
import info.Mr.Yang.mongodb.model.Favorite;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: Shop
 * @description: 用户完整信息DTO
 * @author: hezijian6338
 * @create: 2019-01-10 16:13
 **/

public class userDTO {

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

    @ApiModelProperty(value = "喜爱/收藏夹表的关联id")
    private List<Favorite> favorite;

    @ApiModelProperty(value = "优惠券表的关联id")
    private List<Coupon> coupon;

    @ApiModelProperty(value = "收货地址的关联id")
    private List<Address> addressList;
}
