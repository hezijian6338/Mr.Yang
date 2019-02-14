package info.Mr.Yang.mongodb.service.impl.ProductDetailServiceImpl.SkuDetailServiceImpl;

import info.Mr.Yang.mongodb.dao.ProductDetailDao.SkuDetail.TreeDao;
import info.Mr.Yang.mongodb.dao.ProductDetailDao.SkuDetail.TreeVDao;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.Tree;
import info.Mr.Yang.mongodb.model.ProductDetail.SkuDetail.TreeV;
import info.Mr.Yang.mongodb.service.ProductDetailService.SkuDetailService.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.*;

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
public class TreeServiceImpl implements TreeService {
    private final TreeDao dao;

    @Autowired
    public TreeServiceImpl(TreeDao dao) {
        this.dao = dao;
    }

    @Autowired
    public TreeVDao treeVDao;

    @Autowired
    public MongoTemplate mongoTemplate;

    @Override
    public List<Tree> findAll() {
        return dao.findAll();
    }

    @Override
    public Tree findById(String id) {
        Optional<Tree> optionalProduct = dao.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Tree> findByIds(List<String> Ids) {
        List<Tree> trees = new ArrayList<>();
        for (String id : Ids) {
            trees.add(this.findById(id));
        }
        return trees;
    }

    @Override
    public Tree add(Tree tree) {
        for (TreeV treeV : tree.getV()) {
            treeVDao.save(treeV);
        }
        return dao.save(tree);
    }

    @Override
    public void delete(String id) {
        Optional<Tree> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(String id, Map<String, Object> updateFieldMap) {
        dao.update(id, updateFieldMap);
        Set<String> set = updateFieldMap.keySet();
        for (String key : set) {
            if (key.equals("v")) {
                Tree tree = this.findById(id);
                List<TreeV> list = tree.getV();
                for (TreeV treeV : list) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", treeV.getName());
                    map.put("imgUrl", treeV.getImgUrl());
                    treeVDao.update(treeV.getId(), map);
                }
            }
        }
    }
}
