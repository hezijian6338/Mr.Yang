package info.xiaomo.core.model;

import info.xiaomo.core.model.base.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/4/517:17
 * @Description: 网站设置
 * @Copyright(©) 2015 by xiaomo.
 **/
@Entity
@Table(name = "systemSet")
public class SystemSetModel extends BaseModel implements Serializable {

    /**
     * 站点名字
     */
    private String siteName;

    /**
     * 站点图标
     */
    private String icon;

    /**
     * footer 的开始年份
     */
    private int from;

    /**
     * footer的结束年份
     */
    private int to;

    /**
     * 备案号
     */
    private String beianNumber;
    /**
     * 备案地址
     */
    private String beianUrl;


    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getBeianUrl() {
        return beianUrl;
    }

    public void setBeianUrl(String beianUrl) {
        this.beianUrl = beianUrl;
    }

    public String getBeianNumber() {
        return beianNumber;
    }

    public void setBeianNumber(String beianNumber) {
        this.beianNumber = beianNumber;
    }
}
