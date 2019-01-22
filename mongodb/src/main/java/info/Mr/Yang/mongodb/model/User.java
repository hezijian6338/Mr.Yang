package info.Mr.Yang.mongodb.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: xiaomo
 * @description: 用户的基础信息字段
 * @author: hezijian6338
 * @create: 2019-01-10 09:50
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
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

    @ApiModelProperty(value = "喜爱/收藏夹表的关联id")
    private String favorite_id;

    @ApiModelProperty(value = "优惠券表的关联id")
    private List<String> coupon_id;

    @ApiModelProperty(value = "收货地址的关联id")
    private List<String> addressList_id;

    public void setId(String id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setFavorite_id(String favorite_id) {
        this.favorite_id = favorite_id;
    }

    public void setAfterSaleTotal(int afterSaleTotal) {
        this.afterSaleTotal = afterSaleTotal;
    }

    public void setCoupon_id(List<String> coupon_id) {
        this.coupon_id = coupon_id;
    }

    public void setAddressList_id(List<String> addressList_id) {
        this.addressList_id = addressList_id;
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

    public String getAvatar() {
        return avatar;
    }

    public List<String> getAddressList_id() {
        return addressList_id;
    }

    public List<String> getCoupon_id() {
        return coupon_id;
    }

    public String getFavorite_id() {
        return favorite_id;
    }

    public String getId() {
        return id;
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

    public String getUserName() {
        return userName;
    }

}
