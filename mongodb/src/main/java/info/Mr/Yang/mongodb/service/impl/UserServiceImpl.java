package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.UserDao;
import info.Mr.Yang.mongodb.dto.UserDTO;
import info.Mr.Yang.mongodb.dto.UserIndex;
import info.Mr.Yang.mongodb.model.*;
import info.Mr.Yang.mongodb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    private AddressService addressService;

    @Autowired
    private CouponService couponService;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> optionalUser = dao.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public UserIndex findById_UserIndex(String id) {
        User user = this.findById(id);
        UserIndex userIndex = new UserIndex();
        userIndex.setId(user.getId());
        userIndex.setUserName(user.getUserName());
        userIndex.setAvatar(user.getAvatar());
        userIndex.setUnPayTotal(user.getUnPayTotal());
        userIndex.setUnRecieveTotal(user.getUnRecieveTotal());
        userIndex.setAfterSaleTotal(user.getAfterSaleTotal());
        return userIndex;
    }

    @Override
    public User add(User User) {
        return dao.save(User);
    }

    @Override
    public void delete(String id) {
        Optional<User> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(User User) {
        dao.update(User.getId(), User);
    }

    @Override
    public void update(String id, Map<String, Object> updateFieldMap) {
        dao.update(id, updateFieldMap);
    }


    @Override
    public UserDTO findUserById(String id) {
        User user = this.findById(id);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setUnPayTotal(user.getUnPayTotal());
        userDTO.setUnRecieveTotal(user.getUnRecieveTotal());
        userDTO.setAfterSaleTotal(user.getAfterSaleTotal());
        userDTO.setUserName(user.getUserName());
        List<Address> addresses = new ArrayList<>();
        for (String address_id : user.getAddressList_id()) {
            Address address = addressService.findById(address_id);
            addresses.add(address);
        }
        userDTO.setAddressList(addresses);

        List<Coupon> coupons = new ArrayList<>();
        for (String coupon_id : user.getCoupon_id()) {
            Coupon coupon = couponService.findById(coupon_id);
            coupons.add(coupon);
        }
        userDTO.setCoupon(coupons);



        return userDTO;
    }
}
