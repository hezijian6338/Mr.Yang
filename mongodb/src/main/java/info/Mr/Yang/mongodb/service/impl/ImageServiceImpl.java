package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.ImageDao;
import info.Mr.Yang.mongodb.model.Image;
import info.Mr.Yang.mongodb.service.ImageService;
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
public class ImageServiceImpl implements ImageService {
    private final ImageDao dao;

    @Autowired
    public ImageServiceImpl(ImageDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Image> findAll() {
        return dao.findAll();
    }

    @Override
    public Image findById(String id) {
        Optional<Image> optionalSection = dao.findById(id);
        return optionalSection.orElse(null);
    }

    @Override
    public List<Image> findByIds(List<String> ids){
        List<Image> images = new ArrayList<>();
        for (String id : ids) {
            images.add(this.findById(id));
        }
        return images;
    }

    @Override
    public Image add(Image Image) {
        return dao.save(Image);
    }

    @Override
    public void delete(String id) {
        Optional<Image> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(String id, Map<String, Object> updateFieldMap) {
        dao.update(id, updateFieldMap);
    }
}
