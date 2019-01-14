package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.PageDao;
import info.Mr.Yang.mongodb.dto.Pages;
import info.Mr.Yang.mongodb.model.Page;
import info.Mr.Yang.mongodb.service.PageService;
import info.Mr.Yang.mongodb.service.SectionService;
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
public class PageServiceImpl implements PageService {
    private final PageDao dao;

    @Autowired
    public PageServiceImpl(PageDao dao) {
        this.dao = dao;
    }

    @Autowired
    private SectionService sectionService;

    @Override
    public List<Page> findAll() {
        return dao.findAll();
    }

    @Override
    public Page findById(Long id) {
        Optional<Page> optionalPage = dao.findById(id);
        return optionalPage.orElse(null);
    }

    @Override
    public Pages findSById(Long id) {
        Page page = this.findById(id);
        Pages pages = new Pages();
        pages.setId(page.getId());
        pages.setBackgroundColor(page.getBackgroundColor());
        pages.setName(page.getName());
        pages.setSections(sectionService.findByIds(page.getSection_id()));
        return pages;
    }

    @Override
    public Page add(Page Page) {
        return dao.save(Page);
    }

    @Override
    public void delete(Long id) {
        Optional<Page> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(Page page) {
        dao.update((long)page.getId(), page);
    }
}
