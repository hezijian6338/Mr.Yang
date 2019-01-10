package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.ParameterDictionaryDao;
import info.Mr.Yang.mongodb.dao.ParameterDictionaryDao;
import info.Mr.Yang.mongodb.model.ParameterDictionary;
import info.Mr.Yang.mongodb.model.ParameterDictionary;
import info.Mr.Yang.mongodb.service.ParameterDictionaryService;
import info.Mr.Yang.mongodb.service.ParameterDictionaryService;
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
public class ParameterDictionaryServiceImpl implements ParameterDictionaryService {
    private final ParameterDictionaryDao dao;

    @Autowired
    public ParameterDictionaryServiceImpl(ParameterDictionaryDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ParameterDictionary> findAll() {
        return dao.findAll();
    }

    @Override
    public ParameterDictionary findById(Long id) {
        Optional<ParameterDictionary> optionalParameterDictionary = dao.findById(id);
        return optionalParameterDictionary.orElse(null);
    }
    

    @Override
    public ParameterDictionary add(ParameterDictionary ParameterDictionary) {
        return dao.save(ParameterDictionary);
    }

    @Override
    public void delete(Long id) {
        Optional<ParameterDictionary> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public ParameterDictionary update(ParameterDictionary ParameterDictionary) {
        return dao.save(ParameterDictionary);
    }
}
