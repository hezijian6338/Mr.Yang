package info.Mr.Yang.mongodb.service.impl;

import info.Mr.Yang.mongodb.dao.SectionDao;
import info.Mr.Yang.mongodb.dto.Sections;
import info.Mr.Yang.mongodb.model.ParameterDictionary;
import info.Mr.Yang.mongodb.model.Section;
import info.Mr.Yang.mongodb.service.ParameterDictionaryService;
import info.Mr.Yang.mongodb.service.SectionService;
import net.bytebuddy.asm.Advice;
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
public class SectionServiceImpl implements SectionService {
    private final SectionDao dao;

    @Autowired
    public SectionServiceImpl(SectionDao dao) {
        this.dao = dao;
    }

    @Autowired
    private ParameterDictionaryService parameterDictionaryService;

    @Override
    public List<Section> findAll() {
        return dao.findAll();
    }

    @Override
    public Section findById(Long id) {
        Optional<Section> optionalSection = dao.findById(id);
        return optionalSection.orElse(null);
    }

    @Override
    public List<Sections> findByIds(List<String> ids) {
        List<Sections> sections_list = new ArrayList<>();
        for (String id : ids) {
            Section section = this.findById(Long.parseLong(id));
            Sections sections = this.findPD((long)section.getPd_id());
            sections.setCode(section.getCode());
            sections.setId(section.getId());
            sections.setPageSectionId(section.getPageSectionId());
            sections_list.add(sections);
        }
        return sections_list;
    }

    @Override
    public Section add(Section Section) {
        return dao.save(Section);
    }

    @Override
    public void delete(Long id) {
        Optional<Section> optional = dao.findById(id);
        if (!optional.isPresent()) {
            return;
        }
        dao.delete(optional.get());
    }

    @Override
    public void update(Section section) {
        dao.update((long)section.getId(), section);
    }

    @Override
    public Sections findPD(Long id) {
        Sections sections = new Sections();
        sections.setParameterDictionary(parameterDictionaryService.findPdsById(id));
        return sections;
    }

}
