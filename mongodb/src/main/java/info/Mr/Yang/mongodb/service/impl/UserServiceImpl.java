package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.UserDao;
import info.Mr.Yang.mongodb.model.User;
import info.Mr.Yang.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = dao.findById(id);
        return optionalUser.orElse(null);
    }


    @Override
    public User add(User User) {
        return dao.save(User);
    }

    @Override
    public void delete(Long id) {
        Optional<User> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public User update(User User) {
        return dao.save(User);
    }
}
