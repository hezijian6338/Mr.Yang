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
 * @description: 优惠券信息表
 * @author: hezijian6338
 * @create: 2019-01-10 10:43
 **/

@Data
@ToString(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    @Id
    private String id;

    @ApiModelProperty(value = "优惠券的名字")
    private String name;

    @ApiModelProperty(value = "优惠券起始日期")
    private String beginDate;

    @ApiModelProperty(value = "优惠券结束日期")
    private String endDate;

    @ApiModelProperty(value = "使用规定")
    private String condition;

    @ApiModelProperty(value = "迷...")
    private String signPosition;

    @ApiModelProperty(value = "优惠价值数字")
    private String coupon;

    @ApiModelProperty(value = "单位")
    private String sign;

    @ApiModelProperty(value = "使用详情/资料")
    private String info;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setSignPosition(String signPosition) {
        this.signPosition = signPosition;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCoupon() {
        return coupon;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getCondition() {
        return condition;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getInfo() {
        return info;
    }

    public String getSign() {
        return sign;
    }

    public String getSignPosition() {
        return signPosition;
    }

}
