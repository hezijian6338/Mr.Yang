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

public class UserDTO {

    private String id;

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

    @ApiModelProperty(value = "喜爱/收藏夹表")
    private List<Favorite> favorite;

    @ApiModelProperty(value = "优惠券表")
    private List<Coupon> coupon;

    @ApiModelProperty(value = "收货地址")
    private List<Address> addressList;

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUnRecieveTotal(int unRecieveTotal) {
        this.unRecieveTotal = unRecieveTotal;
    }

    public void setCoupon(List<Coupon> coupon) {
        this.coupon = coupon;
    }

    public void setUnPayTotal(int unPayTotal) {
        this.unPayTotal = unPayTotal;
    }

    public void setAfterSaleTotal(int afterSaleTotal) {
        this.afterSaleTotal = afterSaleTotal;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public void setFavorite(List<Favorite> favorite) {
        this.favorite = favorite;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getAfterSaleTotal() {
        return afterSaleTotal;
    }

    public int getUnPayTotal() {
        return unPayTotal;
    }

    public int getUnRecieveTotal() {
        return unRecieveTotal;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public List<Coupon> getCoupon() {
        return coupon;
    }

    public List<Favorite> getFavorite() {
        return favorite;
    }

}
