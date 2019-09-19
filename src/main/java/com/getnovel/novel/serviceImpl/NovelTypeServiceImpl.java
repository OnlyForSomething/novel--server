package com.getnovel.novel.serviceImpl;


import com.getnovel.novel.dao.NovelTypeDao;
import com.getnovel.novel.pojo.NovelType;
import com.getnovel.novel.service.NovelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("NovelTypeService")
public class NovelTypeServiceImpl implements NovelTypeService {

    @Autowired
    private NovelTypeDao dao;

    @Override
    public List<NovelType> getNovelType() {
      return   dao.getNovelType();
    }

}
