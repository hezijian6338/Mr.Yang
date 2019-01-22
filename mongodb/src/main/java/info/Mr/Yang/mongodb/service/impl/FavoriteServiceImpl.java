package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.FavoriteDao;
import info.Mr.Yang.mongodb.dto.Favorites;
import info.Mr.Yang.mongodb.model.Favorite;
import info.Mr.Yang.mongodb.model.Product;
import info.Mr.Yang.mongodb.service.FavoriteService;
import info.Mr.Yang.mongodb.service.ProductService;
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
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteDao dao;

    @Autowired
    private ProductService productService;

    @Autowired
    public FavoriteServiceImpl(FavoriteDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Favorite> findAll() {
        return dao.findAll();
    }

    @Override
    public Favorite findById(String id) {
        Optional<Favorite> optionalFavorite = dao.findById(id);
        return optionalFavorite.orElse(null);
    }

    @Override
    public Favorite add(Favorite Favorite) {
        return dao.save(Favorite);
    }

    @Override
    public void delete(String id) {
        Optional<Favorite> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public Favorite update(Favorite Favorite) {
        return dao.save(Favorite);
    }

    @Override
    public Favorites findProductById(String id) {
        Favorite favorite = this.findById(id);
        Favorites favorites = new Favorites();
        favorites.setId(favorite.getId());
        List<Product> products = new ArrayList<>();
        for (String p_id : favorite.getProduct_id()) {
            products.add(productService.findById(p_id));
        }
        favorites.setProduct(products);
        return favorites;
    }

}
