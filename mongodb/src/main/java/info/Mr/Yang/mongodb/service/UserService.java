package info.Mr.Yang.mongodb.service;

import info.Mr.Yang.mongodb.model.User;

import java.util.List;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author : xiaomo
 * github: https://github.com/xiaomoinfo
 * email: xiaomo@xiaomo.info
 * <p>
 * Date: 2016/11/15 15:45
 * Copyright(©) 2015 by xiaomo.
 **/


public interface UserService {

    /**
     * 查所有
     *
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     * 根据名字查
     *
     * @param userName
     * @return
     */
    User findByName(String userName);

    /**
     * 添加
     *
     * @param User
     * @return
     */
    User add(User User);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新
     *
     * @param User
     * @return
     */
    User update(User User);

}
