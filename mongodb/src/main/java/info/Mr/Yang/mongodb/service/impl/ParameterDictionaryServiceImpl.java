package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.ParameterDictionaryDao;
import info.Mr.Yang.mongodb.dao.ParameterDictionaryDao;
import info.Mr.Yang.mongodb.dto.ParameterDictionarys;
import info.Mr.Yang.mongodb.model.Image;
import info.Mr.Yang.mongodb.model.ParameterDictionary;
import info.Mr.Yang.mongodb.model.ParameterDictionary;
import info.Mr.Yang.mongodb.service.ImageService;
import info.Mr.Yang.mongodb.service.ParameterDictionaryService;
import info.Mr.Yang.mongodb.service.ParameterDictionaryService;
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
public class ParameterDictionaryServiceImpl implements ParameterDictionaryService {
    private final ParameterDictionaryDao dao;

    @Autowired
    public ParameterDictionaryServiceImpl(ParameterDictionaryDao dao) {
        this.dao = dao;
    }

    @Autowired
    private ImageService imageService;

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
    public void update(ParameterDictionary parameterDictionary) {
        dao.update((long)parameterDictionary.getId(), parameterDictionary);
    }

    @Override
    public List<Image> findImage(List<String> ids) {
        // ParameterDictionarys pds = new ParameterDictionarys();
        // List<Image> image = new ArrayList<>();
        // image.add(imageService.findByIds(ids));
        return imageService.findByIds(ids);
    }

    @Override
    public ParameterDictionarys findPdsById(Long id) {
        ParameterDictionary pd = this.findById(id);
        ParameterDictionarys pds = new ParameterDictionarys();
        pds.setImagelist(this.findImage(pd.getImage()));
        pds.setBackgroundcolor(pd.getBackgroundcolor());
        pds.setBoxcolor(pd.getBoxcolor());
        pds.setBoxtype(pd.getBoxtype());
        pds.setButtonvalue(pd.getButtonvalue());
        pds.setColor(pd.getColor());
        pds.setId(pd.getId());
        pds.setImagegap(pd.getImagegap());
        pds.setKeyword(pd.getKeyword());
        pds.setPageSectionId(pd.getPageSectionId());
        pds.setType(pd.getType());
        pds.setTextalign(pd.getTextalign());
        pds.setTag(pd.getTag());
        pds.setSource(pd.getSource());
        pds.setShowtype(pd.getShowtype());
        pds.setShowsort(pd.getShowsort());
        pds.setShownumber(pd.getShownumber());
        pds.setProducttagid(pd.getProducttagid());
        pds.setProductcategoryid(pd.getProductcategoryid());
        pds.setPosition(pd.getPosition());
        return pds;
    }

}
