package info.Mr.Yang.mongodb.dao;

import info.Mr.Yang.mongodb.model.MongoUser;
import info.Mr.Yang.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: Shop
 * @description: 实体类...
 * @author: hezijian6338
 * @create: 2019-01-10 14:00
 **/

@Repository
public interface UserDao extends MongoRepository<User, Long> {

}
