package info.Mr.Yang.mongodb.dao;

import info.Mr.Yang.mongodb.Base.BaseDao;
import info.Mr.Yang.mongodb.model.Cart;
import info.Mr.Yang.mongodb.model.Product;
import org.springframework.stereotype.Repository;

/**
 * @program: Shop
 * @description: 实体类...
 * @author: hezijian6338
 * @create: 2019-01-10 14:00
 **/

@Repository
public interface CartDao extends BaseDao<Cart, String> {

}
