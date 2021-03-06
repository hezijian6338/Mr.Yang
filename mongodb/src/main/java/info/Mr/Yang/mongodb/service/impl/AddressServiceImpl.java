package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.AddressDao;
import info.Mr.Yang.mongodb.dao.UserDao;
import info.Mr.Yang.mongodb.model.Address;
import info.Mr.Yang.mongodb.model.User;
import info.Mr.Yang.mongodb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class AddressServiceImpl implements AddressService {
    private final AddressDao dao;

    @Autowired
    public AddressServiceImpl(AddressDao dao) {
        this.dao = dao;
    }

    @Autowired
    private UserDao userDao;

    @Override
    public List<Address> findAll() {
        return dao.findAll();
    }

    @Override
    public Address findById(String id) {
        Optional<Address> optionalAddress = dao.findById(id);
        return optionalAddress.orElse(null);
    }

    @Override
    public List<Address> findByIds(List<String> Ids) {
        List<Address> addresses = new ArrayList<>();
        for (String id : Ids) {
            addresses.add(this.findById(id));
        }
        return addresses;
    }
    

    @Override
    public Address add(Address address) {
        return dao.save(address);
    }

    @Override
    public Address _add(User user, Address address) {
        Address _address = dao.save(address);
        user.getAddressList_id().add(address.getId());
        userDao.update(user.getId(), user);
        return _address;
    }

    @Override
    public void delete(String id) {
        Optional<Address> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(Address address) {
        dao.update(address.getId(), address);
    }
}
